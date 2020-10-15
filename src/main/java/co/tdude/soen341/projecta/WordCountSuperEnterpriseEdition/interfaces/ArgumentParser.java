package co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.interfaces;


import co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.interfaces.factories.CommandLineArgumentFactory;

import java.util.HashMap;
import java.util.List;

/**
 * The interface for creating the basic argument parser used in this project.
 */
public interface ArgumentParser {
    /**
     * Accessor for the parser's map of named command-line arguments keyed by first letter
     * @return The map of parsed named command-line arguments
     */
    HashMap<String, Object> getArguments();

    /**
     * The function that parses command-line arguments based on the list of strings passed to the program
     * on the CLI
     * @param argv The array containing the command-line arguments passed to the program
     * @return True if the parsing was successful or False if there was a parsing failure
     */
    boolean parseArguments(String[] argv);

    /**
     * Registers a new command-line argument.
     * @param argument The CommandLineArgument to add
     */
    void addArgument(CommandLineArgument<?> argument);

    /**
     * Accessor for the parser's argument factory
     * @return The parser's EnterpriseCommandLineArgumentFactory
     */
    CommandLineArgumentFactory getArgumentFactory();

    /**
     * Accessor for the parser's list of positional command-line arguments.
     * @return The list of positional command-line arguments
     */
    List<String> getPositional();

    /**
     * Prints a help/usage message.
     */
    public void printHelp();
}
