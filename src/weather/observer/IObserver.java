package weather.observer;

/**
 * The Observer interface (also known as Subscriber).
 * Defines the contract for an object that is interested in Subject's state changes.
 */
public interface IObserver {
    /**
     * The method called by the Subject to update the Observer's state.
     * This method is the core of the push model for the Observer Pattern.
     * * @param temp The new temperature reading.
     * @param humidity The new humidity reading.
     * @param pressure The new pressure reading.
     */
    void update(float temp, float humidity, float pressure);
}