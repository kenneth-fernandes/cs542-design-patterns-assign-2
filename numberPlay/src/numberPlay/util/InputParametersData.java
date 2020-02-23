package numberPlay.util;

/**
 * Class that contains methods to set and retireve the argument passed through
 * command line
 */
public class InputParametersData {
    /**
     * Data members of InputParametersData containing input arguments and
     * InputParametersData object
     */
    private static InputParametersData inputParamsDataObj;

    private String inputFilePath;

    private String numPeaksOutFile;

    private String runAvgOutFile;

    private String topKNumOutFile;

    private int runAvgWindowSize;

    private int kValue;

    /**
     * Validator fetcher class
     */
    public static class ValidatorFetcher {
        /**
         * Function that validates input file path
         * 
         * @param inputParamsDataObj - Instance of InputParametersData
         * @return - Validator interface implementation of run method for validation
         */
        public static ValidatorI inputFilePathValidation(InputParametersData inputParamsDataObj) {
            return new ValidatorI() {
                @Override
                public void run() throws Exception {
                    if (inputParamsDataObj.getInputFilePath() == UtilityConstants.getInstance().EMPTY_STRING) {
                        throw new Exception(UtilityConstants.getInstance().INCORRECT_EMPTY_INPUT_FILE_PATH_MSG);
                    }
                }
            };
        }

        /**
         * Function for validating Running Average Calculation window size
         * 
         * @param inputParamsDataObj - Instance of InputParametersData
         * @return - Validator interface implementation of run method for validation
         */
        public static ValidatorI runAvgWindowSizeValidator(InputParametersData inputParamsDataObj) {
            return new ValidatorI() {
                @Override
                public void run() throws Exception {
                    if (inputParamsDataObj.runAvgWindowSize <= 0) {
                        throw new Exception(UtilityConstants.getInstance().INVALID_RUNAVG_WINDOW_SIZE_MSG);
                    }
                }
            };
        }

        /**
         * Function for validating the Running Average file path
         * 
         * @param inputParamsDataObj - Instance of InputParametersData
         * @return - Validator interface implementation of run method for validation
         */
        public static ValidatorI runAvgOutputFilePathValidation(InputParametersData inputParamsDataObj) {
            return new ValidatorI() {
                @Override
                public void run() throws Exception {
                    if (inputParamsDataObj.runAvgOutFile == UtilityConstants.getInstance().EMPTY_STRING) {
                        throw new Exception(UtilityConstants.getInstance().INCORRECT_EMPTY_RUNAVG_OUTPUT_FILE_PATH_MSG);
                    }
                }
            };
        }

        /**
         * Function for validating the K Value for Top K Numbers
         * 
         * @param inputParamsDataObj - Instance of InputParametersData
         * @return - Validator interface implementation of run method for validation
         */
        public static ValidatorI topKValueValidation(InputParametersData inputParamsDataObj) {
            return new ValidatorI() {
                @Override
                public void run() throws Exception {
                    if (inputParamsDataObj.kValue <= 0) {
                        throw new Exception(UtilityConstants.getInstance().INVALID_K_VALUE_MSG);
                    }
                }
            };
        }

        /**
         * Function to validate the output file path for writing the Top K Numbers
         * calculation
         * 
         * @param inputParamsDataObj - Instance of InputParametersData
         * @return - Validator interface implementation of run method for validation
         */
        public static ValidatorI topKOutputFilePathValidation(InputParametersData inputParamsDataObj) {
            return new ValidatorI() {
                @Override
                public void run() throws Exception {
                    if (inputParamsDataObj.topKNumOutFile == UtilityConstants.getInstance().EMPTY_STRING) {
                        throw new Exception(UtilityConstants.getInstance().INCORRECT_EMPTY_TOPK_OUTPUT_FILE_PATH_MSG);
                    }
                }
            };
        }

