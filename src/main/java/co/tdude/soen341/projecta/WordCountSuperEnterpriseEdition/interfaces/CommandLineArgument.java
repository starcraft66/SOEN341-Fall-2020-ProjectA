package co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.interfaces;

public interface CommandLineArgument<T> {
    String getName();

    T parseValue(String arg);

    T getValue();

    public String getHelp();

    void setValue(String arg);

    ArgumentType getType();

    enum ArgumentType {
        BOOL,
        VALUE
    }
}
