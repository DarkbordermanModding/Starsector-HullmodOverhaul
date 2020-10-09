package data.hullmods.decoration.dmod;

import com.fs.starfarer.api.combat.ShipAPI;
import com.fs.starfarer.api.combat.BaseHullMod;

public class LightDmod extends BaseHullMod{
    public void applyEffectsAfterShipCreation(ShipAPI ship, String id){
        ship.setLightDHullOverlay();
        // ship.setDHullOverlay("graphics/damage/dmod_overlay_hightech_heavy.png");
    }
}
