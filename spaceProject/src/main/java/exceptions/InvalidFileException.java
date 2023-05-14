package exceptions;

public class InvalidFileException extends Exception{

    /**
     * Exception to be thrown when file is invalid
     */
    public InvalidFileException() {
        System.err.println("The file is invalid");
    }
}
