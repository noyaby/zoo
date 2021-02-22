package zoo;

public interface Animal
{
    default void printInfo()
    {
        printName();
        printSound();
    }

    void printName();
    void printSound();

}