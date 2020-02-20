package numberPlay.processing;

import numberPlay.filter.TriggerEventFilter;
import numberPlay.subject.MetricsSubject;

public class NumberProcessor {
    private static NumberProcessor numProcessorObj;

    private String integerPatternStr = "[-+]?[0-9]+";
    private String floatPatternStr = "[+-]?([0-9]*[.])+[0-9]+";

    public static NumberProcessor getInstance() {
        if (numProcessorObj == null) {
            numProcessorObj = new NumberProcessor();
        }
        return numProcessorObj;
    }

    public void processNumber(String numString) {
        if (numString.matches(floatPatternStr)) {
            MetricsSubject.getInstance().notifyAllObservers(TriggerEventFilter.TriggerEvents.FLOATING_POINT_EVENT);
        } else {
            if (numString.matches(integerPatternStr)) {
                MetricsSubject.getInstance().notifyAllObservers(TriggerEventFilter.TriggerEvents.INTEGER_EVENT);
            }
        }
    }
}