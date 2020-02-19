package numberPlay.processing;

public class NumberProcessor {
    private static NumberProcessor numProcessorObj;

    private String integerPatternStr = "[-+]?[0-9]+";
    private String floatPatternStr = "[-+]?[0-9]+";

    public static NumberProcessor getInstance() {
        if (numProcessorObj == null) {
            numProcessorObj = new NumberProcessor();
        }
        return numProcessorObj;
    }

    public void processNumber(String numString) {
        if (numString.matches(floatPatternStr)) {
            System.out.println(Float.parseFloat(numString));
        } else {
            if (numString.matches(integerPatternStr)) {
                System.out.println(Integer.parseInt(numString));
            }
        }
    }
}