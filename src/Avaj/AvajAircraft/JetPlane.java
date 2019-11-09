package Avaj.AvajAircraft;

import Avaj.AvajWeather.WeatherTower;


public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    /**
     * JetPlane constructor with arguments from the base class Aircraft
     * @param name - Gets the name passed onto it from the super class
     * @param coordinates - Gets coordinates from the super class(i.e Height, Latitude, Longitude)
     */

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    /**
     * This will request the weather from the weatherTower and based on the
     * conditions, it will modify the coordinates
     * If the height of the flyable is 0 (meaning the flight has landed)
     * it will unregister it from the weatherTower
     */
    public void updateConditions() {
        int copyHeight = this.coordinates.getHeight();
        int copyLong = this.coordinates.getLongitude();
        int copyLat = this.coordinates.getLatitude();
        String weather = this.weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "RAIN":
                this.coordinates = new Coordinates(copyLong, copyLat + 5, copyHeight);
                writer.writer("JetPlane#" + this.name + "(" + this.id + "): What a heavy RAIN for the fly ");
                break;
            case "SNOW":
                this.coordinates = new Coordinates(copyLong, copyLat, copyHeight - 7);
                writer.writer("JetPlane#" + this.name + "(" + this.id + "): Its extremely cold");
                break;
            case "FOG":
                this.coordinates = new Coordinates(copyLong, copyLat + 1, copyHeight);
                writer.writer("JetPlane#" + this.name + "(" + this.id + "): Its cold");
                break;
            case "SUN":
                this.coordinates = new Coordinates(copyLong, copyLat + 10, copyHeight + 2);
                writer.writer("JetPlane#" + this.name + "(" + this.id + "): The SUN is dangerous for the skill");
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
     * This with register this flyable(JetPlane) to the weather tower and log the message to a log file
     * @param weatherTower - registers this flyable(JetPlane) to the weather tower
     */

    public void registerTower(WeatherTower weatherTower) {
        writer.writer("Tower says: " + "JetPlane#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
        this.weatherTower = weatherTower;
        weatherTower.register(this);
    }

    public void unregisterTower(WeatherTower weatherTower) {
        writer.writer("Tower says: " + "JetPlane#" + this.name + "(" + this.id + ")" + " its landing.");
        this.weatherTower = weatherTower;
        weatherTower.unregister(this);
    }
}