package co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.impl.arguments;

import co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.interfaces.CommandLineArgument;

/**
 * Abstract class that implements the CommandLineArgument<T> interface, which is a
 * generic interface that models a command line argument.
 * @param <T> Generic placeholder used to describe the type of the command line argument.
 */
public abstract class EnterpriseCommandLineArgument<T> implements CommandLineArgument<T> {
    /**
     * The name of the command line argument to be parsed.
     */
    protected final String name;

    /**
     * The help message associated with the command line argument name.
     */
    protected final String help;

    /**
     * The type of the command line argument, selected from an enum.
     */
    protected final ArgumentType type;

    /**
     * The parsed value returned from the command line argument.
     */
    protected T value;

    /**
     * Constructor that initializes the name, help message, and the type of the command line argument.
     * @param name The name describing the command line argument.
     * @param help The help message for the associated command line argument name.
     * @param argumentType The type of the command line argument.
     */
    public EnterpriseCommandLineArgument(String name, String help, ArgumentType argumentType) {
        this.name = name;
        this.help = help;
        this.type = argumentType;
    }

    /**
     * Gets the fully qualified name of the command line argument.
     * @return A String holding the fully qualified name of the command line argument.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Gets the help message associated with the command line argument specified.
     * @return A String containing the help message for the command line argument.
     */
    public String getHelp() {
        return help;
    }

    /**
     * Gets the parsed command line value of type T.
     * @return Parsed command line value of type T.
     */
    public T getValue() {
        return this.value;
    }

    /**
     * Sets the object's instance value to the one parsed at the command line.
     * @param value The command line argument to be parsed.
     */
    public void setValue(String value) {
        this.value = parseValue(value);
    }

    /**
     * Gets the type of the command line argument that is specified from the ArgumentType enum.
     * @return An enum value holding the type of the command line argument.
     */
    @Override
    public ArgumentType getType() {
        return this.type;
    }

    /**
     * Parses the command line argument and converts it to the specified type T.
     * @param arg The command line argument to be parsed.
     * @return The parsed command line value of type T.
     */
    public abstract T parseValue(String arg);
}
