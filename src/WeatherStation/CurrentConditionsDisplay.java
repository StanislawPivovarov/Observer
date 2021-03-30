package WeatherStation;

import javax.security.auth.Subject;

public class CurrentConditionsDisplay implements WeatherStation.Observer, WeatherStation.DisplayElement {
    private final WeatherStation.Subject weatherData;
    private int temperature;
    private float humidity;

    public CurrentConditionsDisplay (WeatherStation.Subject weatherData){
        /*
        конструктору передается объект WeatherData, который используется для
         регистрации элемента в качестве наблюдателя
         */
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void upadte(int temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity; // сохраняем значения температуры и влажности
        display();
    }

    @Override
    public void display() { //выводит текущие значения температуры и влажности
        System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity ");
    }
}
