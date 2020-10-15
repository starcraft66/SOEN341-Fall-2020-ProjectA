package co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.impl.strategies;

import co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.interfaces.strategies.WordCountCountStrategy;

import java.util.logging.Logger;

/**
 * Implementation of the strategy design pattern that counts the total number of
 * characters from a specified file.
 */
public class CountByCharacterStrategy implements WordCountCountStrategy {

    /**
     * Parses the fileContent parameter source file character by character and returns the final character count.
     * @param fileContent The file source containing content to be counted.
     * @return The total number of characters that has been counted.
     */
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
