package zoo;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        readFile(args[0]);

    }

    private static void readFile(String fileName)
    {
        File file = new File(fileName);

        try {
            Scanner sc = new Scanner(file);
            AnimalFactory factory = new AnimalFactory();
            HashMap<String, Animal> animalMap = new HashMap<String, Animal>();

            while (sc.hasNext())
            {
                Animal currentAnimal = updateMap(sc.next(),factory, animalMap);
                currentAnimal.printInfo();
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: file not found");
        }

    }

    static Animal updateMap(String animalName, AnimalFactory factory, HashMap<String, Animal> map)
    {
        try {
            if (!map.containsKey(animalName))
            {
                Animal newAnimal = factory.generateAnimal(animalName);
                map.put(animalName, newAnimal);
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Error: invalid input in file.");
        }
        return map.get(animalName);
    }

}