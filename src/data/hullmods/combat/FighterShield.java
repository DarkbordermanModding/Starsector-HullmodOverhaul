package data.hullmods.combat;

import com.fs.starfarer.api.combat.BaseHullMod;
import com.fs.starfarer.api.combat.FighterWingAPI;
import com.fs.starfarer.api.combat.ShieldAPI;
import com.fs.starfarer.api.combat.ShipAPI;
import com.fs.starfarer.api.combat.ShieldAPI.ShieldType;

public class FighterShield extends BaseHullMod{

    public static final float SHIELD_ARC = 180f;

	public void applyEffectsToFighterSpawnedByShip(ShipAPI fighter, ShipAPI ship, String id) {
        ShieldAPI shield = fighter.getShield();
		if (shield == null) {
			fighter.setShield(ShieldType.FRONT, 0.5f, 1.0f, SHIELD_ARC);
		}
        else{
            fighter.getShield().setArc(360f);
        }
	}

	public void advanceInCombat(ShipAPI ship, float amount) {
        for(FighterWingAPI wing: ship.getAllWings()){
            for(ShipAPI fighter: wing.getWingMembers()){
                if (!fighter.getShield().isOn()) {
                    fighter.getShield().toggleOn();
                }
            }
        }
    }

}
