package zoo;

class AnimalFactory
{
    /**
     * Creates and returns an instance of a specific animal.
     *
     * @param animalName The animal to generate.
     * @return the generated animal.
     */
    Animal generateAnimal(String animalName)
    {
        Animal newAnimal = switch (animalName)
                {
                    case "Duck" -> new Duck();
                    case "Cat" -> new Cat();
                    case "Dog" -> new Dog();
                    default -> null;
                };

        return newAnimal;
    }
}
