package numberPlay.subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import numberPlay.filter.TriggerEventFilter.TriggerEvents;
import numberPlay.observer.ObserverI;
import numberPlay.subject.SubjectI;

public class MetricsSubject implements SubjectI {

    private static SubjectI metricsSubjObj;

    HashMap<Enum<TriggerEvents>, List<ObserverI>> metricsObserverMap;

    private HashMap<Enum<TriggerEvents>, List<ObserverI>> instantiateObserverHashMap() {
        if (metricsObserverMap == null) {
            metricsObserverMap = new HashMap<Enum<TriggerEvents>, List<ObserverI>>();
        }
        return metricsObserverMap;
    }

    public static SubjectI getInstance() {
        if (null == metricsSubjObj) {
            metricsSubjObj = new MetricsSubject();
        }
        return metricsSubjObj;
    }

    public void registerObserver(ObserverI observerObj, TriggerEvents eventKey) {

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

    public void notifyObservers(String str) {
    }
}