package exceptions;

public class InvalidFileException extends Exception{

    public InvalidFileException() {
        System.err.println("The file is invalid");
    }
}
