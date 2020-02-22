package numberPlay.filter;

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
        return str.compareToIgnoreCase("PROCESSING_COMPLETE") == 0;
    }
}