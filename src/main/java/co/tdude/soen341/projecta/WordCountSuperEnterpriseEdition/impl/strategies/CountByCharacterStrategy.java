package co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.impl.strategies;

import co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.interfaces.strategies.WordCountCountStrategy;

import java.util.logging.Logger;

public class CountByCharacterStrategy implements WordCountCountStrategy {
    @Override
    public int getCount(String fileContent) {
        int nChars = 0;
        for (char c : fileContent.toCharArray()) {
            ++nChars;
            Logger.getLogger("wc").fine("c");
        }
        return nChars;
    }
}
