package co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.impl.wcoo;

import co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.impl.strategies.CountByLineStrategy;
import co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.interfaces.strategies.WordCountCountStrategy;

/**
 * Implementation of the Line Count program using the wcOO framework.
 */
public class LineCount extends EnterpriseWordCount {
    /**
     * The character count's constructor, which simply calls the parent constructor.
     * @param countByCharacterStrategy The counting strategy
     * @param args Array containing the command-line arguments
     * @param banner The program's banner
     * @param appName The program's name
     */
    public LineCount(WordCountCountStrategy countByCharacterStrategy, String[] args, String banner, String appName) {
        super(countByCharacterStrategy, args, banner, appName);
    }

    /**
     * The character count's main method, specifying the count by line strategy, the banner and the program name.
     * @param args Array containing the command-line arguments
     */
    public static void main(String[] args) {
        EnterpriseWordCount cc = new CharacterCount(new CountByLineStrategy(), args, "linecount Version 1.42b\nCopyright (C) ABC Inc 2020. All Rights Reserved.\nWritten by John Smith\n", "linecount");
    }
}
