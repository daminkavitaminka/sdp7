package weather.observer;

/**
 * The Subject interface (also known as Observable).
 * Defines the contract for an object that can be observed.
 */
public interface ISubject {
    /**
     * Registers an observer, adding it to the notification list.
     * @param o The observer to be added.
     */
    void registerObserver(IObserver o);

    /**
     * Removes an observer from the notification list.
     * @param o The observer to be removed.
     */
    void removeObserver(IObserver o);

    /**
     * Notifies all registered observers about changes in state.
     */
    void notifyObservers();
}