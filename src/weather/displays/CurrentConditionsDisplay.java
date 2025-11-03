package weather.displays;

import weather.observer.IObserver;

/**
 * A Concrete Observer that displays the latest temperature and humidity.
 * It is coupled only to the IObserver interface.
 */
public class CurrentConditionsDisplay implements IObserver {
    private float temperature;
    private float humidity;

    @Override
    public void update(float temp, float humidity, float pressure) {
        // Updates internal state using data pushed from the Subject
        this.temperature = temp;
        this.humidity = humidity;
        display(); // Calls the display method immediately
    }

    /**
     * Method to output the current conditions.
     */
    public void display() {
        System.out.println(
                "*** Current Conditions Display ***\n" +
                        "  Temperature: " + temperature + " °C\n" +
                        "  Humidity: " + humidity + " %\n"
        );
    }
}