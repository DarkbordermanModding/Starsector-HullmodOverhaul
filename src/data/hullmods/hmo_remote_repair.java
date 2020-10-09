package data.hullmods;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.combat.BaseHullMod;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;

import data.hullmods.decoration.ColorUtilities;

import org.lwjgl.util.vector.Vector2f;


public class hmo_remote_repair extends BaseHullMod{

    public static final float RELOAD_SECOND = 20f;
    public static final float CR_FLAT = 0.3f;

    public void applyEffectsBeforeShipCreation(HullSize hullSize, MutableShipStatsAPI stats, String id) {
        stats.getMaxCombatReadiness().modifyFlat(id, CR_FLAT);
    }

    @Override
    public String getDescriptionParam(int index, HullSize hullSize) {
        if (index == 0) {
            return Math.round(CR_FLAT * 100) + "%";
        }
        return null;
    }

    public float getDistance(Vector2f a, Vector2f b){
        return (float)Math.sqrt(
            (a.getX() - b.getX()) * (a.getX() - b.getX()) + (a.getY() - b.getY()) * (a.getY() - b.getY())
        );
    }

    public void advanceInCombat(ShipAPI ship, float amount) {
        if(!ship.isAlive()) return;

        GL11Utilities.setupGL11();
        GL11Utilities.setColor(ColorUtilities.HEGEMONY);

        for (ShipAPI item: Global.getCombatEngine().getShips()){
            if(ship != item && item.isAlive() && (item.isAlly() || ship.getOwner() == item.getOwner())){
                float distance = getDistance(ship.getLocation(), item.getLocation());
                if(distance < 1000f){
                    System.out.println("In range");
                    if(item.getHitpoints() < item.getMaxHitpoints()){
                        item.setHitpoints(item.getHitpoints() + 3f);
                        GL11Utilities.drawLine(ship.getLocation(), item.getLocation());
                    }
                }
            }
        }
        GL11Utilities.teardownGL11();
    }
}
