package co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.impl;

import co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.impl.factories.EnterpriseCommandLineArgumentFactory;
import co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.interfaces.ArgumentParser;
import co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.interfaces.CommandLineArgument;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

/**
 * Very minimalistic java command-line argument parser. It is inspired by python's argparse with a LOT less
 * functionality and many cut corners given the time frame of this project.
 * It supports registering up to 26 different command-line arguments as they are all abberviated to the first letter
 * of their name. This is a dumb optimization to speed things up. e.g. "help" is identified by its short name alias "h".
 * There can only be a single argument starting with any unique letter of the alphabet. If multiple arguments starting
 * with the same letter are provided on the command-line, the last occurrence of said letter will take precedence.
 * Once parsed, the command-line arguments can be retrieved in their respective types if there was no parsing failure.
 * Any word on the cli not starting with the - delimiter will be treated as a positional argument.
 * The parser can also automatically generate help/usage messages based on all of the arguments registered.
 */
public class EnterpriseArgumentParser implements ArgumentParser {
    protected HashMap<String, CommandLineArgument<?>> arguments = new HashMap<>();
    protected HashMap<String, Object> named = new HashMap<>();
    protected List<String> positional = new ArrayList<>();
    protected int minPositional;
    protected EnterpriseCommandLineArgumentFactory argumentFactory;

    /**
     * Constructor for the argument parser, initializes a new argument factory and sets the minimum amount of
     * positional arguments reguired.
     * @param minPositional The minimum amount of positional arguments reguired
     */
    public EnterpriseArgumentParser(int minPositional) {
        this.argumentFactory = new EnterpriseCommandLineArgumentFactory();
        //this.addArgument(argumentFactory.buildBooleanCommandLineArgument("help", "Print help message"));
        //this.addArgument(argumentFactory.buildBooleanCommandLineArgument("?"));
        this.minPositional = minPositional;
    }

    /**
     * Registers a new command-line argument, abbreviating it its first letter.
     * @param argument The CommandLineArgument to add
     */
    public void addArgument(CommandLineArgument<?> argument) {
        this.arguments.put(String.valueOf(argument.getName().toCharArray()[0]), argument);
    }

    /**
     * Accessor for the parser's argument factory
     * @return The parser's EnterpriseCommandLineArgumentFactory
     */
    public EnterpriseCommandLineArgumentFactory getArgumentFactory() {
        return this.argumentFactory;
    }

    /**
     * Accessor for the parser's map of named command-line arguments keyed by first letter
     * @return The map of parsed named command-line arguments
     */
    @Override
    public HashMap<String, Object> getArguments() {
        return this.named;
    }

    /**
     * Accessor for the parser's list of positional command-line arguments.
     * @return The list of positional command-line arguments
     */
    public List<String> getPositional() {
        return this.positional;
    }

    /**
     * Parses the array of command-line arguments into named and positional arguments
     * @param argv The array containing the command-line arguments passed to the program
     * @return True if the parsing was successful or False if there was a parsing failure
     */
    @Override
    public boolean parseArguments(String[] argv) {
        // really shitty parsing, the abbreviation of a kwarg is its first letter and they can clash
        // if it doesn't start with a dash it's not a boolean I guess?
        this.named.clear();
        System.out.println(Arrays.toString(argv));
        // Loop through argv
        for (int i = 0; i < argv.length; i++) {
            String arg = argv[i];
            // Check if it starts with the delimiter
            if (arg.startsWith("-")) {
                // Abbreviate the argument to its first letter
                String cleanAbs = arg.substring(1);
                // Check if we need to print the help message
                if (cleanAbs.equals("?") || cleanAbs.equals("h")) {
                    printHelp();
                    return false;
                }
                CommandLineArgument<?> cla = this.arguments.get(cleanAbs);
                // Check if there is a registered cli argument for this letter
                if (cla != null) {
                    if (cla.getType().equals(CommandLineArgument.ArgumentType.VALUE)) {
                        this.named.put(cleanAbs, argv[++i]); // Add the next argv and cause a skip
                        continue;
                    }
                    if (cla.getType().equals(CommandLineArgument.ArgumentType.BOOL)) {
                        this.named.put(cleanAbs, true);
                        continue;
                    }
                } else {
                    Logger.getLogger("").fine("Ignoring unknown argument " + arg);
                }
            } else {
                positional.add(argv[i]);
            }
        }
        // Check if there are enough positional arguments to satisfy the program
        if (positional.size() < this.minPositional) {
            return false;
        }
        return true;
    }

    /**
     * Prints an auto-generated help message for the program based on the registered command-line arguments.
     */
    @Override
    public void printHelp() {
        System.out.println("Help Message:");
        System.out.println("Option: -? | -h | -help : Print help message");
        for(CommandLineArgument<?> argument : this.arguments.values()) {
            System.out.println("Option: -" + argument.getName().toCharArray()[0] + " | -" + argument.getName() + " : " + argument.getHelp());
        }
    }
}
