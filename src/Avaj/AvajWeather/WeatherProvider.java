package Avaj.AvajWeather;

import Avaj.AvajAircraft.Coordinates;

import java.util.Random;

/**
 * its provides the types of the weather (RAIN, FOG, SUN, SNOW)
 * the select random
 * */

public class WeatherProvider {
    private static WeatherProvider weatherProvider = null;
    private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider() {
    }

    public static WeatherProvider getProvider() {
        if (weatherProvider == null)
            weatherProvider = new WeatherProvider();
        return (weatherProvider);
    }

    public String getCurrentWeather(Coordinates coordinates) {
        Random randWeather = new Random();
        int nwWeather = 0;
        nwWeather = randWeather.nextInt(4);
        return (weather[nwWeather]);
    }
}

