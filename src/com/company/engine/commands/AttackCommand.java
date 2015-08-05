package com.company.engine.commands;

import com.company.game.objects.ships.StarShip;
import com.company.interfaces.Playable;

/**
 * Created by RoYaL on 8/5/2015.
 */
public class AttackCommand extends Command {

    public AttackCommand(Playable engine) {
        super(engine);
    }

    @Override
    public void execute(String[] cmdArgs) {
        StarShip attacker = this.getStarShipByName(cmdArgs[1]);
        StarShip defender = this.getStarShipByName(cmdArgs[2]);

        if (!attacker.isAlive()) {
            System.out.println("Ship is destroyed");
            return;
        }

        if(!attacker.getLocation().getName().equals(defender.getLocation().getName())) {
            System.out.println("No such ship in star system");
            return;
        }

        defender.respondToAttack(attacker.produceAttack());

        System.out.println(attacker.getName() + " attacked " + defender.getName());

        if (!defender.isAlive()) {
            System.out.println(defender.getName() + " has been destroyed");
        }
    }
}

