package mod.hullmodoverhaul;

import com.fs.starfarer.api.combat.ShipHullSpecAPI;

import mod.hullmodoverhaul.docks.customShipHullSpecAPI;


public final class utilities {

    public final ShipHullSpecAPI createNewShipHullSpecAPI(final ShipHullSpecAPI origin){
        customShipHullSpecAPI custom = new customShipHullSpecAPI(origin);
        return custom;
    }
}