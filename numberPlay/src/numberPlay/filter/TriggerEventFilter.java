package numberPlay.filter;



public class TriggerEventFilter implements FilterI {

    public enum TriggerEvents {
        INTEGER_EVENT, FLOATING_POINT_EVENT, PROCESSING_COMPLETE
    };


    @Override
    public boolean test(String str) {
        // TODO
        return true;
    }
 
}