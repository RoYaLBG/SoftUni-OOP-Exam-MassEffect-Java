package com.company.game.objects.projectiles;

import com.company.interfaces.Attackable;

/**
 * Created by RoYaL on 8/5/2015.
 */
public class ShieldReaver extends Projectile {

    public ShieldReaver(int damage) {
        super(damage);
    }

    @Override
    public void hit(Attackable attacker) {
        attacker.setHealth(attacker.getHealth() - this.getDamage());
        attacker.setShields(attacker.getShields() - (2 * this.getDamage()));
    }
}
