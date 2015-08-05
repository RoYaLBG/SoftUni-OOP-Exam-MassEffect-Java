package com.company.engine.commands;

import com.company.game.objects.locations.StarSystem;
import com.company.game.objects.ships.StarShip;
import com.company.interfaces.Playable;

/**
 * Created by RoYaL on 8/5/2015.
 */
public class PlotJumpCommand extends Command {
    public PlotJumpCommand(Playable engine) {
        super(engine);
    }

    @Override
    public void execute(String[] cmdArgs) {
        StarShip ship = this.getStarShipByName(cmdArgs[1]);
        StarSystem system = this.engine.getGalaxy().getStarSystemByName(cmdArgs[2]).get();

        if (!ship.isAlive()) {
            System.out.println("Ship is destroyed");
            return;
        }

        if (ship.getLocation().getName().equals(system.getName())) {
            System.out.println("Ship is already in " + system.getName());
            return;
        }

        try {
            System.out.println(ship.getName() + " jumped from " + ship.getLocation().getName() + " to " + system.getName());
            this.engine.getGalaxy().travelTo(ship, system);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
