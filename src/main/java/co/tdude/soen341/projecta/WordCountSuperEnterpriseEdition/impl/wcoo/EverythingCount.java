package co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.impl.wcoo;

import co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.impl.strategies.CountByCharacterStrategy;
import co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.impl.strategies.CountByLineStrategy;
import co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.impl.strategies.CountByWordStrategy;
import co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.interfaces.strategies.WordCountCountStrategy;

import java.util.logging.Logger;

public class EverythingCount extends EnterpriseWordCount {
    public EverythingCount(WordCountCountStrategy countByCharacterStrategy, String[] args, String banner, String appName) {
        super(countByCharacterStrategy, args, banner, appName);
        this.wordCountCountStrategy = new CountByWordStrategy();
        int result = runCount(this.fileContent.toString());
        Logger.getLogger("").info(String.valueOf(result));
        this.wordCountCountStrategy = new CountByCharacterStrategy();
        result = runCount(this.fileContent.toString());
        Logger.getLogger("").info(String.valueOf(result));
    }

    public static void main(String[] args) {
        EverythingCount ec = new EverythingCount(new CountByLineStrategy(), args, "wc Version 1.42b\nCopyright (C) ABC Inc 2020. All Rights Reserved.\nWritten by John Smith\n", "wc");
    }
}
