package co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.impl.arguments;

/**
 * The concrete implementation of the EnterpriseCommandLineArgument abstract class
 * and the CommandLineArgument interface used to model a command line argument of type String.
 */
public class StringCommandLineArgument extends EnterpriseCommandLineArgument<String> {

    /**
     * Constructor that initializes the name and help message for the String command line argument.
     * @param name The name describing the command line argument.
     * @param help The help message for the associated command line argument name.
     */
    public StringCommandLineArgument(String name, String help) {
        super(name, help, ArgumentType.VALUE);
    }

    /**
     * Parses the command line argument and converts it to type String.
     * @param arg The command line argument to be parsed.
     * @return The parsed command line value of type String.
     */
    @Override
    public String parseValue(String arg) {
        return String.valueOf(arg);
    }

}
