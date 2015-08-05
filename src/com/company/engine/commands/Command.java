package com.company.engine.commands;

import com.company.game.objects.ships.StarShip;
import com.company.interfaces.Attackable;
import com.company.interfaces.Playable;

import java.util.Optional;

/**
 * Created by RoYaL on 8/5/2015.
 */
public abstract class Command {

    protected Playable engine;

    public Command(Playable engine) {
        this.engine = engine;
    }

    public abstract void execute(String[] cmdArgs);

    protected StarShip getStarShipByName(String name) {
        Optional<Attackable> ship = this.engine.getStarShips()
                .stream()
                .filter(s -> s.getName().equals(name))
                .findFirst();

        if (ship.isPresent()) {
            return (StarShip)ship.get();
        }

        return null;
    }
}
