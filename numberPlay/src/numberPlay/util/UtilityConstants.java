package numberPlay.util;

public class UtilityConstants {
    // Object of class UtilityConstants
    private static UtilityConstants utilConstsObj;

    /**
     * Driver class constants
     */
    public final String INPUT_FILEPATH_ARG = "${inputNumStream}";
    public final String RUNNING_AVG_WINDOW_SIZE_INPUT_ARG = "${runAvgWindowSize}";
    public final String RUNNING_AVG_OUTPUT_FILEPATH_ARG = "${runAvgOutFile}";
    public final String K_VALUE_ARG = "${k}";
    public final String TOP_K_NUMBERS_OUTPUT_FILEPATH_ARG = "${topKNumOutFile}";
    public final String NUMBER_PEAKS_OUTPUT_FILEPATH_ARG = "${numPeaksOutFile}";
    public final String INVALID_ARGUMENTS_ERROR_MESSAGE = "Error: Incorrect number of arguments. Program accepts %d arguments.";

    /**
     * Trigger events constants
     */
    public final String INTEGER_EVENT = "INTEGER EVENT";
    public final String FLOATING_POINT_EVENT = "FLOATING_POINT_EVENT";
    public final String PROCESSING_COMPLETE_EVENT = "PROCESSING_COMPLETE_EVENT";

    /**
     * Exception message constants
     */
    public final String INVALID_INPUT_FILEPATH_ERR_MESSAGE = "invalid input file or input file in incorrect location";
    public final String INVALID_OUTPUT_FILEPATH_ERR_MESSAGE = "invalid output file or output file in incorrect location";
    public final String FILECLOSE_FAILURE_ERR_MESSAGE = "Error: Error while processing and closing the file.";

    /**
     * Queue implementation constants
     */
    public final String QUEUE_EMPTY_MSG = "Queue is empty.";
    public final String QUEUE_FULL_MSG = "Queue is full.";

    /**
     * Metrics calculation constants
     */
    public final String DECIMAL_FORMAT_STRING = "#.##";

    /**
     * Regular Expression constants
     */
    public final String INTEGER_REGULAR_EXP_STRING = "[-+]?[0-9]+";
    public final String FLOATING_POINT_REG_EXP_STRING = "[+-]?[0-9]*\\.+[0-9]+";

    /**
     * Util string constants
     */
    public final String EMPTY_STRING = "";
    public final String NEWLINE_STRING = "\n";

    /**
     * 
     * Validation message constants
     */

    public final String INCORRECT_EMPTY_INPUT_FILE_PATH_MSG = "Input file path is incorrect or empty.";
    public final String INVALID_RUNAVG_WINDOW_SIZE_MSG = "Please enter a valid size for Running Average window size.";
    public final String INCORRECT_EMPTY_RUNAVG_OUTPUT_FILE_PATH_MSG = "Running average output file path is incorrect or empty.";
    public final String INVALID_K_VALUE_MSG = "Please enter a valid size for find int the Top K Numbers.";
    public final String INCORRECT_EMPTY_TOPK_OUTPUT_FILE_PATH_MSG = "Top K Numbers output file path is incorrect or empty.";
    public final String INVALID_NUMBER_PEAKS_OUTPUT_FILE_PATH_MSG = "Number Peaks output file path is incorrect or empty.";
    public final String FAILURE_OCCURED = "Failure Occurred ";

    /**
     * Function that returns the singleton object of UtilityConstants class itself
     * 
     * @return - Object of UtilityConstants class
     */
    public static UtilityConstants getInstance() {
        if (null == utilConstsObj) {
            utilConstsObj = new UtilityConstants();
        }
        return utilConstsObj;
    }

    @Override
    public String toString() {
        return "Utility Constants class";
    }

}