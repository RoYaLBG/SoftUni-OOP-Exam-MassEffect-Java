package com.company.game.objects.projectiles;

import com.company.interfaces.Attackable;

/**
 * Created by RoYaL on 8/5/2015.
 */
public class PenetrationShell extends Projectile {

    public PenetrationShell(int damage) {
        super(damage);
    }

    @Override
    public void hit(Attackable attacker) {
        attacker.setHealth(attacker.getHealth() - this.getDamage());
    }
}
