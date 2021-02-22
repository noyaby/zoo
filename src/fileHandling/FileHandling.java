package fileHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandling
{
    public static List<String> readFile(String fileName) throws FileNotFoundException
    {
        File file = new File(fileName);
        ArrayList<String> animalNames = new ArrayList<>();

        Scanner scanner = new Scanner(file);

        while (scanner.hasNext())
        {
            animalNames.add(scanner.next());
        }

        return animalNames;
    }
}
