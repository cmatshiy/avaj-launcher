package Avaj.AvajAircraft;

public class Coordinates {

    private int longitude;
    private int latitude;
    private int height;

    /**
     * upper limit height for the Aircraft it remains at 100.
     * @param longitude
     * @param latitude
     * @param height
     */

    Coordinates(int longitude, int latitude, int height) {
        this.longitude = longitude;
        this.latitude = latitude;
        if (height > 100) {
            this.height = 100;
        } else
            this.height = height;
    }

    public int getLongitude() {
        return (this.longitude);
    }

    public int getLatitude() {
        return (this.latitude);
    }

    public int getHeight() {
        return (this.height);
    }

    /**
     * increasing the height
     * @param newheight
     */
    public void increaseHeight(int newheight) {
        this.height = this.height + newheight;
    }

    public void increaseLongitude(int newLongitude) {
        this.longitude = this.longitude + newLongitude;
    }

    public void increaseLatitude(int newLatitude) {
        this.latitude = this.latitude + newLatitude;
    }

    /**
     * decreasing the height
     * @param newHeight
     */

    public void decreaseHeight(int newHeight) {
        this.height = this.height - newHeight;
    }

    public void decreaseLongitude(int newLongitude) {
        this.height = this.height - newLongitude;
    }

    public void decreaseLatitude(int newLatitude) {
        this.latitude = this.latitude - newLatitude;
    }
}


