package co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.impl.wcoo;

import co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.impl.EnterpriseArgumentParser;
import co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.interfaces.ArgumentParser;
import co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.interfaces.strategies.WordCountCountStrategy;
import co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.interfaces.wcoo.IWordCount;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class EnterpriseWordCount implements IWordCount {
    protected WordCountCountStrategy wordCountCountStrategy;
    protected Level level = Level.INFO;
    protected boolean banner = false;
    protected String BANNER;
    protected StringBuilder fileContent;
    protected String appName;

    public EnterpriseWordCount(WordCountCountStrategy wordCountCountStrategy, String[] argv, String BANNER, String appName) {
        this.appName = appName;
        ArgumentParser argumentParser = new EnterpriseArgumentParser(1);
        argumentParser.addArgument(argumentParser.getArgumentFactory().buildBooleanCommandLineArgument("banner", "Print command information banner"));
        argumentParser.addArgument(argumentParser.getArgumentFactory().buildBooleanCommandLineArgument("verbose", "Print with verbose output"));
        if (!argumentParser.parseArguments(argv)) {
            System.out.println("Usage: " + this.appName + " [-?] [-b] [-v] file" );
            return;
        }
        if (argumentParser.getArguments().containsKey("v")) {
            if ((Boolean) argumentParser.getArguments().get("v")) {
                Logger.getLogger("wc").info("lol");
                this.level = Level.FINE;
            }
        }
        if (argumentParser.getArguments().containsKey("b")) {
            if ((Boolean) argumentParser.getArguments().get("b")) {
                this.banner = true;
            }
        }
        this.wordCountCountStrategy = wordCountCountStrategy;
        this.BANNER = BANNER;
        String fileName = argumentParser.getPositional().get(0);
        try {
            FileReader reader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(reader);
            this.fileContent = new StringBuilder();
            int character;
            while ((character = bufferedReader.read()) != -1) {
                fileContent.append((char) character);
            }
            int result = runCount(this.fileContent.toString());
            Logger.getLogger("").info(String.valueOf(result));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int runCount(String fileContent) {
        Logger.getLogger("").setLevel(this.level);
        for (Handler h : Logger.getLogger("").getHandlers()) {
            h.setLevel(this.level);
        }
        if (this.banner) {
            Logger.getLogger("").info(this.BANNER);
        }
        return this.wordCountCountStrategy.getCount(fileContent);
    }
}
