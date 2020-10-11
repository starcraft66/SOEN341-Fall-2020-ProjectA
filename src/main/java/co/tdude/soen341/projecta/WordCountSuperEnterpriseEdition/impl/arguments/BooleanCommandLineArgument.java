package co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.impl.arguments;

/**
 * The concrete implementation of the EnterpriseCommandLineArgument abstract class
 * and the CommandLineArgument interface used to model a command line argument of type Boolean.
 */
public class BooleanCommandLineArgument extends EnterpriseCommandLineArgument<Boolean> {

    /**
     * Constructor that initializes the name and help message for the Boolean command line argument.
     * @param name The name describing the command line argument.
     * @param help The help message for the associated command line argument name.
     */
    public BooleanCommandLineArgument(String name, String help) {
        super(name, help, ArgumentType.BOOL);
    }

    /**
     * Parses the command line argument and converts it to type Boolean.
     * @param arg The command line argument to be parsed.
     * @return The parsed command line value of type Boolean.
     */
    @Override
    public Boolean parseValue(String arg) {
        return Boolean.valueOf(arg);
    }
}
