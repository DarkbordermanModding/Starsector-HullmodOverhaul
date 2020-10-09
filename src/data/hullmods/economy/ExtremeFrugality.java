package data.hullmods.economy;

import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI;
import com.fs.starfarer.api.combat.WeaponAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;
import com.fs.starfarer.api.impl.hullmods.BaseLogisticsHullMod;
import com.fs.starfarer.api.util.Misc;

public class ExtremeFrugality extends BaseLogisticsHullMod{

    public static final float CR_FLAT = -0.5f;
    public static final float MAINTAINENCE_MULT = 0.4f;
    public static final float RECOVER_PERCENT = -50f;

    public void addPostDescriptionSection(com.fs.starfarer.api.ui.TooltipMakerAPI tooltip, com.fs.starfarer.api.combat.ShipAPI.HullSize hullSize, com.fs.starfarer.api.combat.ShipAPI ship, float width, boolean isForModSpec){
        float opad = 10f;
        tooltip.addPara(
            "Disable ship's combat system and almost morthall the ship.\n" +
            "Reduce %s of minimun crew, supplies per month, and fuel used.\n" +
            "Reduce CR recovery and repair rate per day by %s. Decrease %s CR.\n",
            opad,
            Misc.getHighlightColor(),
            "60%", "50%", "50%"
        );
    }

    public void applyEffectsBeforeShipCreation(HullSize hullSize, MutableShipStatsAPI stats, String id) {
        stats.getMaxCombatReadiness().modifyFlat(id, CR_FLAT);
        stats.getMinCrewMod().modifyMult(id, MAINTAINENCE_MULT);
        stats.getSuppliesPerMonth().modifyMult(id, MAINTAINENCE_MULT);
        stats.getFuelUseMod().modifyMult(id, MAINTAINENCE_MULT);
        stats.getBaseCRRecoveryRatePercentPerDay().modifyPercent(id, RECOVER_PERCENT);
        stats.getRepairRatePercentPerDay().modifyPercent(id, RECOVER_PERCENT);
    }

    public void advanceInCombat(ShipAPI ship, float amount) {
        ship.setDefenseDisabled(true);
        ship.setShipSystemDisabled(true);
        for(WeaponAPI weapon: ship.getUsableWeapons()){
            weapon.disable();
        }
	}
}
