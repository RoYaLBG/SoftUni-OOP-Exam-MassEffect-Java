package com.company.game.objects.enhancements;

/**
 * Created by RoYaL on 8/5/2015.
 */
public class Enhancement {

    private String name;
    private int shieldBonus;
    private int damageBonus;
    private double fuelBonus;

    public Enhancement(String name, int shieldBonus, int damageBonus, double fuelBonus) {
        this
                .setName(name)
                .setShieldBonus(shieldBonus)
                .setDamageBonus(damageBonus)
                .setFuelBonus(fuelBonus);
    }

    public String getName() {
        return name;
    }

    private Enhancement setName(String name) {
        this.name = name;

        return this;
    }

    public int getShieldBonus() {
        return shieldBonus;
    }

    private Enhancement setShieldBonus(int shieldBonus) {
        this.shieldBonus = shieldBonus;

        return this;
    }

    public int getDamageBonus() {
        return damageBonus;
    }

    private Enhancement setDamageBonus(int damageBonus) {
        this.damageBonus = damageBonus;

        return this;
    }

    public double getFuelBonus() {
        return fuelBonus;
    }

    private Enhancement setFuelBonus(double fuelBonus) {
        this.fuelBonus = fuelBonus;

        return this;
    }

    public @Override String toString() {
        return this.getName();
    }
}
