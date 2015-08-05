package com.company.interfaces;

import com.company.engine.factories.EnhancementFactory;
import com.company.engine.factories.ShipFactory;
import com.company.game.objects.Galaxy;

import java.util.List;

/**
 * Created by RoYaL on 8/5/2015.
 */
public interface Playable {

    public ShipFactory getShipFactory();

    public EnhancementFactory getEnhancementFactory();

    public List<Attackable> getStarShips();

    public Galaxy getGalaxy();

    public Commander getCommandManager();

    public boolean isRunning();

    public void setRunning(boolean running);

    public void run();
}
