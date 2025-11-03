package weather.data;

import weather.observer.IObserver;
import weather.observer.ISubject;
import java.util.ArrayList;
import java.util.List;

/**
 * The Concrete Subject class, representing the Weather Station.
 * It holds the state (measurements) and manages the list of Observers.
 * Implements ISubject to provide methods for subscription management.
 */
public class WeatherData implements ISubject {
    // List stores Observers using the interface type (crucial for Loose Coupling)
    private List<IObserver> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    // --- ISubject Implementation ---

    @Override
    public void registerObserver(IObserver o) {
        // Simple check to prevent duplicates, though optional for this assignment
        if (!observers.contains(o)) {
            observers.add(o);
            System.out.println("-> Observer registered: " + o.getClass().getSimpleName());
        }
    }

    @Override
    public void removeObserver(IObserver o) {
        observers.remove(o);
        System.out.println("<- Observer removed: " + o.getClass().getSimpleName());
    }

    @Override
    public void notifyObservers() {
        System.out.println("\n... Notifying observers about new measurements ...");
        // Iterate through all Observers and call their update method
        for (IObserver observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }

    // --- Data Management Logic ---

    /**
     * Triggers the notification process when measurements are updated.
     */
    public void measurementsChanged() {
        notifyObservers(); // The critical step in the Observer Pattern
    }

    /**
     * Sets new weather measurements and notifies all observers.
     * @param temperature New temperature
     * @param humidity New humidity
     * @param pressure New pressure
     */
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}