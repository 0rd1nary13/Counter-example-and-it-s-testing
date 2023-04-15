//a runtime exception that signals that the counter could not be created

public class CounterInitializationException extends RuntimeException{
    public CounterInitializationException(String message){
        super(message);
    }
}
