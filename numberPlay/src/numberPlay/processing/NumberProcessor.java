package numberPlay.processing;

import numberPlay.filter.TriggerEventFilter.TriggerEvents;
import numberPlay.subject.MetricsSubject;

public class NumberProcessor {
    private static NumberProcessor numProcessorObj;

    private String integerPatternStr = "[-+]?[0-9]+";
    private String floatPatternStr = "[+-]?([0-9]*[.])+[0-9]+";
    private String currentNumberStr;

    public static NumberProcessor getInstance() {
        if (numProcessorObj == null) {
            numProcessorObj = new NumberProcessor();
        }
        return numProcessorObj;
    }

    public String getCurrentNumStr() {
        return currentNumberStr;
    }

    public void processNumber(String numString) {
        currentNumberStr = numString;
        if (numString.matches(floatPatternStr)) {

            MetricsSubject.getInstance().notifyAllObservers(TriggerEvents.FLOATING_POINT_EVENT);
        } else {
            if (numString.matches(integerPatternStr)) {
                MetricsSubject.getInstance().notifyAllObservers(TriggerEvents.INTEGER_EVENT);
            }
        }
    }
}