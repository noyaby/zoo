package zoo;

import animals.*;
import exceptions.NoSuchAnimalException;

import java.util.*;


public class AnimalFactory {

    HashMap<String, Animal> animalMap = new HashMap<String, Animal>();

    public List<Animal> generateAnimals(List<String> animalNames) throws NoSuchAnimalException
    {
        List<Animal> animals = new ArrayList<>();

        for (String currentName : animalNames)
        {
            addAnimal(animals, currentName);
        }

        return animals;
    }

    private void addAnimal(List<Animal> animals, String currentName) throws NoSuchAnimalException {
        if (!animalMap.containsKey(currentName))
        {
            Animal currentAnimal = createAnimal(currentName);
            animalMap.put(currentName, currentAnimal);
        }

        animals.add(animalMap.get(currentName));
    }

    private Animal createAnimal(String animalName) throws NoSuchAnimalException
    {
        Animal newAnimal = switch (animalName) {
            case "Duck" -> new Duck();
            case "Cat" -> new Cat();
            case "Dog" -> new Dog();
            default -> throw new NoSuchAnimalException(animalName);
        };

        return newAnimal;
    }
}