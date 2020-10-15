package co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.interfaces.factories;

import co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.interfaces.CommandLineArgument;

/**
 * Root interface for the factory design pattern.
 * Defines methods to instantiate different types of command line objects that are used to parse command line arguments.
 */
public interface CommandLineArgumentFactory {

    /**
     * Factory method used to construct an object capable of parsing a String command line argument.
     * @param name Name used to describe the command line String value that is parsed.
     * @param help Help message that will display for the command line argument specified by parameter 'name'.
     * @return A String CommandLineArgument object that models the command line argument and is capable of parsing its value.
     */
    CommandLineArgument<String> buildStringCommandLineArgument(String name, String help);

    /**
     * Factory method used to construct an object capable of parsing a Boolean command line argument.
     * @param name Name used to describe the command line Boolean value that is parsed.
     * @param help Help message that will display for the command line argument specified by parameter 'name'.
     * @return A Boolean CommandLineArgument object that models the command line argument and is capable of parsing its value.
     */
    CommandLineArgument<Boolean> buildBooleanCommandLineArgument(String name, String help);
}
