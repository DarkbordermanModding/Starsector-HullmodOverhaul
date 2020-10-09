package data.hullmods;

import java.util.ArrayList;
import java.util.List;

import com.fs.starfarer.api.combat.BaseHullMod;
import com.fs.starfarer.api.combat.BeamAPI;
import com.fs.starfarer.api.combat.CombatEntityAPI;
import com.fs.starfarer.api.combat.DamageAPI;
import com.fs.starfarer.api.combat.DamagingProjectileAPI;
import com.fs.starfarer.api.combat.ShipAPI;
import com.fs.starfarer.api.combat.WeaponAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;
import com.fs.starfarer.api.combat.WeaponAPI.AIHints;
import com.fs.starfarer.api.combat.listeners.DamageDealtModifier;
import com.fs.starfarer.api.combat.listeners.WeaponRangeModifier;
import com.fs.starfarer.api.util.Misc;

import org.lwjgl.util.vector.Vector2f;

public class hmo_pdoverride extends BaseHullMod{

    // Use the list to store PD weapons since setPD(false) will affect next frame's result.
    public List<WeaponAPI> pd_weapons = new ArrayList<WeaponAPI>();
    public static final float RANGE_MULT = 1.75f;
    public static final float DAMAGE_MULT = 1.5f;

    public void addPostDescriptionSection(com.fs.starfarer.api.ui.TooltipMakerAPI tooltip, com.fs.starfarer.api.combat.ShipAPI.HullSize hullSize, com.fs.starfarer.api.combat.ShipAPI ship, float width, boolean isForModSpec){
        float opad = 10f;
        tooltip.addPara(
            "Disable PD feature on PD weapons.\n" +
            "PD weapons are considered as normal weapons.\n" +
            "Increase PD weapons' range by %s and damage by %s",
            opad,
            Misc.getHighlightColor(),
            (int)((RANGE_MULT - 1) * 100f) + "%",
            (int)((DAMAGE_MULT - 1) * 100f) + "%"
        );
    }

    public void applyEffectsAfterShipCreation(ShipAPI ship, String id){
        for(WeaponAPI weapon: ship.getAllWeapons()){
            if(weapon.hasAIHint(AIHints.PD)){
                pd_weapons.add(weapon);
                weapon.setPD(false);
            }
        }
        ship.addListener(new WeaponRangeImplement(pd_weapons));
        ship.addListener(new DamageDealtImplement(pd_weapons));
    }

    public static class WeaponRangeImplement implements WeaponRangeModifier{

        List<WeaponAPI> pd_weapons;

        public WeaponRangeImplement(List<WeaponAPI> weapons){
            pd_weapons = weapons;
        }
        public float getWeaponRangePercentMod(ShipAPI ship, WeaponAPI weapon) {return 0f;}
        public float getWeaponRangeMultMod(ShipAPI ship, WeaponAPI weapon) {
            if(pd_weapons.contains(weapon)){return RANGE_MULT;}
            return 1f;
        }
        public float getWeaponRangeFlatMod(ShipAPI ship, WeaponAPI weapon) {return 0f;}
    }

    public static class DamageDealtImplement implements DamageDealtModifier{

        List<WeaponAPI> pd_weapons;

        public DamageDealtImplement(List<WeaponAPI> weapons){
            pd_weapons = weapons;
        }
		public String modifyDamageDealt(Object param,
								   		CombatEntityAPI target, DamageAPI damage,
								   		Vector2f point, boolean shieldHit) {
            WeaponAPI source;
            if(param instanceof DamagingProjectileAPI){
                source = ((DamagingProjectileAPI)param).getWeapon();
                if(pd_weapons.contains(source)){damage.setMultiplier(DAMAGE_MULT);}
            }
            if(param instanceof BeamAPI){
                source = ((BeamAPI)param).getWeapon();
                if(pd_weapons.contains(source)){damage.setMultiplier(DAMAGE_MULT);}
            }
			return null;
		}
    }

    @Override
    public String getDescriptionParam(int index, HullSize hullSize) {
        return null;
    }
}
