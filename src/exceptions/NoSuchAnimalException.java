package exceptions;

import java.util.logging.*;

public class NoSuchAnimalException extends Exception
{
    public NoSuchAnimalException(String animalName)
    {
        Logger.getLogger("LOGGER").log(Level.WARNING, "Exception: " + animalName + " is not a valid animal name.");
    }
}
