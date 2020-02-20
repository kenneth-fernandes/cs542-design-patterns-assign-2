package numberPlay.observer;


import numberPlay.filter.TriggerEventFilter.TriggerEvents;

public interface ObserverI {
    public void update(TriggerEvents event);
}
