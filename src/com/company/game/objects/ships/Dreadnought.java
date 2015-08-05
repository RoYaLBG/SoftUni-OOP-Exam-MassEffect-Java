package com.company.game.objects.ships;

import com.company.game.objects.locations.StarSystem;
import com.company.game.objects.projectiles.Laser;
import com.company.interfaces.Fireable;

/**
 * Created by RoYaL on 8/5/2015.
 */
public class Dreadnought extends StarShip {

    protected static final int INITIAL_HEALTH = 200;
    protected static final int INITIAL_SHIELDS = 300;
    protected static final int INITIAL_DAMAGE = 150;
    protected static final int INITIAL_FUEL = 700;

    public Dreadnought(String name, StarSystem location) {
        super(name, location);
        this
                .setHealth(INITIAL_HEALTH)
                .setDamage(INITIAL_DAMAGE)
                .setFuel(INITIAL_FUEL)
                .setShields(INITIAL_SHIELDS);
    }

    @Override
    public Fireable produceAttack() {
        return new Laser(this.getShields() / 2 + this.getDamage());
    }


    public void respondToAttack(Fireable fire) {
        this.setShields(this.getShields() + 50);
        super.respondToAttack(fire);
        this.setShields(this.getShields() - 50);
    }
}
