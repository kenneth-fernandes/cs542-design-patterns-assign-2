package numberPlay.util;

public class InputParametersData {

    private static InputParametersData inputParamsDataObj;

    private String inputFilePath;

    private String numPeaksOutFile;

    private String runAvgOutFile;

    private String topKNumOutFile;

    private int runAvgWindowSize;

    private int kValue;

    public static InputParametersData getInstance() {
        if (null == inputParamsDataObj) {
            inputParamsDataObj = new InputParametersData();
        }
        return inputParamsDataObj;
    }

    public void setInputFilePath(String path) {
        inputFilePath = path;
    }

    public String getInputFilePath() {
        return inputFilePath;
    }

    public void setNumPeaksOutFilePath(String path) {
        numPeaksOutFile = path;
    }

    public String getNumPeaksOutFilePath() {
        return numPeaksOutFile;
    }

    public void setRunAvgOutFile(String path) {
        runAvgOutFile = path;
    }

    public String runAvgOutFile() {
        return runAvgOutFile;
    }

    public void setTopKNumOutFilePath(String path) {
        topKNumOutFile = path;
    }

    public String getTopKNumOutFilePath() {
        return topKNumOutFile;
    }

    public void setRunAvgWindowSize(String windowSizeStr) throws NumberFormatException {
        runAvgWindowSize = Integer.parseInt(windowSizeStr);
    }

    public int getRunAvgWindowSize() {
        return runAvgWindowSize;
    }

    public void setKValue(String kValueStr) throws NumberFormatException {
        kValue = Integer.parseInt(kValueStr);
    }

    public int getKValue() {
        return kValue;
    }

}