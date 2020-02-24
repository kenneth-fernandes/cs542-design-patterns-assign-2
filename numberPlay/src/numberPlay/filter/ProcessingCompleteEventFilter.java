package numberPlay.filter;

import numberPlay.util.UtilityConstants;

public class ProcessingCompleteEventFilter implements FilterI {

    //Data member of ProcessingCompleteEventFilter storing its own object - ProcessingCompleteEventFilter
    private static ProcessingCompleteEventFilter processCompleteEvntFilterObj;

    /**
     * Function returns the singleton object of ProcessingCompleteEventFilter class
     * @return - Object of ProcessingCompleteEventFilter class
     */
    public static ProcessingCompleteEventFilter getInstance() {
        if (null == processCompleteEvntFilterObj) {
            processCompleteEvntFilterObj = new ProcessingCompleteEventFilter();
        }
        return processCompleteEvntFilterObj;
    }

    /**
     * Empty ProcessingCompleteEventFilter constructor
     */
    private ProcessingCompleteEventFilter() {
    }

    /**
     * Function to test data for Processing complete
     * 
     * @param str - Data of string type
     * @return - boolean value true or false
     */
    @Override
    public boolean test(String str) {
        return (str.compareToIgnoreCase(UtilityConstants.getInstance().PROCESSING_COMPLETE_EVENT) == 0);
    }

    @Override
    public String toString(){
        return "Processing Complete Filter class";
    }
}