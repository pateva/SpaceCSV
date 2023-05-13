package exceptions;

public class InvalidFileException extends Exception{

    public InvalidFileException(String message) {
        System.err.println("The file is invalid");
    }
}
