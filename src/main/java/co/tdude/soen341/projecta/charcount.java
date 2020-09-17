package co.tdude.soen341.projecta;

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class charcount {
    private static File srcFile = null;
    private static String srcFilename = "<srcFilename>";

    public static void main(String[] args) throws IOException {
        // Check the number of arguments.
        // In Java, the command name 'copy' is considered as an argument.
        ArgumentParser parser = ArgumentParsers.newFor("charcount").build()
                .defaultHelp(true)
                .description("Calculate number of lines, words and characters in files.");
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
        int nChars = 0;

        while (bufferedReader.read() != -1) {
            // Count characters.
            ++nChars;
        }

        bufferedReader.close();
        reader.close();

        System.out.printf("%d characters\n", nChars);

    }
}
