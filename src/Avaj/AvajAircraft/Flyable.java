package Avaj.AvajAircraft;

import Avaj.AvajWeather.WeatherTower;

/**
    Simple interface that will be implemented by all types of aicrafts
*/
public interface Flyable {
    public void updateConditions();

    public void registerTower(WeatherTower weatherTower);

}
