package weather.displays;

import weather.observer.IObserver;

/**
 * A Concrete Observer that provides a basic weather forecast based on pressure.
 */
public class ForecastDisplay implements IObserver {
    private float lastPressure = 0.0f; // Stores the pressure from the previous update

    @Override
    public void update(float temp, float humidity, float pressure) {
        if (lastPressure != 0.0f) {
            display(lastPressure, pressure);
        }
        // Update the last pressure for the next comparison
        this.lastPressure = pressure;
    }

    /**
     * Provides a basic forecast based on pressure trend.
     */
    public void display(float oldPressure, float newPressure) {
        String forecast;

        if (newPressure > oldPressure) {
            forecast = "Improving weather (rising pressure).";
        } else if (newPressure < oldPressure) {
            forecast = "Cooler, wetter weather expected (falling pressure).";
        } else {
            forecast = "No significant change in weather.";
        }

        System.out.println(
                "*** Weather Forecast Display ***\n" +
                        "  Pressure Change: " + (newPressure - oldPressure) + "\n" +
                        "  Forecast: " + forecast + "\n"
        );
    }
}