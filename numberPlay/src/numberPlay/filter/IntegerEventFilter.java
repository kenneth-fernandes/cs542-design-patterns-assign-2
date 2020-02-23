package numberPlay.filter;

import java.lang.Integer;

public class IntegerEventFilter implements FilterI {
    private static IntegerEventFilter intEvntFilterObj;

    public static IntegerEventFilter getInstance() {
        if (null == intEvntFilterObj) {
            intEvntFilterObj = new IntegerEventFilter();
        }
        return intEvntFilterObj;
    }

    private IntegerEventFilter() {
    }

    @Override
    public boolean test(final String str) {
        try {
            int num = Integer.parseInt(str);
            return (num >= Integer.MIN_VALUE) && (num <= Integer.MAX_VALUE);
        } catch (NumberFormatException ex) {
            return false;
        }
    }

}