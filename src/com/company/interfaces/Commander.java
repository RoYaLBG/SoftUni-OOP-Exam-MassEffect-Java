package com.company.interfaces;

import com.company.exceptions.ShipException;

/**
 * Created by RoYaL on 8/5/2015.
 */
public interface Commander {

    public Playable getEngine();

    public void setEngine(Playable engine);

    public void processCommand(String command) throws ShipException;

    public void seedCommands();
}
