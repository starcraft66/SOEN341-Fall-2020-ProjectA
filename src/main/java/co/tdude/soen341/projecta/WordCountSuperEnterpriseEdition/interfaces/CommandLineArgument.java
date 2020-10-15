package co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.interfaces;

/**
 * Generic interface that models a command line argument.
 * @param <T> Generic command line type that can be specified upon implementing the interface.
 */
public interface CommandLineArgument<T> {

    /**
     * Gets the fully qualified name of the command line argument.
     * @return A String holding the fully qualified name of the command line argument.
     */
    String getName();

    /**
     * Parses the command line argument and converts it to the specified type T.
     * @param arg The command line argument to be parsed.
     * @return The parsed command line value of type T.
     */
    T parseValue(String arg);

    /**
     * Gets the parsed command line value of type T.
     * @return Parsed command line value of type T.
     */
    T getValue();

    /**
     * Gets the help message associated with the command line argument specified.
     * @return A String containing the help message for the command line argument.
     */
    public String getHelp();

    /**
     * Sets the object's instance value to the one parsed at the command line.
     * @param arg The command line argument to be parsed.
     */
    void setValue(String arg);

    /**
     * Gets the type of the command line argument that is specified from the ArgumentType enum.
     * @return An enum value holding the type of the command line argument.
     */
    ArgumentType getType();

    /**
     * Enum list with the possible types of command line arguments that will be parsed.
     */
    enum ArgumentType {
        BOOL,
        VALUE
    }
}
