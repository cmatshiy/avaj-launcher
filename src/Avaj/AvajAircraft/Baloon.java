package Avaj.AvajAircraft;


import Avaj.AvajWeather.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower NweatherTower;
    /**
     * Balloon constructor that gets name and coordinates from the base class
     * @param name - name to be assigned to the Balloon
     * @param coordinates - Coordinates to be assigned to the Balloon
     */

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }



    public void updateConditions() {
        int copyHeight = this.coordinates.getHeight();
        int copyLong = this.coordinates.getLongitude();
        int copyLat = this.coordinates.getLatitude();
        String weather = this.NweatherTower.getWeather(this.coordinates);

        /**
         * Balloon constructor that gets name and coordinates from the base class
         * @param name - name to be assigned to the Balloon
         * @param coordinates - Coordinates to be assigned to the Balloon
         */

        switch (weather) {
            case "RAIN":
                this.coordinates = new Coordinates(copyLong, copyLat, copyHeight - 5);
                writer.writer("Baloon#" + this.name + "(" + this.id + "): Ah Ah Ah Ah Ah hA the rain has stop, i would go out ");
                break;
            case "SNOW":
                this.coordinates = new Coordinates(copyLong, copyLat, copyHeight - 15);
                writer.writer("Baloon#" + this.name + "(" + this.id + "): At last the SNOW topped, what a nice weather");
                break;
            case "FOG":
                this.coordinates = new Coordinates(copyLong, copyLat, copyHeight - 3);
                writer.writer("Baloon#" + this.name + "(" + this.id + "): Fog FOG FOG why you on my way!!!.");
                break;
            case "SUN":
                this.coordinates = new Coordinates(copyLong + 2, copyLat, copyHeight + 4);
                writer.writer("Baloon#" + this.name + "(" + this.id + "): Finally some Sun, Ulra violets bouncing on me. :)");
                break;
            default:
                writer.writer("unknown weather: ");
                break;
        }
        if (this.coordinates.getHeight() <= 0) {
            unregisterTower(this.NweatherTower);
        }
    }
    /**
     * registered to weather tower
     * @param weatherTower
     */

    public void registerTower(WeatherTower weatherTower) {
        writer.writer("Tower says: " + "Baloon#" + this.name + "(" + this.id + ")" + " registered to weather tower ye.");
        this.NweatherTower = weatherTower;
        weatherTower.register(this);
    }
    /**
     * unregistered to weather tower and lands
     * @param weatherTower
     */

    public void unregisterTower(WeatherTower weatherTower) {
        writer.writer("Tower says: " + "Baloon#" + this.name + "(" + this.id + ")" + " unregisteres from weather tower and lands.");
        this.NweatherTower = weatherTower;
        weatherTower.unregister(this);
    }
}