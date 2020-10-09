package data.hullmods;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.combat.BaseHullMod;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.WeaponAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;
import com.fs.starfarer.api.combat.WeaponAPI.WeaponType;

public class hmo_maintaincrew extends BaseHullMod{

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
    public void advanceInCombat(com.fs.starfarer.api.combat.ShipAPI ship, float amount) {
        int second = (int)Math.floor(Global.getCombatEngine().getTotalElapsedTime(false));
        for(WeaponAPI weapon: ship.getAllWeapons()){
            if(weapon.getType() == WeaponType.MISSILE){
                // creating an unique key for stoage
                String key = ship.getId() + "_" + weapon.getSlot().getId();
                float second_per_ammo = weapon.getMaxAmmo() / RELOAD_SECOND;

                if(!Global.getCombatEngine().getCustomData().containsKey(key)){
                    Global.getCombatEngine().getCustomData().put(key, 0f);
                }

                float reloaded = (float)Global.getCombatEngine().getCustomData().get(key);
                System.out.println(key);
                if((int)(second_per_ammo * second - reloaded) > 1 && weapon.getAmmo() < weapon.getMaxAmmo()){
                    weapon.setAmmo(weapon.getAmmo() + 1);
                    Global.getCombatEngine().getCustomData().put(key, (float)Math.floor(second_per_ammo * second));
                }
            }
        }
    }
}
