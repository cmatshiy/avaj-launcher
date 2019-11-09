package Avaj.AvajWeather;

import Avaj.AvajAircraft.Flyable;

import java.util.ArrayList;
import java.util.List;

public class Tower {

    /**
     * list of all th flyable
     */

    private List<Flyable> observers = new ArrayList<Flyable>();
    private List<Flyable> unregistered = new ArrayList<Flyable>();

    /**
     * add flyable to observers
     * @param flyable
     */

    public void register(Flyable flyable) {
        if (observers.contains(flyable)) {
            return;
        }
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        if (observers.contains(flyable)) {
            return;
        }
        unregistered.add(flyable);
    }

    /**
     * make or change weather to flyable
     */

    protected void conditionsChanged() {
        for (Flyable flyable : observers) {
            flyable.updateConditions();
        }
        observers.removeAll(unregistered);
    }
}
