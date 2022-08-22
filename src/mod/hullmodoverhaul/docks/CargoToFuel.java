package mod.hullmodoverhaul.docks;

import com.fs.starfarer.api.impl.hullmods.BaseLogisticsHullMod;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;

public class CargoToFuel extends BaseLogisticsHullMod {

    public void applyEffectsBeforeShipCreation(HullSize hullSize, MutableShipStatsAPI stats, String id) {
        float storage = stats.getVariant().getHullSpec().getCargo();
        float storagefinal = stats.getCargoMod().computeEffective(storage);
        stats.getCargoMod().modifyFlat(id, -storagefinal);
        stats.getFuelMod().modifyFlat(id, storagefinal);
	}
}
