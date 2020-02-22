package numberPlay.filter;

import numberPlay.util.UtilityConstants;

public class ProcessingCompleteEventFilter implements FilterI {

    private static ProcessingCompleteEventFilter processCompleteEvntFilterObj;

    public static ProcessingCompleteEventFilter getInstance() {
        if (null == processCompleteEvntFilterObj) {
            processCompleteEvntFilterObj = new ProcessingCompleteEventFilter();
        }
        return processCompleteEvntFilterObj;
    }

    @Override
    public boolean test(String str) {
        return str.compareToIgnoreCase(UtilityConstants.getInstance().PROCESSING_COMPLETE_EVENT) == 0;
    }
}