package co.tdude.soen341.projecta;

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class wordcount {
    private static File srcFile = null;
    private static String srcFilename = "<srcFilename>";

    public static boolean isSpace(int c) {
        return (c == ' ' || c == '\t');
    }

    public static void main(String[] args) throws IOException {
        // Check the number of arguments.
        // In Java, the command name 'copy' is considered as an argument.
        ArgumentParser parser = ArgumentParsers.newFor("wordcount").build()
                .defaultHelp(true)
                .description("Calculate number of words in a file.");
        parser.addArgument("src")
                .help("Path to the source file(s)")
                .type(String.class)
                .required(true);
        Namespace ns = null;
        try {
            ns = parser.parseArgs(args);
        } catch (ArgumentParserException e) {
            parser.handleError(e);
            System.exit(0);
        }

        // Check if arguments are valid, if the srcFile exists, and if can create the dstFile.
        srcFilename = ns.getString("src");
        srcFile = new File(srcFilename);
        if (!srcFile.canRead()) {
            System.out.println("copy: Cannot open srcFile '" + srcFilename + "'");
            return;
        }
        FileReader reader = new FileReader(srcFile);
        BufferedReader bufferedReader = new BufferedReader(reader);

        int c;
        int nWords;
        boolean inWord = false;

        nWords = 0;

        while ((c = bufferedReader.read()) != -1) {
            // Count words.
            if (!isSpace(c)) {
                if (!inWord) {
                    inWord = true;
                    ++nWords;
                }
            } else {
                inWord = false;
            }
        }

        bufferedReader.close();
        reader.close();

        System.out.printf("%d words\n", nWords);
    }
}
