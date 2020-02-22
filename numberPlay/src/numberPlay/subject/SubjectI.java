package numberPlay.subject;

import java.util.HashMap;
import java.util.List;

import numberPlay.filter.FilterI;

import numberPlay.observer.ObserverI;

public interface SubjectI {

    public HashMap<FilterI, List<ObserverI>> getObserverHashMap();

    public void registerObserver(ObserverI observerObj, FilterI event);

    public void notifyAllObservers(FilterI event, String dataStr);
}
