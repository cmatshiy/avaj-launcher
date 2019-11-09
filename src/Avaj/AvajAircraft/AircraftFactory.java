package Avaj.AvajAircraft;

/**
	the name itself shows that this is where a flyable is created and all the necessary details are passed
*/
public class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        if (longitude >= 0 && latitude >= 0 && height >= 1) {
            Coordinates coordinates = new Coordinates(longitude, latitude, height);

            String cName = type.toUpperCase();
            if (cName.equals("BALOON")) {
                return new Baloon(name, coordinates);
            } else if (cName.equals("JETPLANE")) {
                return new JetPlane(name, coordinates);
            } else if (cName.equals("HELICOPTER")) {
                return new Helicopter(name, coordinates);
            } else {
                System.out.println("Incorrect Flyable type");
                System.exit(1);
                return null;
            }
        } else {
            System.out.println("is not valid number, should not be negative or non-numeric characters");
            System.exit(1);
            return null;
        }
    }
}