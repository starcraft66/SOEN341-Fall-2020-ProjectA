package co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.impl.strategies;

import co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.interfaces.strategies.WordCountCountStrategy;

import java.util.logging.Logger;

/**
 * Implementation of the strategy design pattern that counts the total number of
 * lines from a specified file.
 */
public class CountByLineStrategy implements WordCountCountStrategy {

    /**
     * Parses the fileContent parameter source file line by line and returns the final line count.
     * @param fileContent The file source containing content to be counted.
     * @return The total number of lines that have been counted in fileContent.
     */
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
