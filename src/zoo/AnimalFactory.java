package zoo;

class AnimalFactory
{

    Animal generateAnimal(String animalName) {

        Animal newAnimal = switch (animalName) {
            case "Duck" -> new Duck();
            case "Cat" -> new Cat();
            case "Dog" -> new Dog();
            default -> throw new IllegalArgumentException();
        };

        return newAnimal;
    }


}