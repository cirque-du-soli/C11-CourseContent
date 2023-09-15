/**
 *
 * @author solil
 */
public class NotYetImplementedException extends RuntimeException {
    
    public NotYetImplementedException() {
        this("No errMessage provided.");
    }
    
    public NotYetImplementedException(String errMessage) {
        super(errMessage);
    }    
    
}
