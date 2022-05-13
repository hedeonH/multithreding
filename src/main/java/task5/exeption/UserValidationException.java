package task5.exeption;

public class UserValidationException extends  RuntimeException{

    public UserValidationException(String exceptionMessage){
        super(exceptionMessage);
    }
}
