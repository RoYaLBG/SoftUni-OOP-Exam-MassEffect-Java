package com.company.engine.commands;

import com.company.interfaces.Playable;

/**
 * Created by RoYaL on 8/5/2015.
 */
public class OverCommand extends Command {
    public OverCommand(Playable engine) {
        super(engine);
    }

    @Override
    public void execute(String[] cmdArgs) {
        this.engine.setRunning(false);
    }
}
