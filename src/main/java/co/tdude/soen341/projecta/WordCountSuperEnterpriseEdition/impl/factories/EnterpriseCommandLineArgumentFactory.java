package co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.impl.factories;

import co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.impl.arguments.BooleanCommandLineArgument;
import co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.impl.arguments.StringCommandLineArgument;
import co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.interfaces.CommandLineArgument;
import co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.interfaces.factories.CommandLineArgumentFactory;

public class EnterpriseCommandLineArgumentFactory implements CommandLineArgumentFactory {

    @Override
    public CommandLineArgument<String> buildStringCommandLineArgument(String name, String help) {
        return new StringCommandLineArgument(name, help);
    }

    @Override
    public CommandLineArgument<Boolean> buildBooleanCommandLineArgument(String name,String help) {
        return new BooleanCommandLineArgument(name, help);
    }
}
