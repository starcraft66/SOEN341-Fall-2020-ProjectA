package co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.impl.arguments;

import co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.interfaces.CommandLineArgument;

public abstract class EnterpriseCommandLineArgument<T> implements CommandLineArgument<T> {
    protected final String name;
    protected final String help;
    protected final ArgumentType type;
    protected T value;

    public EnterpriseCommandLineArgument(String name, String help, ArgumentType argumentType) {
        this.name = name;
        this.help = help;
        this.type = argumentType;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getHelp() {
        return help;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = parseValue(value);
    }

    @Override
    public ArgumentType getType() {
        return this.type;
    }

    public abstract T parseValue(String arg);
}
