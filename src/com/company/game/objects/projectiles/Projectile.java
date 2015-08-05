package com.company.game.objects.projectiles;

import com.company.interfaces.Fireable;

/**
 * Created by RoYaL on 8/5/2015.
 */
public abstract class Projectile implements Fireable {

    protected int damage;

    public Projectile(int damage) {
        this.setDamage(damage);
    }

    @Override
    public int getDamage() {
        return this.damage;
    }

    @Override
    public void setDamage(int damage) {
        this.damage = damage;
    }
}
