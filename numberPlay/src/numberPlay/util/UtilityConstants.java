package numberPlay.util;

public class UtilityConstants {
    private static UtilityConstants utilConstsObj;

    

    public static UtilityConstants getInstance() {
        if (null == utilConstsObj) {
            utilConstsObj = new UtilityConstants();
        }
        return utilConstsObj;
    }
}