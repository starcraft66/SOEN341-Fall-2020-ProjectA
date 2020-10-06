package co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.impl.wcoo;

import co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.impl.strategies.CountByCharacterStrategy;
import co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.interfaces.strategies.WordCountCountStrategy;

public class CharacterCount extends EnterpriseWordCount {
    public CharacterCount(WordCountCountStrategy countByCharacterStrategy, String[] args, String banner, String appName) {
        super(countByCharacterStrategy, args, banner, appName);
    }

    public static void main(String[] args) {
        try {
            CharacterCount cc = new CharacterCount(new CountByCharacterStrategy(), args, "charcount Version 1.42b\nCopyright (C) ABC Inc 2020. All Rights Reserved.\nWritten by John Smith\n", "charcount");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
