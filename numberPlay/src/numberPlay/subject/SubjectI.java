package numberPlay.subject;

import java.util.HashMap;
import java.util.List;

import numberPlay.filter.FilterI;

import numberPlay.observer.ObserverI;

// Interface of Subject
public interface SubjectI {

    /**
     * Function that retrieves the Observer List HasMap based on the subscribed
     * events
     * 
     * @return - HashMap object of Observers list
     */
    public HashMap<FilterI, List<ObserverI>> getObserverHashMap();

    /**
     * Function that registers the Observer to a particular event
     * @param observerObj - Object of the observer class that implements Observer interface
     * @param triggerEvent - Filter obejct containing the trigger event
     */
    public void registerObserver(ObserverI observerObj, FilterI triggerEvent);

    /**
     * Function that notifies all the observer based on the trigger event filter
     * @param triggerEvent - Filter obejct containing the trigger event
     * @param dataStr - Input data of type string
     */
    public void notifyAllObservers(FilterI triggerEvent, String dataStr) throws Exception;
}
