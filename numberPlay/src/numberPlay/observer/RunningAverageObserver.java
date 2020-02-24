package numberPlay.observer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import numberPlay.filter.FilterI;
import numberPlay.filter.ProcessingCompleteEventFilter;

import numberPlay.processing.NumberProcessor;

import numberPlay.util.InputParametersData;
import numberPlay.util.RunningAverageData;

/**
 * Class containing methods to implement the running average functionality
 */
public class RunningAverageObserver implements ObserverI {

    // Data member of the RunningAverageObserver class for storing its own object
    private static RunningAverageObserver runningAvgObsverObj;

    // Data member of the RunningAverageObserver class for storing the current
    // number to be processed
    private int currentNum;
    // Data member of the RunningAverageObserver class for storing the running
    // average
    private double runningAvg;
    // Data member of the RunningAverageObserver class for storing the
    // RunningAverageData class object
    private RunningAverageData runningAvgResDataObj;
    // Data member of the RunningAverageObserver class for storing the List for
    // running average calculation
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

    /**
     * RunningAverageObserver constructor
     */
    private RunningAverageObserver() {
        runningAvgResDataObj = RunningAverageData.getInstance();
        runningAvgLst = new ArrayList<Integer>();
    }

    /**
     * Function that intiates the functionality of calculating the Running Average
     * 
     * @param triggerEvent - - Trigger event Filter object
     * @param dataString   - Data of type string
     */
    @Override
    public void update(FilterI triggerEvent, String dataString) throws Exception {

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

            runningAvgResDataObj.store(NumberProcessor.getInstance().roundNumber(runningAvg));

        } else {
            runningAvgResDataObj.writeToFile();
            runningAvgResDataObj.close();

        }

    }

    @Override
    public String toString() {
        return "Running Average Observer class";
    }
};