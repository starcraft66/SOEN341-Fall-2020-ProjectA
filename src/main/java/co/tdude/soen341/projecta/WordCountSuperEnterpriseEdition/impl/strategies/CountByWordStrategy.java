package co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.impl.strategies;

import co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.interfaces.strategies.WordCountCountStrategy;

import java.util.logging.Logger;

/**
 * Implementation of the strategy design pattern that counts the total number of
 * words from a specified file.
 */
public class CountByWordStrategy implements WordCountCountStrategy {

    /**
     * Helped function that determines whether the file parser has encountered a white space.
     * If so, the strategy moves on to the next word. Otherwise, it is an indication that
     * the parser is still within a word and should not yet continue counting.
     * @param c The character that is currently being parsed.
     * @return True if the parser has encountered a white space. False if the parser is still parsing a word.
     */
    public static boolean isSpace(char c) {
        return (c == ' ' || c == '\t' || c == '\n');
    }

    /**
     * Parses the fileContent parameter source file word by word and returns the final word count.
     * @param fileContent The file source containing content to be counted.
     * @return The total number of words that have been counted in fileContent.
     */
    @Override
    public int getCount(String fileContent) {
        boolean inWord = false;

        int nWords = 0;
        for (char c : fileContent.toCharArray()) {
            if (!isSpace(c)) {
                if (!inWord) {
                    inWord = true;
                    ++nWords;
                    Logger.getLogger("").fine("w");
                }
            } else {
                inWord = false;
            }
        }
        return nWords;
    }
}
