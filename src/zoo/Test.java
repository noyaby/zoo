package zoo;
import java.io.*;
import java.util.Scanner;

public class Test
{
    /**
     * Reads file word by word, creates an instance of an animal
     * accordingly and prints its attributes.
     *
     * @param fileName The input file to read from.
     * @return True if the whole file was read successfully, false otherwise.
     */
    public static boolean createAnimalsFromFile(String fileName)
    {
        File file = new File(fileName);

        try {
            Scanner sc = new Scanner(file);
            AnimalFactory factory = new AnimalFactory();

            /** read next word and create instance until end of file.
             * if the animal isn't valid - return false.
             */
            while (sc.hasNext())
            {
                Animal currentAnimal = factory.generateAnimal(sc.next());

                if(currentAnimal == null)
                {
                    System.out.println("Error: Illegal name");
                    return false;
                }

                currentAnimal.printName();
                currentAnimal.printSound();
            }

            return true;

        } catch(FileNotFoundException e)
        {
            // if file doesn't exist - print error message and return false
            System.out.print("Error: unable to access file");
            return false;
        }
    }


    public static void main(String[] args)
    {
        createAnimalsFromFile(args[0]);
    }
}