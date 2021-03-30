package WeatherStation;

import java.util.ArrayList;

public class WeatherData implements WeatherStation.Subject {
    private ArrayList observers; //контейнер для хранения наблюдателей
    private int temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        observers = new ArrayList();
    }

    @Override
    public void registerObserver(WeatherStation.Observer o) { //добавление новых наблюдателей в конец списка
        observers.add(o);
    }

    @Override
    public void removeObserver(WeatherStation.Observer o) { //удаление наблюдателя
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() { // оповещение наблюдателя об изменении состояний
        for (int i = 0; i < observers.size(); i++) {
            WeatherStation.Observer observer = (WeatherStation.Observer) observers.get(i);
            observer.upadte(temperature, humidity, pressure);
        }
    }

    public void measurementsChanged() { //оповещение наблюдателей о появлении новых данных
        notifyObservers();
    }

    public void setMeasurements(int temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
