package co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.impl.strategies;

import co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.interfaces.strategies.WordCountCountStrategy;

import java.util.logging.Logger;

public class CountByLineStrategy implements WordCountCountStrategy {

    @Override
    public int getCount(String fileContent) {
        int nLines = 0;

        for (char c : fileContent.toCharArray()) {
            // Count lines.
            if (c == '\n') {
                ++nLines;
                Logger.getLogger("wc").fine("l");
            }
        }
        return nLines;
    }
}
