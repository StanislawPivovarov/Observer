package WeatherStationOBS;

import WeatherStation.WeatherStation;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplayOBS implements Observer, WeatherStation.DisplayElement {
    Observable observable;
    private int temperature;
    private float humidity;

    public CurrentConditionsDisplayOBS(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
    }
    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
    }

    @Override
    public void update(Observable o, Object arg) {
        if(observable instanceof WeatherDataOBS){
            WeatherDataOBS weatherDataOBS = (WeatherDataOBS)observable;
            this.temperature = weatherDataOBS.getTemperature();
            this.humidity = weatherDataOBS.getHumidity();
            display();
        }
    }
}
