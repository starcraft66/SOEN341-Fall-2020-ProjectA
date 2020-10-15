package co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.impl.wcoo;

import co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.impl.strategies.CountByCharacterStrategy;
import co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.impl.strategies.CountByLineStrategy;
import co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.impl.strategies.CountByWordStrategy;
import co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.interfaces.strategies.WordCountCountStrategy;

import java.util.logging.Logger;

public class EverythingCount extends EnterpriseWordCount {
    /**
     * The wc's constructor, which calls the parent constructor for the first counting strategy,
     * then runs the two other startegies.
     * @param countByCharacterStrategy The counting strategy
     * @param args Array containing the command-line arguments
     * @param banner The program's banner
     * @param appName The program's name
     */
    public EverythingCount(WordCountCountStrategy countByCharacterStrategy, String[] args, String banner, String appName) {
        super(countByCharacterStrategy, args, banner, appName);
        if (!this.fail) {
            this.banner = false;
            this.wordCountCountStrategy = new CountByWordStrategy();
            int result = runCount(this.fileContent.toString());
            Logger.getLogger("").info(String.valueOf(result));
            this.wordCountCountStrategy = new CountByCharacterStrategy();
            result = runCount(this.fileContent.toString());
            Logger.getLogger("").info(String.valueOf(result));
        }
    }

    /**
     * The wc's main method, specifying the count by line strategy, the banner and the program name.
     * @param args Array containing the command-line arguments
     */
    public static void main(String[] args) {
        EnterpriseWordCount ec = new EverythingCount(new CountByLineStrategy(), args, "wc Version 1.42b\nCopyright (C) ABC Inc 2020. All Rights Reserved.\nWritten by John Smith\n", "wc");
    }
}
