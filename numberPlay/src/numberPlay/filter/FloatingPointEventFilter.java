package numberPlay.filter;

import java.lang.Double;

public class FloatingPointEventFilter implements FilterI {

    private static FloatingPointEventFilter floatPointEvntFilterObj;
    // private BigDecimal bigDecimalNum;

    public static FloatingPointEventFilter getInstance() {
        if (null == floatPointEvntFilterObj) {
            floatPointEvntFilterObj = new FloatingPointEventFilter();
        }
        return floatPointEvntFilterObj;
    }

    private FloatingPointEventFilter() {
    }

    @Override
    public boolean test(final String str) {
        try {
            Double num = Double.parseDouble(str);
            return (num >= Double.MIN_VALUE) && (num <= Double.MAX_VALUE);
        } catch (NumberFormatException ex) {
            return false;
        }
    }

}