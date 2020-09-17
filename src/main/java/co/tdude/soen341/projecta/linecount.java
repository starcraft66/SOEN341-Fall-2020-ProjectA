package co.tdude.soen341.projecta;

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class linecount {
    private static File srcFile = null;
    private static String srcFilename = "<srcFilename>";

    public static void main(String[] args) throws IOException {
        // Check the number of arguments.
        // In Java, the command name 'copy' is considered as an argument.
        ArgumentParser parser = ArgumentParsers.newFor("linecount").build()
                .defaultHelp(true)
                .description("Calculate number of lines in a file.");
        parser.addArgument("src").nargs("+")
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
        for (String fname : (ArrayList<String>) ns.get("src")) {
            srcFilename = fname;
            srcFile = new File(srcFilename);
            if (!srcFile.canRead()) {
                System.out.println("copy: Cannot open srcFile '" + srcFilename + "'");
                return;
            }
            FileReader reader = new FileReader(srcFile);
            BufferedReader bufferedReader = new BufferedReader(reader);

            int c;
            int nLines = 0;

            while ((c = bufferedReader.read()) != -1) {
                // Count lines.
                if (c == '\n') ++nLines;
            }

            bufferedReader.close();
            reader.close();

            System.out.printf("%d lines\n", nLines);
        }
    }
}
