package numberPlay.filter;

/**
 * Filter interface 
 */
public interface FilterI {
    /**
     * Function to test data
     * @param str - Data of string type
     * @return - boolean value true or false
     */
    public boolean test(String str);
}