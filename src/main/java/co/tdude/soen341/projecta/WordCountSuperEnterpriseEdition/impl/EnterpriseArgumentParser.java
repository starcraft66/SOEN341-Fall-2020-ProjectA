package co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.impl;

import co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.impl.factories.EnterpriseCommandLineArgumentFactory;
import co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.interfaces.ArgumentParser;
import co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.interfaces.CommandLineArgument;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

public class EnterpriseArgumentParser implements ArgumentParser {
    protected HashMap<String, CommandLineArgument<?>> arguments = new HashMap<>();
    protected HashMap<String, Object> named = new HashMap<>();
    protected List<String> positional = new ArrayList<>();
    protected int minPositional;
    protected EnterpriseCommandLineArgumentFactory argumentFactory;

    public EnterpriseArgumentParser(int minPositional) {
        this.argumentFactory = new EnterpriseCommandLineArgumentFactory();
        //this.addArgument(argumentFactory.buildBooleanCommandLineArgument("help", "Print help message"));
        //this.addArgument(argumentFactory.buildBooleanCommandLineArgument("?"));
        this.minPositional = minPositional;
    }

    public void addArgument(CommandLineArgument<?> argument) {
        this.arguments.put(String.valueOf(argument.getName().toCharArray()[0]), argument);
    }

    public EnterpriseCommandLineArgumentFactory getArgumentFactory() {
        return this.argumentFactory;
    }

    @Override
    public HashMap<String, Object> getArguments() {
        return this.named;
    }

    public List<String> getPositional() {
        return this.positional;
    }

    @Override
    public boolean parseArguments(String[] argv) {
        // really shitty parsing, the abbreviation of a kwarg is its first letter and they can clash
        // if it doesn't start with a dash it's not a boolean I guess?
        this.named.clear();
        System.out.println(Arrays.toString(argv));
        for (int i = 0; i < argv.length; i++) {
            String arg = argv[i];
            if (arg.startsWith("-")) {
                String cleanAbs = arg.substring(1);
                if (cleanAbs.equals("?") || cleanAbs.equals("h")) {
                    printHelp();
                    return false;
                }
                CommandLineArgument<?> cla = this.arguments.get(cleanAbs);
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
        if (positional.size() < this.minPositional) {
            return false;
        }
        return true;
    }

    @Override
    public void printHelp() {
        System.out.println("Help Message:");
        System.out.println("Option: -? | -h | -help : Print help message");
        for(CommandLineArgument<?> argument : this.arguments.values()) {
            System.out.println("Option: -" + argument.getName().toCharArray()[0] + " | -" + argument.getName() + " : " + argument.getHelp());
        }
    }
}
