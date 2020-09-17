package co.tdude.soen341.projecta;
import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;

import java.io.*;

public class copy {
    private static int EOF = -1;
    private static File srcFile = null;
    private static File dstFile = null;
    private static String srcFilename = "<srcFilename>";
    private static String dstFilename = "<dstFilename>";

    public static void main(String args[]) throws IOException {
		try {
			// Check the number of arguments.
			// In Java, the command name 'copy' is considered as an argument.
			ArgumentParser parser = ArgumentParsers.newFor("copy").build()
					.defaultHelp(true)
					.description("Copies a file to a destination.");
			parser.addArgument("src")
					.help("Path to the source file")
					.type(String.class)
					.required(true);
			parser.addArgument("dst")
					.help("Path to the destination file")
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
			if (ns.getString("src") != null) { // Check <src>
				srcFilename = ns.getString("src");
				System.out.println("copy: srcFilename = '" + srcFilename + "'");
				srcFile = new File(srcFilename);
				if (!srcFile.canRead()) {
					System.out.println("copy: Cannot open srcFile '" + srcFilename + "'");
					return;
				}
			} else {
				System.out.println("copy: [OK] srcFilename = '" + srcFilename + "'");
			}

			if (ns.get("dst") != null) { // Check <dst>
				dstFilename = ns.get("dst");
				dstFile = new File(dstFilename);
			} else {
				System.out.println("copy: [OK] dstFilename = '" + dstFilename + "'");
			}

			FileInputStream srcStream = new FileInputStream(srcFile);
			FileOutputStream dstStream = new FileOutputStream(dstFile);

			// Execute the copy.
			int c;

			while ((c = srcStream.read()) != EOF) {
				dstStream.write(c);
				System.out.print('.');
			}

			// Close and flush all the files.
			srcStream.close();
			dstStream.close();

			System.out.println("copy: done.");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
