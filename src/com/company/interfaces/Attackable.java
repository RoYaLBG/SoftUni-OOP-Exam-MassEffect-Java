package com.company.interfaces;

import com.company.game.objects.locations.StarSystem;

/**
 * Created by RoYaL on 8/5/2015.
 */
public interface Attackable {

    public String getName();

    public Attackable setName(String name);

    public int getHealth();
    
    public Attackable setHealth(int health);
    
    public int getShields();

    public Attackable setShields(int shields);

    public int getDamage();

    public Attackable setDamage(int damage);

    public double getFuel();

    public Attackable setFuel(double fuel);

    public Attackable spendFuel(double fuel);

    public StarSystem getLocation();

    public Attackable setLocation(StarSystem system);

    public Fireable produceAttack();

    public void respondToAttack(Fireable fire);

}
