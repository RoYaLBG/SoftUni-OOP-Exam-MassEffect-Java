package com.company.game.objects.ships;

import com.company.game.objects.enhancements.Enhancement;
import com.company.game.objects.locations.StarSystem;
import com.company.interfaces.Attackable;
import com.company.interfaces.Enhanceable;
import com.company.interfaces.Fireable;
import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by RoYaL on 8/5/2015.
 */
public abstract class StarShip implements Attackable, Enhanceable {

    protected String name;
    protected int health;
    protected int shields;
    protected int damage;
    protected double fuel;
    protected StarSystem location;

    protected List<Enhancement> enhancements;

    protected static final int INITIAL_HEALTH = 0;
    protected static final int INITIAL_SHIELDS = 0;
    protected static final int INITIAL_DAMAGE = 0;
    protected static final int INITIAL_FUEL = 0;

    public StarShip(String name, StarSystem location) {
        this
                .setName(name)
                .setLocation(location)
                .setHealth(INITIAL_HEALTH)
                .setDamage(INITIAL_DAMAGE)
                .setFuel(INITIAL_FUEL)
                .setShields(INITIAL_SHIELDS);

        this.enhancements = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Attackable setName(String name) {
        this.name = name;

        return this;
    }

    @Override
    public StarSystem getLocation() {
        return location;
    }

    @Override
    public Attackable setLocation(StarSystem location) {
        this.location = location;

        return this;
    }

    @Override
    public void respondToAttack(Fireable fire) {
        fire.hit(this);
    }

    @Override
    public double getFuel() {
        return fuel;
    }

    @Override
    public Attackable setFuel(double fuel) {
        this.fuel = Math.max(fuel, 0);

        return this;
    }

    @Override
    public Attackable spendFuel(double fuel) {
        this.setFuel(this.getFuel() - fuel);

        return this;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public Attackable setDamage(int damage) {
        this.damage = Math.max(damage, 0);

        return this;
    }

    @Override
    public int getShields() {
        return shields;
    }

    @Override
    public Attackable setShields(int shields) {
        this.shields = Math.max(shields, 0);

        return this;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public Attackable setHealth(int health) {
        this.health = Math.max(health, 0);

        return this;
    }

    public List<Enhancement> getEnhancements() {
        return this.enhancements;
    }

    public void addEnhancement(Enhancement enhancement) {
        this.applyEnhancement(enhancement);
        this.enhancements.add(enhancement);
    }

    protected void applyEnhancement(Enhancement enhancement) {
        this.damage += enhancement.getDamageBonus();
        this.shields += enhancement.getShieldBonus();
        this.fuel += enhancement.getFuelBonus();
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    public @Override String toString() {
        String fullClassName = this.getClass().toString();
        String simpleClassName = fullClassName.substring(fullClassName.lastIndexOf('.') + 1);

        String response = "";
        response += "--" + this.getName() + " - " + simpleClassName;

        if (!this.isAlive()) {
            return response + "\n(Destroyed)";
        }

        response += "\n-Location: " + this.getLocation().getName();
        response += "\n-Health: " + this.getHealth();
        response += "\n-Shields: " + this.getShields();
        response += "\n-Damage: " + this.getDamage();
        response += "\n-Fuel: " + this.getFuel();

        String enhancements = "N/A";
        if (this.enhancements.size() > 0) {
            enhancements = StringUtils.join(
                    this.enhancements
                            .stream()
                            .map(Enhancement::getName)
                            .collect(Collectors.toList()),
                    ", "
            );
        }

        response += "\n-Enhancements: " + enhancements;

        return response;
    }

}
