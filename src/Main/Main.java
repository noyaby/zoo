package Main;

import logger.LoggerTest;
import zoo.Animal;
import zoo.AnimalFactory;

import java.io.*;
import java.util.*;
import java.util.logging.Logger;

public class Main
{
    static final int FIRST_ARGUMENT = 0;

    public static void main(String[] args)
    {
        System.setProperty("java.util.logging.config.file",
                "C:\\Program Files\\Java\\jdk-15.0.2\\conf\\logging.properties");

        LoggerTest logger = new LoggerTest();
        AnimalFactory factory = new AnimalFactory();

        ArrayList<String> animalNames = readFile(args[FIRST_ARGUMENT]);
        ArrayList<Animal> animals = factory.parseAnimals(animalNames);
        activateAnimals(animals);

    }

    private static ArrayList<String> readFile(String fileName)
    {
        File file = new File(fileName);
        ArrayList<String> animalNames = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(file);

            while(scanner.hasNext())
            {
                animalNames.add(scanner.next());
            }

        } catch (FileNotFoundException exception) {
            System.out.println("Error: file not found");
        }

        return animalNames;
    }

    public static void activateAnimals(ArrayList<Animal> animals)
    {

        for (Animal nextAnimal : animals)
        {
            nextAnimal.printInfo();
        }
    }

}