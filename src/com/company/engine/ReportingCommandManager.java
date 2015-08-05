package com.company.engine;

import com.company.engine.commands.SystemReportCommand;

/**
 * Created by RoYaL on 8/5/2015.
 */
public class ReportingCommandManager extends CommandManager {

    @Override
    public void seedCommands() {
        super.seedCommands();
        this.commandsByName.put("system-report", new SystemReportCommand(this.getEngine()));
    }

}
