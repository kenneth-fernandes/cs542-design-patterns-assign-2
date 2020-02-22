package numberPlay.util;

public class UtilityConstants {
    private static UtilityConstants utilConstsObj;

    public enum TriggerEvents {
        INTEGER_EVENT, FLOATING_POINT_EVENT, PROCESSING_COMPLETE
    };


    public static UtilityConstants getInstance() {
        if (null == utilConstsObj) {
            utilConstsObj = new UtilityConstants();
        }
        return utilConstsObj;
    }

}