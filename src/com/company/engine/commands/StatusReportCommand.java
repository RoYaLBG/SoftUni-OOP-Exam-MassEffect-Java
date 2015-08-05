package com.company.engine.commands;

import com.company.game.objects.ships.StarShip;
import com.company.interfaces.Playable;

/**
 * Created by RoYaL on 8/5/2015.
 */
public class StatusReportCommand extends Command {
    public StatusReportCommand(Playable engine) {
        super(engine);
    }

    @Override
    public void execute(String[] cmdArgs) {
        StarShip ship = this.getStarShipByName(cmdArgs[1]);

        System.out.println(ship);
    }
}