        /**
         * Function to validate the output file path for storing the Number Peaks
         * calculation
         * 
         * @param inputParamsDataObj - Instance of InputParametersData
         * @return - Validator interface implementation of run method for validation
         */
        public static ValidatorI numPeaksOutputFilePathValidation(InputParametersData inputParamsDataObj) {
            return new ValidatorI() {
                @Override
                public void run() throws Exception {
                    if (inputParamsDataObj.numPeaksOutFile == UtilityConstants.getInstance().EMPTY_STRING) {
                        throw new Exception(UtilityConstants.getInstance().INVALID_NUMBER_PEAKS_OUTPUT_FILE_PATH_MSG);
                    }
                }
            };
        }
    }

    /**
     * InputParametersData constructor
     * 
     * @throws Exception
     */
    private InputParametersData() throws Exception {

    }

    /**
     * Function that returns the InputParametersData singleton object
     * 
     * @return - Returns the InputParametersData object
     */
    public static InputParametersData getInstance() throws Exception {
        if (null == inputParamsDataObj) {
            inputParamsDataObj = new InputParametersData();
        }
        return inputParamsDataObj;
    }

    /**
     * Function to set Input file path
     * 
     * @param path
     */
    public void setInputFilePath(String path) {
        inputFilePath = path;
    }

    /**
     * Function to get Input file path
     * 
     * @return - Input filt path
     */
    public String getInputFilePath() {
        return inputFilePath;
    }

    /**
     * Function to set Number peaks output file path
     * 
     * @param path - Number peaks output file path
     */
    public void setNumPeaksOutFilePath(String path) {
        numPeaksOutFile = path;
    }

    /**
     * Function to get Number peaks output file path
     * 
     * @return - Number peaks output file path
     */
    public String getNumPeaksOutFilePath() {
        return numPeaksOutFile;
    }

    /**
     * Function to set Running Average output file path
     * 
     * @param path - Running Average output file path
     */
    public void setRunAvgOutFile(String path) {
        runAvgOutFile = path;
    }

    /**
     * Function to set Running Average output file path
     * 
     * @return- Running Average output file path
     */
    public String getRunAvgOutFile() {
        return runAvgOutFile;
    }

    /**
     * Function to set Top K Numbers Output file path
     * 
     * @param path - Top K Numbers Output file path
     */
    public void setTopKNumOutFilePath(String path) {
        topKNumOutFile = path;
    }

    /**
     * Function to get Top K Numbers Output file path
     * 
     * @return - Top K Numbers Output file path
     */
    public String getTopKNumOutFilePath() {
        return topKNumOutFile;
    }

    /**
     * Function to set Running Average window size
     * 
     * @param windowSizeStr - Running Average window size
     * @throws NumberFormatException - Parsing to integer error exception
     */
    public void setRunAvgWindowSize(String windowSizeStr) throws NumberFormatException {
        runAvgWindowSize = Integer.parseInt(windowSizeStr);
    }

    /**
     * Function to get Running Average window size
     * 
     * @return - Running Average window size
     */
    public int getRunAvgWindowSize() {
        return runAvgWindowSize;
    }

    /**
     * Function to set the K value for Top K Numbers
     * 
     * @param kValueStr - K value for Top K Numbers of type string
     * @throws NumberFormatException - Parsing to integer error exception
     */
    public void setKValue(String kValueStr) throws NumberFormatException {
        kValue = Integer.parseInt(kValueStr);
    }

    /**
     * Function to get the K value for Top K Numbers
     * 
     * @return - K value for Top K Numbers
     */
    public int getKValue() {
        return kValue;
    }

    public void validateInputArgs() throws Exception {
        ValidatorUtil.validate("Failure Occurred ", ValidatorFetcher.inputFilePathValidation(this),
                ValidatorFetcher.numPeaksOutputFilePathValidation(this),
                ValidatorFetcher.runAvgOutputFilePathValidation(this), ValidatorFetcher.runAvgWindowSizeValidator(this),
                ValidatorFetcher.topKOutputFilePathValidation(this), ValidatorFetcher.topKValueValidation(this));
    }

}