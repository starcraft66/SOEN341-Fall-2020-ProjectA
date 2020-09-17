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

public class wc {
    private static File srcFile = null;
    private static String srcFilename = "<srcFilename>";
    private static int totalLines, totalWords, totalChars;

    public static boolean isSpace(int c) {
        return (c == ' ' || c == '\t');
    }

    public static void main(String[] args) throws IOException {
        // Check the number of arguments.
        // In Java, the command name 'copy' is considered as an argument.
        ArgumentParser parser = ArgumentParsers.newFor("wc").build()
                .defaultHelp(true)
                .description("Calculate number of lines, words and characters in files.");
        parser.addArgument("src").nargs("+")
                .help("Path to the source file(s)")
                .type(String.class)
                .required(true);
        Namespace ns = null;
        try {
            ns = parser.parseArgs(args);
        } catch (ArgumentParserException e) {
            parser.handleError(e);
            System.exit(1);
        }select room_id, count(*) as num_rows from state_groups_state group by room_id order by num_rows desc limit 10;

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

            totalLines = totalWords = totalChars = 0;
            int c;
            int nChars, nLines, nWords;
            boolean inWord = false;

            nChars = nLines = nWords = 0;

            while ((c = bufferedReader.read()) != -1) {
                // Count characters.
                ++nChars;

                // Count lines.
                if (c == '\n') ++nLines;


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

            System.out.printf("%s: %d lines, %d words, %d chars\n",
                    srcFilename, nLines, nWords, nChars);

            totalLines += nLines;
            totalWords += nWords;
            totalChars += nChars;
        }

        if (((ArrayList<?>) ns.get("src")).size() > 1) {
            System.out.printf("**Total: %d lines, %d words, %d chars\n",
                    totalLines, totalWords, totalChars);
        }
    }
}
