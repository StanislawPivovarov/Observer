package WeatherStationOBS;

import java.util.Observable;
import java.util.Observer;

public class WeatherDataOBS extends Observable {
    private int temperature;
    private float humidity;
    private float pressure;

    public WeatherDataOBS() {
    }

    public void measurementsChanged() {
        setChanged();
        notifyObservers();
    }

    public void setMeasurements(int temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public int getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return temperature;
    }

    public float getPressure() {
        return pressure;
    }

}
