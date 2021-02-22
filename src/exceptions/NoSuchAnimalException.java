package exceptions;

import java.util.logging.*;

public class NoSuchAnimalException extends Exception
{
    public NoSuchAnimalException(String message)
    {
        Logger.getLogger("LOGGER").log(Level.WARNING, message);
    }

    public NoSuchAnimalException(Throwable cause)
    {
        Logger.getLogger("LOGGER").log(Level.WARNING, "An error occurred:", cause);
    }

    public NoSuchAnimalException(String message, Throwable cause)
    {
        Logger.getLogger("LOGGER").log(Level.WARNING, message, cause);
    }




}
