package Main;

import exceptions.NoSuchAnimalException;
import zoo.Animal;
import zoo.AnimalFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static fileHandling.FileHandling.readFile;

public class Main {

    public static void main(String[] args) {
        final String FILE_PATH = args[0];

        try {
            AnimalFactory factory = new AnimalFactory();

            List<String> animalNames = readFile(FILE_PATH);
            List<Animal> animals = factory.generateAnimals(animalNames);
            activateAnimals(animals);

        } catch (FileNotFoundException fileException) {
            System.out.println("Error: No such file");
        } catch (NoSuchAnimalException animalException) {
            System.out.println("Error: No such animal");
        }
    }

    public static void activateAnimals(List<Animal> animals)
    {
        for (Animal nextAnimal : animals)
        {
            nextAnimal.printInfo();
        }
    }

}