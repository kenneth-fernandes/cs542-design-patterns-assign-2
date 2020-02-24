package numberPlay.observer;

import numberPlay.filter.FilterI;

/**
 * Oberserver Interface for observers to implement
 */
public interface ObserverI {
    /**
     * Function that updates the observers for further processing or implementation
     * 
     * @param triggerEvent - - Trigger event Filter object
     * @param dataString   - Data of type string
     */
    public void update(FilterI triggerEvent, String dataString) throws Exception;
}
