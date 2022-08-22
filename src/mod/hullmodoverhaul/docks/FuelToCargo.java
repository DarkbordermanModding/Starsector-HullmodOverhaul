package mod.hullmodoverhaul.docks;

import com.fs.starfarer.api.impl.hullmods.BaseLogisticsHullMod;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;

public class FuelToCargo extends BaseLogisticsHullMod {

    public void applyEffectsBeforeShipCreation(HullSize hullSize, MutableShipStatsAPI stats, String id) {
        float storage = stats.getVariant().getHullSpec().getFuel();
        float storagefinal = stats.getFuelMod().computeEffective(storage);
        stats.getFuelMod().modifyFlat(id, -storagefinal);
        stats.getCargoMod().modifyFlat(id, storagefinal);
	}
}
