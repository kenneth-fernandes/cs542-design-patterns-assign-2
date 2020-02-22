package numberPlay.observer;


import numberPlay.filter.FilterI;

public interface ObserverI {
    public void update(FilterI triggerEvntObj, String dataString);
}
