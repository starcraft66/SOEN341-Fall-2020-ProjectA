package co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.impl.arguments;

public class StringCommandLineArgument extends EnterpriseCommandLineArgument<String> {

    public StringCommandLineArgument(String name, String help) {
        super(name, help, ArgumentType.VALUE);
    }

    @Override
    public String parseValue(String arg) {
        return String.valueOf(arg);
    }

}
