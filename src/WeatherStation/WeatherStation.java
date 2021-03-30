package WeatherStation;

public class WeatherStation {
    public interface Subject {
        /*
        оба метода получают в аргументе реализацию Observer
        */
        public void registerObserver(Observer o);

        public void removeObserver(Observer o);

        // вызывается для оповещения наблюдателей об изменении состояния Subject
        public void notifyObservers();
    }

    public interface Observer {
        // данные перелаваемые наблюдателям при изменении состояния субъекта
        public void upadte(int temp, float humidity, float pressure);
    }

    public interface DisplayElement {
        // отображение визуального элемента
        public void display();
    }

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);

        //weatherData.setMeasurements( ,45,  30);
        weatherData.setMeasurements(80, 65, 30.4f);
    }
}
