package Avaj.AvajAircraft;

import Avaj.AvajWriter.Writer;

public class Aircraft {
    private static long idCounter;
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    protected Writer writer = new Writer();

    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        id = nextID();
    }

    private long nextID() {
        return ++idCounter;
    }
}
