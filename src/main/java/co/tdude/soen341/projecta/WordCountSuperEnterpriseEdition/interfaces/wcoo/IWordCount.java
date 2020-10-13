package co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.interfaces.wcoo;

/**
 * The interface used to create the wcOO family of word counting programs
 */
public interface IWordCount {
    /**
     * Runs the word count for the specified file
     * @param fileContent The contents of the file in a String
     * @return The amount of words/characters/lines counted
     */
    int runCount(String fileContent);
}
