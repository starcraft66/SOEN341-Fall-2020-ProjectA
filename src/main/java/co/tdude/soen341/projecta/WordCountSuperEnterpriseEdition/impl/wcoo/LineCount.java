package co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.impl.wcoo;

import co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.impl.strategies.CountByLineStrategy;
import co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.interfaces.strategies.WordCountCountStrategy;

public class LineCount extends EnterpriseWordCount {
    public LineCount(WordCountCountStrategy countByCharacterStrategy, String[] args, String banner, String appName) {
        super(countByCharacterStrategy, args, banner, appName);
    }

    public static void main(String[] args) {
        CharacterCount cc = new CharacterCount(new CountByLineStrategy(), args, "linecount Version 1.42b\nCopyright (C) ABC Inc 2020. All Rights Reserved.\nWritten by John Smith\n", "linecount");
    }
}
