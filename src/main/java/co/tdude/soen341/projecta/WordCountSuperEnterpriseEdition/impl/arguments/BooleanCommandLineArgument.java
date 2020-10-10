package co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.impl.arguments;

public class BooleanCommandLineArgument extends EnterpriseCommandLineArgument<Boolean> {

    public BooleanCommandLineArgument(String name, String help) {
        super(name, help, ArgumentType.BOOL);
    }

    @Override
    public Boolean parseValue(String arg) {
        return Boolean.valueOf(arg);
    }
//test
}
