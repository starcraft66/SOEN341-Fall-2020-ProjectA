package co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.impl.strategies;

import co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.interfaces.strategies.WordCountCountStrategy;

import java.util.logging.Logger;

public class CountByWordStrategy implements WordCountCountStrategy {

    public static boolean isSpace(char c) {
        return (c == ' ' || c == '\t' || c == '\n');
    }

    @Override
    public int getCount(String fileContent) {
        boolean inWord = false;

        int nWords = 0;
        for (char c : fileContent.toCharArray()) {
            if (!isSpace(c)) {
                if (!inWord) {
                    inWord = true;
                    ++nWords;
                }
            } else {
                inWord = false;
            }
            Logger.getLogger("").fine("w");
        }
        return nWords;
    }
}
