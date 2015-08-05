package com.company.engine.factories;

import com.company.game.objects.enhancements.Enhancement;
import com.company.game.objects.enhancements.EnhancementType;

/**
 * Created by RoYaL on 8/5/2015.
 */
public class EnhancementFactory {

    public Enhancement createEnhancement(EnhancementType enhancementType) throws Exception {
        switch (enhancementType) {
            case ThanixCannon:
                return new Enhancement("ThanixCannon", 0, 50, 0);
            case KineticBarrier:
                return new Enhancement("KineticBarrier", 100, 0, 0);
            case ExtendedFuelCells:
                return new Enhancement("ExtendedFuelCells", 0, 0, 200);
            default:
                throw new Exception();
        }
    }

}
