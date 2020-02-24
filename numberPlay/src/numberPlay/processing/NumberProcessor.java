package numberPlay.processing;

import java.text.DecimalFormat;

import numberPlay.filter.FloatingPointEventFilter;
import numberPlay.filter.IntegerEventFilter;

import numberPlay.subject.MetricsSubject;

import numberPlay.util.UtilityConstants;

/**
 * Class for processing the string number to Integer or Float depending on the
 * type of the number
 */
public class NumberProcessor {
    // Data member of NumberProcessor storing its own object
    private static NumberProcessor numProcessorObj;

    // Data member of NumberProcessor storing the current number as string
    private String currentNumberStr;

    /**
     * Function that returns the singleton object of the NumberProcessor class
     * 
     * @return - Singleton object of NumberProcessor class
     */
    public static NumberProcessor getInstance() {
        if (numProcessorObj == null) {
            numProcessorObj = new NumberProcessor();
        }
        return numProcessorObj;
    }

    /**
     * Function tha eturns the string value of cureent number that is being
     * processed
     * 
     * @return - Current number string that is being processed
     */
    public String getCurrentNumStr() {
        return currentNumberStr;
    }

    /**
     * Empty private NumberProcessor constructor
     */
    private NumberProcessor() {
    }

    /**
     * Function that processes the current number read from the file
     * 
     * @param numString - Number in the form of string
     */
    public void processNumber(String numString) throws Exception{
        currentNumberStr = numString;

        MetricsSubject.getInstance().notifyAllObservers(FloatingPointEventFilter.getInstance(), numString);

        MetricsSubject.getInstance().notifyAllObservers(IntegerEventFilter.getInstance(), numString);

    }

    /**
     * Function to round the number
     * 
     * @param number - The number that needs to be rounded
     * @return - The rounded float value of a number
     */
    public double roundNumber(double number) {
        DecimalFormat df = new DecimalFormat(UtilityConstants.getInstance().DECIMAL_FORMAT_STRING);
        return Double.parseDouble(df.format(number));
    }

    @Override
    public String toString(){
        return "Number Processor class";
    }
}