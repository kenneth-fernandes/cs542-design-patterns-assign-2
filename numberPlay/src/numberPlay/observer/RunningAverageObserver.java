package numberPlay.observer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import numberPlay.filter.FilterI;
import numberPlay.filter.ProcessingCompleteEventFilter;
import numberPlay.processing.NumberProcessor;
import numberPlay.util.InputParametersData;
import numberPlay.util.RunningAverageData;


public class RunningAverageObserver implements ObserverI {

    private static RunningAverageObserver runningAvgObsverObj;

    private int currentNum;
    private double runningAvg;
    private RunningAverageData runningAvgResDataObj;
    private List<Integer> runningAvgLst;

    /**
     * Function to get instance of RunningAverageObserver
     * 
     * @return - The instance of the class RunningAverageObserver
     */
    public static ObserverI getInstance() {
        if (null == runningAvgObsverObj) {
            runningAvgObsverObj = new RunningAverageObserver();
        }
        return runningAvgObsverObj;
    }

    
    public RunningAverageObserver() {
        runningAvgResDataObj = RunningAverageData.getInstance();
        runningAvgLst = new ArrayList<Integer>();
    }

    @Override
    public void update(FilterI triggerEvent, String dataString) {

        if (!triggerEvent.equals(ProcessingCompleteEventFilter.getInstance())) {

            runningAvg = (double) 0;
            currentNum = Integer.parseInt(NumberProcessor.getInstance().getCurrentNumStr());

            if (runningAvgLst.size() == InputParametersData.getInstance().getRunAvgWindowSize()) {
                runningAvgLst.remove(0);
            }
            runningAvgLst.add(currentNum);

            Collections.sort(runningAvgLst);

            for (Integer number : runningAvgLst) {
                runningAvg += number;

            }
            runningAvg /= (double) runningAvgLst.size();

            runningAvgResDataObj.store(runningAvg);

        } else {
            runningAvgResDataObj.writeToFile();
            runningAvgResDataObj.close();

        }

    }
};