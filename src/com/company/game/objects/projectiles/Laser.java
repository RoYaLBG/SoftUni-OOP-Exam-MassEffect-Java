package com.company.game.objects.projectiles;

import com.company.interfaces.Attackable;

/**
 * Created by RoYaL on 8/5/2015.
 */
public class Laser extends Projectile {

    public Laser(int damage) {
        super(damage);
    }

    @Override
    public void hit(Attackable attacker) {
        int currentDamage = this.getDamage();
        int leftDamage = Math.max(currentDamage - attacker.getShields(), 0);

        attacker.setShields(attacker.getShields() - currentDamage);
        attacker.setHealth(attacker.getHealth() - leftDamage);
    }
}
