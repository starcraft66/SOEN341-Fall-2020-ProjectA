package co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.interfaces;


import co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.interfaces.factories.CommandLineArgumentFactory;

import java.util.HashMap;
import java.util.List;

public interface ArgumentParser {
    HashMap<String, Object> getArguments();

    boolean parseArguments(String[] argv);

    void addArgument(CommandLineArgument<?> argument);

    CommandLineArgumentFactory getArgumentFactory();

    List<String> getPositional();

    public void printHelp();
}
