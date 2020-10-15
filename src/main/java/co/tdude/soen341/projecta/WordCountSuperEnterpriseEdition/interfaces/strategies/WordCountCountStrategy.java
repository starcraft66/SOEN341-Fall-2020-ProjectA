package co.tdude.soen341.projecta.WordCountSuperEnterpriseEdition.interfaces.strategies;

/**
 * Interface that serves as the root for the strategy design pattern being implemented.
 * Several file counting implementations are to be derived from the counting strategy. Each implementation
 * will call the getCount method to return the number of counted content in the specified file.
 */
public interface WordCountCountStrategy {

    /**
     * Parses the fileContent parameter source file and returns the number of counted content.
     * @param fileContent The file source containing content to be counted.
     * @return The total number of content that has been counted.
     */
    int getCount(String fileContent);
}
