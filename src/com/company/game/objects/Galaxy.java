package com.company.game.objects;

import com.company.exceptions.InsufficientFuelException;
import com.company.exceptions.LocationOutOfRangeException;
import com.company.game.objects.locations.StarSystem;
import com.company.interfaces.Attackable;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Created by RoYaL on 8/5/2015.
 */
public class Galaxy {

    private Set<StarSystem> starSystems;

    public Galaxy() {
        this.starSystems = new HashSet<StarSystem>();
    }

    public Set<StarSystem> getStarSystems() {
        return this.starSystems;
    }

    public Optional<StarSystem> getStarSystemByName(String name) {
        return this.starSystems
                .stream()
                .filter(t -> t.getName().equals(name))
                .findFirst();
    }

    public void travelTo(Attackable object, StarSystem destination) throws Exception {
        StarSystem startLocation = object.getLocation();

        if (!startLocation.getNeighbours().containsKey(destination)) {
            throw new LocationOutOfRangeException(
                    "Cannot travel directly from " + startLocation.getName()
                    + " to " + destination.getName()
            );
        }

        double requiredFuel = startLocation.getNeighbourFuel(destination);

        if (object.getFuel() < requiredFuel) {
            throw new InsufficientFuelException(
                    "Not enough fuel to travel to "
                            + destination.getName() + " - "
                            + object.getFuel() + "/"
                            + requiredFuel
            );
        }

        object
                .spendFuel(requiredFuel)
                .setLocation(destination);
    }
}
