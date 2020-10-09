package data.hullmods;

import com.fs.starfarer.api.combat.BaseHullMod;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;

public class hmo_striparmor extends BaseHullMod {

    public static final float SPEED_MULT = 1.2f;
    public static final float ARMOR_MULT = 0f;
    public static final float BURN_LEVEL_FLAT = 1f;

    public void applyEffectsBeforeShipCreation(HullSize hullSize, MutableShipStatsAPI stats, String id) {
        stats.getMaxSpeed().modifyMult(id, SPEED_MULT);
        stats.getMaxBurnLevel().modifyFlat(id, BURN_LEVEL_FLAT);
        stats.getArmorBonus().modifyMult(id, ARMOR_MULT);
    }

    @Override
    public String getDescriptionParam(int index, HullSize hullSize) {
        if (index == 0) {
            return Math.round(SPEED_MULT * 100 - 100) + "%";
        }
        if (index == 1){
            return Math.round(BURN_LEVEL_FLAT) + "";
        }
        return null;
    }
}
