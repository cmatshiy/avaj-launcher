package Avaj.AvajWeather;


import Avaj.AvajAircraft.Coordinates;
/**
 * tower do both registering
 *Tower deals with both registration and changing the weather for each flyable, this class passes what
 * it recieved from weatherProvider to the main Tower
 * */



public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates) {
        String weather = WeatherProvider.getProvider().getCurrentWeather(coordinates);
        return weather;
    }

    public void changeWeather() {
        this.conditionsChanged();
    }
}




