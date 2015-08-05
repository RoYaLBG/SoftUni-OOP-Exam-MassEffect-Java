package com.company.engine.commands;

import com.company.interfaces.Playable;

/**
 * Created by RoYaL on 8/5/2015.
 */
public class SystemReportCommand extends Command {
    public SystemReportCommand(Playable engine) {
        super(engine);
    }

    @Override
    public void execute(String[] cmdArgs) {
        System.out.println("Intact ships:");
        if (!this.engine.getStarShips()
                .stream()
                .anyMatch(s -> s.getHealth() > 0 && s.getLocation().getName().equals(cmdArgs[1]))) {
            System.out.println("N/A");
        } else {
            this.engine.getStarShips()
                    .stream()
                    .filter(s -> s.getHealth() > 0 && s.getLocation().getName().equals(cmdArgs[1]))
                    .sorted((s1, s2) -> Integer.compare(s2.getHealth(), s1.getHealth()))
                    .sorted((s1, s2) -> Integer.compare(s2.getShields(), s1.getShields()))
                    .forEach(System.out::println);
        }

        System.out.println("Destroyed ships:");
        if (!this.engine.getStarShips()
                .stream()
                .anyMatch(s -> s.getHealth() == 0 && s.getLocation().getName().equals(cmdArgs[1]))) {
            System.out.println("N/A");
        } else {
            this.engine.getStarShips()
                    .stream()
                    .filter(s -> s.getHealth() == 0 && s.getLocation().getName().equals(cmdArgs[1]))
                    .sorted((s1, s2) -> s1.getName().compareTo(s2.getName()))
                    .forEach(System.out::println);
        }

    }

}
