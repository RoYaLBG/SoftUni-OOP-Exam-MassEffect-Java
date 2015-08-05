package com.company.game.objects.ships;

import com.company.game.objects.locations.StarSystem;
import com.company.game.objects.projectiles.ShieldReaver;
import com.company.interfaces.Fireable;

/**
 * Created by RoYaL on 8/5/2015.
 */
public class Frigate extends StarShip {

    protected static final int INITIAL_HEALTH = 60;
    protected static final int INITIAL_SHIELDS = 50;
    protected static final int INITIAL_DAMAGE = 30;
    protected static final int INITIAL_FUEL = 220;

    private int firedProjectiles = 0;

    public Frigate(String name, StarSystem location) {
        super(name, location);
        this
                .setHealth(INITIAL_HEALTH)
                .setDamage(INITIAL_DAMAGE)
                .setFuel(INITIAL_FUEL)
                .setShields(INITIAL_SHIELDS);
    }

    @Override
    public Fireable produceAttack() {
        this.firedProjectiles++;
        return new ShieldReaver(this.getDamage());
    }

    public @Override String toString() {
        String response = super.toString();
        if (this.isAlive()) {
            response += "\n-Projectiles fired: " + this.firedProjectiles;
        }

        return response;
    }
}
