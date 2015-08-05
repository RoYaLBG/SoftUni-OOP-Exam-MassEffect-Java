package com.company.engine.commands;

import com.company.game.objects.enhancements.Enhancement;
import com.company.game.objects.enhancements.EnhancementType;
import com.company.game.objects.locations.StarSystem;
import com.company.game.objects.ships.StarShip;
import com.company.game.objects.ships.StarShipType;
import com.company.interfaces.Attackable;
import com.company.interfaces.Enhanceable;
import com.company.interfaces.Playable;

import java.util.Optional;

/**
 * Created by RoYaL on 8/5/2015.
 */
public class CreateCommand extends Command {

    public CreateCommand(Playable engine) {
        super(engine);
    }

    @Override
    public void execute(String[] cmdArgs) {
        StarShipType shipType = StarShipType.valueOf(cmdArgs[1]);
        String shipName = cmdArgs[2];
        Optional<StarSystem> starSystem = this.engine.getGalaxy().getStarSystemByName(cmdArgs[3]);

        StarShip existingShip = this.getStarShipByName(shipName);

        if (existingShip != null) {
            System.out.println("Ship with such name already exists");
            return;
        }


        try {
            Attackable ship = this.engine.getShipFactory().createShip(shipType, shipName, starSystem.get());

            if (cmdArgs.length > 4) {
                for (int i = 4; i < cmdArgs.length; i++) {
                    EnhancementType enhancementType = EnhancementType.valueOf(cmdArgs[i]);
                    Enhancement enhancement = this.engine.getEnhancementFactory().createEnhancement(enhancementType);
                    ((Enhanceable)ship).addEnhancement(enhancement);
                }
            }

            this.engine.getStarShips().add(ship);
            System.out.println("Created " + cmdArgs[1] + " " + shipName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
