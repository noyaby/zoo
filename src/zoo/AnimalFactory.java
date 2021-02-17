package zoo;

import animals.*;
import exceptions.NoSuchAnimalException;
import java.util.*;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.FileHandler;


public class AnimalFactory
{

    HashMap<String, Animal> animalMap = new HashMap<>();

    Animal generateAnimal(String animalName) throws NoSuchAnimalException
    {
        Animal newAnimal = switch (animalName) {
            case "Duck" -> new Duck();
            case "Cat" -> new Cat();
            case "Dog" -> new Dog();
            default -> throw new NoSuchAnimalException(animalName);
        };

        return newAnimal;
    }

    public ArrayList<Animal> parseAnimals(ArrayList<String> animalNames)
    {
        ArrayList<Animal> animals = new ArrayList<>();
        Iterator<String> iterator = animalNames.iterator();

        try {

            while(iterator.hasNext())
            {
                String currentName = iterator.next();

                if (!animalMap.containsKey(currentName))
                {
                    Animal currentAnimal = generateAnimal(currentName);
                    animalMap.put(currentName, currentAnimal);
                }

                animals.add(animalMap.get(currentName));
            }

        } catch (NoSuchAnimalException exception) {
            System.out.println("Error: invalid input in file.");
        }

        return animals;
    }

}