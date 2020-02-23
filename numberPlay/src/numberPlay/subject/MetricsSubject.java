package numberPlay.subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import numberPlay.filter.FilterI;
import numberPlay.observer.ObserverI;
import numberPlay.subject.SubjectI;

public class MetricsSubject implements SubjectI {

    public static SubjectI metricsSubjObj;

    HashMap<FilterI, List<ObserverI>> metricsObserverMap;

    private HashMap<FilterI, List<ObserverI>> instantiateObserverHashMap() {
        if (metricsObserverMap == null) {
            metricsObserverMap = new HashMap<FilterI, List<ObserverI>>();
        }
        return metricsObserverMap;
    }

    public static SubjectI getInstance() {
        if (null == metricsSubjObj) {
            metricsSubjObj = new MetricsSubject();
        }
        return metricsSubjObj;
    }

    /**
     * Function that retrieves the Observer List HasMap based on the subscribed
     * events
     * 
     * @return - HashMap object of Observers list
     */
    @Override
    public HashMap<FilterI, List<ObserverI>> getObserverHashMap() {
        return metricsObserverMap;
    }

    /**
     * Function that registers the Observer to a particular event
     * 
     * @param observerObj  - Object of the observer class that implements Observer
     *                     interface
     * @param triggerEvent - Filter obejct containing the trigger event
     */
    @Override
    public void registerObserver(ObserverI observerObj, FilterI eventKey) {

        instantiateObserverHashMap();

        if (metricsObserverMap.containsKey(eventKey)) {
            List<ObserverI> observerLst = metricsObserverMap.get(eventKey);
            observerLst.add(observerObj);
            metricsObserverMap.put(eventKey, observerLst);
        } else {
            List<ObserverI> observerLst = new ArrayList<ObserverI>();
            observerLst.add(observerObj);
            metricsObserverMap.put(eventKey, observerLst);
        }
    }

    /**
     * Function that notifies all the observer based on the trigger event filter
     * 
     * @param triggerEvent - Filter obejct containing the trigger event
     * @param dataStr      - Input data of type string
     */
    @Override
    public void notifyAllObservers(FilterI triggerEvent, String dataStr) {

        for (Entry<FilterI, List<ObserverI>> entry : metricsObserverMap.entrySet()) {
            if (entry.getKey().test(dataStr) && entry.getKey().equals(triggerEvent)) {
                for (ObserverI observer : entry.getValue()) {
                    observer.update(entry.getKey(), dataStr);
                }
            }

        }

    }

}