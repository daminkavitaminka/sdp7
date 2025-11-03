package weather.app;

import weather.data.WeatherData;
import weather.displays.CurrentConditionsDisplay;
import weather.displays.ForecastDisplay;

/**
 * The Client application (entry point).
 * Sets up the Subject and Observers, and simulates data updates.
 */
public class WeatherStationApp {
    public static void main(String[] args) {
        // 1. Create the Subject (Publisher)
        WeatherData weatherData = new WeatherData();

        // 2. Create the Observers (Subscribers)
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay();
        ForecastDisplay forecastDisplay = new ForecastDisplay();

        // 3. Register the Observers with the Subject
        System.out.println("--- Setup: Registering Observers ---");
        weatherData.registerObserver(currentDisplay);
        weatherData.registerObserver(forecastDisplay);

        System.out.println("==================================================");

        // --- Scenario 1: First Data Change ---
        System.out.println("SCENARIO 1: First measurements arrive (25C, 65% H, 760 P)");
        weatherData.setMeasurements(25.0f, 65.0f, 760.0f);

        System.out.println("==================================================");

        // --- Scenario 2: Second Data Change ---
        System.out.println("SCENARIO 2: New measurements arrive (18C, 80% H, 755 P)");
        weatherData.setMeasurements(18.0f, 80.0f, 755.0f);

        System.out.println("==================================================");

        // --- Demonstration of Observer Removal ---
        System.out.println("--- Action: Removing CurrentConditionsDisplay ---");
        weatherData.removeObserver(currentDisplay);

        System.out.println("==================================================");

        // --- Scenario 3: Third Data Change (Only ForecastDisplay will be notified) ---
        System.out.println("SCENARIO 3: Final measurements arrive (20C, 75% H, 762 P)");
        // Note: ForecastDisplay will show "Improving weather" as 762 > 755
        weatherData.setMeasurements(20.0f, 75.0f, 762.0f);
    }
}