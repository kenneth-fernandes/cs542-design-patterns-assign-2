package numberPlay.filter;

import numberPlay.util.UtilityConstants;

public class FloatingPointEventFilter implements FilterI {

    private static FloatingPointEventFilter floatPointEvntFilterObj;

    /**
     * Function that returns the object of its own class - FloatingPointEventFilter
     * 
     * @return - Object of the class FloatingPointEventFilter
     */
    public static FloatingPointEventFilter getInstance() {
        if (null == floatPointEvntFilterObj) {
            floatPointEvntFilterObj = new FloatingPointEventFilter();
        }
        return floatPointEvntFilterObj;
    }

    /**
     * Empty FloatingPointEventFilter class constructor
     */
    private FloatingPointEventFilter() {
    }

    /**
     * Function to test data for Floating point
     * 
     * @param str - Data of string type
     * @return - boolean value true or false
     */
    @Override
    public boolean test(final String str) {
        return str.matches(UtilityConstants.getInstance().FLOATING_POINT_REG_EXP_STRING);
    }

    @Override
    public String toString(){
        return "Floating Point Filter class";
    }

}