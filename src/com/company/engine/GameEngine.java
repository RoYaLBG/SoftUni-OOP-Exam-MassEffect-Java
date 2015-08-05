package com.company.engine;

import com.company.engine.factories.EnhancementFactory;
import com.company.engine.factories.ShipFactory;
import com.company.exceptions.ShipException;
import com.company.game.objects.Galaxy;
import com.company.interfaces.Attackable;
import com.company.interfaces.Commander;
import com.company.interfaces.Playable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by RoYaL on 8/5/2015.
 */
public class GameEngine implements Playable {

    private ShipFactory shipFactory;
    private EnhancementFactory enhancementFactory;
    private List<Attackable> starShips;
    private Galaxy galaxy;
    private Commander commandManager;
    private boolean isRunning;

    public GameEngine(Commander commandManager, Galaxy galaxy) {
        this.commandManager = commandManager;
        this.galaxy = galaxy;
        this.shipFactory = new ShipFactory();
        this.enhancementFactory = new EnhancementFactory();
        this.starShips = new ArrayList<>();
    }


    @Override
    public ShipFactory getShipFactory() {
        return shipFactory;
    }

    @Override
    public EnhancementFactory getEnhancementFactory() {
        return enhancementFactory;
    }

    @Override
    public List<Attackable> getStarShips() {
        return starShips;
    }

    @Override
    public Galaxy getGalaxy() {
        return galaxy;
    }

    @Override
    public Commander getCommandManager() {
        return commandManager;
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }

    @Override
    public void setRunning(boolean running) {
        this.isRunning = running;
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);

        this.setRunning(true);
        this.commandManager.setEngine(this);
        this.commandManager.seedCommands();

        do {
            String command = sc.nextLine();

            try {
                this.commandManager.processCommand(command);
            } catch (ShipException e) {
                System.out.println(e.getMessage());
            }
        }
        while (this.isRunning);
    }
}
