package Avaj.AvajAircraft;

import Avaj.AvajWeather.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    /**
     * change the coordinate according the weather change
     */
    public void updateConditions() {
        int copyHeight = this.coordinates.getHeight();
        int copyLong = this.coordinates.getLongitude();
        int copyLat = this.coordinates.getLatitude();
        String weather = this.weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "RAIN":
                this.coordinates = new Coordinates(copyLong + 5, copyLat, copyHeight);
                writer.writer("Helicopter#" + this.name + "(" + this.id + "): It's Raining so what.");
                break;
            case "SNOW":
                this.coordinates = new Coordinates(copyLong, copyLat, copyHeight - 12);
                writer.writer("Helicopter#" + this.name + "(" + this.id + "): I sometimes enjoy SNOW.");
                break;
            case "FOG":
                this.coordinates = new Coordinates(copyLong + 1, copyLat, copyHeight);
                writer.writer("Helicopter#" + this.name + "(" + this.id + "): The Fog is one of the weather types");
                break;
            case "SUN":
                this.coordinates = new Coordinates(copyLong + 10, copyLat, copyHeight + 2);
                writer.writer("Helicopter#" + this.name + "(" + this.id + "): Oh my God what is this");
                break;
            default:
                writer.writer("unknown weather: ");
                break;
        }
        if (this.coordinates.getHeight() <= 0) {
            unregisterTower(this.weatherTower);
        }
    }

    /**
     * flyable registers to a weather tower
     * @param weatherTower
     */

    public void registerTower(WeatherTower weatherTower) {
        writer.writer("Tower says: " + "Helicopter#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
        this.weatherTower = weatherTower;
        weatherTower.register(this);
    }

    /**
     * flyable unregisters from the weather tower
     * @param weatherTower
     */

    public void unregisterTower(WeatherTower weatherTower) {
        writer.writer("Tower says: " + "Helicopter#" + this.name + "(" + this.id + ")" + " unregisters from weather tower and lands/ its landing.");
        this.weatherTower = weatherTower;
        weatherTower.unregister(this);
    }
}