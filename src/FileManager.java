import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileManager {
    public static String readFile() throws FileNotFoundException {
        File fileObj = new File("word.txt");
        Scanner reader = new Scanner(fileObj);
        String word = reader.nextLine();
        reader.close();

        return word;
    }
}