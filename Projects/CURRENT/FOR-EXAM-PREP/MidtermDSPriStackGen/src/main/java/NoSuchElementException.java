/**
 * Custom NSEE.
 * @author Soliloquy Yarrow -- Student #2342261 JAC-FSD-08
 */
public class NoSuchElementException extends RuntimeException {

    public NoSuchElementException() {
        this("No errMessage provided.");
    }
    
    public NoSuchElementException(String errMessage) {
        super(errMessage);
    }    
    
//    public NoSuchElementException(Throwable err) {
//        this("No errMessage provided.", err);
//    }    
    
//    public NoSuchElementException(String errMessage, Throwable err) {
//        super(errMessage, err);
//    }
    
}
