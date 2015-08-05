package com.company.game.objects.locations;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by RoYaL on 8/5/2015.
 */
public class StarSystem {

    private String name;

    private Map<StarSystem, Double> neighbours;

    public StarSystem(String name) {
        this.setName(name);
        this.neighbours = new HashMap<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<StarSystem, Double> getNeighbours() {
        return this.neighbours;
    }

    public void addNeighbour(StarSystem neighbour, Double value) {
        this.neighbours.put(neighbour, value);
    }

    public Double getNeighbourFuel(StarSystem neighbour) {
        return this.neighbours.get(neighbour);
    }
}
