package data.hullmods.combat;

import com.fs.starfarer.api.combat.BaseHullMod;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;
import com.fs.starfarer.api.util.Misc;


public class automatedAIChip extends BaseHullMod{

    public static final float DEFAULT_CR = 0.7f;
    public static final float TARGET_CR = 0.5f;

    public void addPostDescriptionSection(com.fs.starfarer.api.ui.TooltipMakerAPI tooltip, com.fs.starfarer.api.combat.ShipAPI.HullSize hullSize, com.fs.starfarer.api.combat.ShipAPI ship, float width, boolean isForModSpec){
        float opad = 10f;
        tooltip.addPara(
            "Using a specialized chip to bring automated ship online." +
            "Due to insufficient technological background, maximum combat readiness is set to %s.",
            opad,
            Misc.getHighlightColor(),
            (int)(TARGET_CR * 100f) + "%"
        );
    }

	public void applyEffectsBeforeShipCreation(HullSize hullSize, MutableShipStatsAPI stats, String id) {
        stats.getMaxCombatReadiness().unmodifyFlat("automated");
        stats.getMaxCombatReadiness().unmodifyFlat("automated_ships_ships_2");
        stats.getMaxCombatReadiness().modifyFlat(id, TARGET_CR - DEFAULT_CR);
	}
}
