package numberPlay.filter;

import numberPlay.util.UtilityConstants;

public class IntegerEventFilter implements FilterI {
    // Data member of IntegerEventFilter storing the IntegerEventFilter class object
    private static IntegerEventFilter intEvntFilterObj;

    /**
     * Function that returns the object of its own class - IntegerEventFilter
     * 
     * @return - Object of the class IntegerEventFilter
     */
    public static IntegerEventFilter getInstance() {
        if (null == intEvntFilterObj) {
            intEvntFilterObj = new IntegerEventFilter();
        }
        return intEvntFilterObj;
    }

    /**
     * Empty IntegerEventFilter constructor
     */
    private IntegerEventFilter() {
    }

    /**
     * Function to test data for Integer
     * 
     * @param str - Data of string type
     * @return - boolean value true or false
     */
    @Override
    public boolean test(final String str) {
        return str.matches(UtilityConstants.getInstance().INTEGER_REGULAR_EXP_STRING);
    }

    @Override
    public String toString(){
        return "Integer Filter class";
    }

}