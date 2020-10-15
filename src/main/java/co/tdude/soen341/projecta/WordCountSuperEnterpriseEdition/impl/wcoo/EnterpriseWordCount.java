package co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.impl.wcoo;

import co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.impl.EnterpriseArgumentParser;
import co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.interfaces.ArgumentParser;
import co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.interfaces.strategies.WordCountCountStrategy;
import co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.interfaces.wcoo.IWordCount;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;


/**
 * Abstract class serving as the skeleton of any executable in the wcOO family of programs.
 */
public abstract class EnterpriseWordCount implements IWordCount {
    static {
        InputStream stream = EnterpriseWordCount.class.getClassLoader().
                getResourceAsStream("logging.properties");
        try {
            LogManager.getLogManager().readConfiguration(stream);
//            LOGGER = Logger.getLogger(EnterpriseWordCount.class.getName());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected WordCountCountStrategy wordCountCountStrategy;
    protected Level level = Level.INFO;
    protected boolean banner = false;
    protected String BANNER;
    protected StringBuilder fileContent;
    protected String appName;
    protected boolean fail = false;

    /**
     * The constructor that initializes a counting program. It takes care of tasks like registering the relevant
     * command arguments in the argument parser, toggling flags based on parsed command-line arguments like
     * printing the information banner, printing with verbose output. It also reads the file to be processed
     * and dumps its content into a string.
     * @param wordCountCountStrategy The strategy to count the input file with (usually line, word or character)
     * @param argv The array containing the command-line arguments passed to the program
     * @param BANNER The information/copyright banner the program will use
     * @param appName The name of the program
     */
    public EnterpriseWordCount(WordCountCountStrategy wordCountCountStrategy, String[] argv, String BANNER, String appName) {
        this.appName = appName;
        ArgumentParser argumentParser = new EnterpriseArgumentParser(1);
        argumentParser.addArgument(argumentParser.getArgumentFactory().buildBooleanCommandLineArgument("banner", "Print command information banner"));
        argumentParser.addArgument(argumentParser.getArgumentFactory().buildBooleanCommandLineArgument("verbose", "Print with verbose output"));
        this.BANNER = BANNER;
        if (!argumentParser.parseArguments(argv)) {
            if (argumentParser.getArguments().containsKey("b")) {
                if ((Boolean) argumentParser.getArguments().get("b")) {
                    Logger.getLogger("").info(this.BANNER);
                    fail = true;
                    return;
                }
            }
            System.out.println("Usage: " + this.appName + " [-?] [-b] [-v] file" );
            fail = true;
            return;
        }
        if (argumentParser.getArguments().containsKey("v")) {
            if ((Boolean) argumentParser.getArguments().get("v")) {
                this.level = Level.FINE;
            }
        }
        if (argumentParser.getArguments().containsKey("b")) {
            if ((Boolean) argumentParser.getArguments().get("b")) {
                this.banner = true;
            }
        }
        this.wordCountCountStrategy = wordCountCountStrategy;
        if (this.banner) {
            Logger.getLogger("").info(this.BANNER);
        }
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

    /**
     * The method that will perform the counting operation based on the program's counting strategy.
     * It also prints the banner if needed and adjusts the logging level if needed.
     * @param fileContent The content of the file to be parsed in a String
     * @return The amount of words/lines/characters counted depending on the counting strategy
     */
    @Override
    public int runCount(String fileContent) {
        Logger.getLogger("").setLevel(this.level);
        for (Handler h : Logger.getLogger("").getHandlers()) {
            h.setLevel(this.level);
        }
        return this.wordCountCountStrategy.getCount(fileContent);
    }
}
