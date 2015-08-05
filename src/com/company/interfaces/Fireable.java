package com.company.interfaces;

/**
 * Created by RoYaL on 8/5/2015.
 */
public interface Fireable {

    public int getDamage();

    public void setDamage(int damage);

    public void hit(Attackable attacker);

}
