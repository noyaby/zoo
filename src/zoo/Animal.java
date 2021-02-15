package zoo;

interface Animal
{
    default void printInfo()
    {
        printName();
        printSound();
    }

    void printName();
    void printSound();

}