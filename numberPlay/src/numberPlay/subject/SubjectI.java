package numberPlay.subject;

import numberPlay.filter.TriggerEventFilter.TriggerEvents;
import numberPlay.observer.ObserverI;

public interface SubjectI {
    public void registerObserver(ObserverI observerObj, TriggerEvents event);

    public void notifyObservers(String str);
}
