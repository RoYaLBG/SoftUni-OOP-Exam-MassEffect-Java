package com.company.game.objects.ships;

import com.company.game.objects.locations.StarSystem;
import com.company.game.objects.projectiles.PenetrationShell;
import com.company.interfaces.Fireable;

/**
 * Created by RoYaL on 8/5/2015.
 */
public class Cruiser extends StarShip {

    protected static final int INITIAL_HEALTH = 100;
    protected static final int INITIAL_SHIELDS = 100;
    protected static final int INITIAL_DAMAGE = 50;
    protected static final int INITIAL_FUEL = 300;

    public Cruiser(String name, StarSystem location) {
        super(name, location);
        this
                .setHealth(INITIAL_HEALTH)
                .setDamage(INITIAL_DAMAGE)
                .setFuel(INITIAL_FUEL)
                .setShields(INITIAL_SHIELDS);
    }

    @Override
    public Fireable produceAttack() {
        return new PenetrationShell(this.getDamage());
    }
}
