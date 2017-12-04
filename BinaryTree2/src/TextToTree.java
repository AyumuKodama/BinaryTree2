import java.io.*;
import java.util.*;
/**
 * This is the main driver class for the binary tree text parser program.
 * It reads a text file, parses it into a binary search tree, prints out some
 * basic statistics, and then performs a search/count for a user-specified keyword.
 */
public class TextToTree {

	public static void main(String[] args) {
		BinaryTree textTree = new BinaryTree();
		
        // The name of the file to open.
        String fileName = "./src/text.txt";

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            System.out.println("Reading file...");
            while((line = bufferedReader.readLine()) != null) {
                String[] split = line.trim().split("\\s+");
                for (String word : split) {
                	if (!word.equals("")) {
                		textTree.insert(word);
                	}
                }
            }
            System.out.println("Done.");

            // Always close files.
            bufferedReader.close();
            
            System.out.println("Tree Size: " + textTree.size());
            System.out.println("Max Depth: " + textTree.maxDepth());
            System.out.println("Min Depth: " + textTree.minDepth());
            Scanner scnr = new Scanner(System.in);
            System.out.print("Search key: ");
            String key = scnr.next();
            scnr.close();
            final long startTime = System.nanoTime();
            int count = textTree.countMatches(key);
            final long duration = System.nanoTime() - startTime;
            double secs = duration / 1e+9;
            System.out.println(key + " appears " + count + " times.");
            System.out.println(textTree.size() + " total words");
            System.out.println(secs + " seconds to search");
            
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
	}
}