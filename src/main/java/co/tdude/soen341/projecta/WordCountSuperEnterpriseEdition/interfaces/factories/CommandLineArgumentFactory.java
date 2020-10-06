package co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.interfaces.factories;

import co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.interfaces.CommandLineArgument;

public interface CommandLineArgumentFactory {
    CommandLineArgument<String> buildStringCommandLineArgument(String name, String help);

    CommandLineArgument<Boolean> buildBooleanCommandLineArgument(String name, String help);
}
