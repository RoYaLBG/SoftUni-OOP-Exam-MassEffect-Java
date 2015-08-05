package com.company.engine.factories;

import com.company.exceptions.ShipException;
import com.company.game.objects.locations.StarSystem;
import com.company.game.objects.ships.Cruiser;
import com.company.game.objects.ships.Dreadnought;
import com.company.game.objects.ships.Frigate;
import com.company.game.objects.ships.StarShipType;
import com.company.interfaces.Attackable;

/**
 * Created by RoYaL on 8/5/2015.
 */
public class ShipFactory {

    public Attackable createShip(StarShipType type, String name, StarSystem location) throws ShipException {
        switch (type) {
            case Cruiser:
                return new Cruiser(name, location);
            case Frigate:
                return new Frigate(name, location);
            case Dreadnought:
                return new Dreadnought(name, location);
            default:
                throw new ShipException("Starship type not supported");
        }
    }
}
