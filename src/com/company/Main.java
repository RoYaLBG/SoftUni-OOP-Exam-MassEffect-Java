package com.company;

import com.company.engine.GameEngine;
import com.company.engine.ReportingCommandManager;
import com.company.game.objects.Galaxy;
import com.company.game.objects.locations.StarSystem;
import com.company.interfaces.Commander;
import com.company.interfaces.Playable;

public class Main {

    public static void main(String[] args) {
        Galaxy galaxy = new Galaxy();
        seedStarSystems(galaxy);

        Commander commandManager = new ReportingCommandManager();
        Playable engine = new GameEngine(commandManager, galaxy);
        engine.run();
    }

    public static void seedStarSystems(Galaxy galaxy)
    {
        StarSystem artemisTau = new StarSystem("Artemis-Tau");
        StarSystem serpentNebula = new StarSystem("Serpent-Nebula");
        StarSystem hadesGamma = new StarSystem("Hades-Gamma");
        StarSystem keplerVerge = new StarSystem("Kepler-Verge");

        galaxy.getStarSystems().add(artemisTau);
        galaxy.getStarSystems().add(serpentNebula);
        galaxy.getStarSystems().add(hadesGamma);
        galaxy.getStarSystems().add(keplerVerge);

        artemisTau.addNeighbour(serpentNebula, 50d);
        artemisTau.addNeighbour(keplerVerge, 120d);

        serpentNebula.addNeighbour(artemisTau, 50d);
        serpentNebula.addNeighbour(hadesGamma, 360d);

        hadesGamma.addNeighbour(serpentNebula, 360d);
        hadesGamma.addNeighbour(keplerVerge, 145d);

        keplerVerge.addNeighbour(hadesGamma, 145d);
        keplerVerge.addNeighbour(artemisTau, 120d);
    }
}
