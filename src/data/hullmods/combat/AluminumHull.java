package data.hullmods.combat;

import com.fs.starfarer.api.combat.BaseHullMod;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;

public class AluminumHull extends BaseHullMod{

    public static final float SPEED_MULT = 1.05f;
    public static final float HULL_MULT = 0.75f;

    public void applyEffectsBeforeShipCreation(HullSize hullSize, MutableShipStatsAPI stats, String id) {
        stats.getMaxSpeed().modifyMult(id, SPEED_MULT);
        stats.getHullBonus().modifyMult(id, HULL_MULT);
    }

    @Override
    public String getDescriptionParam(int index, HullSize hullSize) {
        if (index == 0) {
            return Math.round(SPEED_MULT * 100 - 100) + "%";
        }
        if (index == 1 ){
            return Math.round(100 - HULL_MULT * 100) + "%";
        }
        return null;
    }
}
