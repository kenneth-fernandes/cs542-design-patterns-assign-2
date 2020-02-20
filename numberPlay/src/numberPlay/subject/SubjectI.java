package numberPlay.subject;

import java.util.HashMap;
import java.util.List;


import numberPlay.filter.TriggerEventFilter.TriggerEvents;
import numberPlay.observer.ObserverI;

public interface SubjectI {
    
    public HashMap<Enum<TriggerEvents>, List<ObserverI>> getObserverHashMap();

    public void registerObserver(ObserverI observerObj, TriggerEvents event);

    public void notifyAllObservers(TriggerEvents event);
}
