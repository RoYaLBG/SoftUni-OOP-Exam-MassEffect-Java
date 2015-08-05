package com.company.engine;

import com.company.engine.commands.*;
import com.company.exceptions.ShipException;
import com.company.interfaces.Commander;
import com.company.interfaces.Playable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by RoYaL on 8/5/2015.
 */
public class CommandManager implements Commander {

    protected Playable engine;
    protected Map<String, Command> commandsByName;

    public CommandManager() {
        this.commandsByName = new HashMap<>();
    }

    @Override
    public Playable getEngine() {
        return this.engine;
    }

    @Override
    public void setEngine(Playable engine) {
        this.engine = engine;
    }

    @Override
    public void processCommand(String command) throws ShipException {
        String[] commandArgs = command.split(" ");
        String commandName = commandArgs[0];

        if (!this.commandsByName.containsKey(commandName)) {
            throw new ShipException("Command "+ command +" does not exists");
        }

        Command cmd = this.commandsByName.get(commandName);
        cmd.execute(commandArgs);
    }

    @Override
    public void seedCommands() {
        this.commandsByName.put("create", new CreateCommand(this.getEngine()));
        this.commandsByName.put("attack", new AttackCommand(this.getEngine()));
        this.commandsByName.put("status-report", new StatusReportCommand(this.getEngine()));
        this.commandsByName.put("plot-jump", new PlotJumpCommand(this.getEngine()));
        this.commandsByName.put("over", new OverCommand(this.getEngine()));
    }
}
