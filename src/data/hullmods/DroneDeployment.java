package data.hullmods;
import java.util.HashMap;
import java.util.Map;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.combat.BaseHullMod;
import com.fs.starfarer.api.combat.CombatFleetManagerAPI;
import com.fs.starfarer.api.combat.ShipAPI;


public class DroneDeployment extends BaseHullMod{

    public boolean SPAWNED = false;

    private static Map<String, Integer> drones = new HashMap<String, Integer>();
    static {
        drones.put("wasp_wing", 1);
        drones.put("borer_wing", 2);
        drones.put("talon_wing", 3);
        drones.put("mining_drone_wing", 4);
    }

    public void advanceInCombat(ShipAPI ship, float amount) {
        if(!ship.isAlive()) return;

        CombatFleetManagerAPI fleetManager = Global.getCombatEngine().getFleetManager(ship.getOriginalOwner());
        fleetManager.setSuppressDeploymentMessages(true);
        if(SPAWNED == false){
            for(Map.Entry<String, Integer> drone : drones.entrySet()){
                for(int i=0; i<drone.getValue(); i++){
                    fleetManager.spawnShipOrWing(drone.getKey(), ship.getLocation(), 0f);
                }
            }
        }
        fleetManager.setSuppressDeploymentMessages(true);
        SPAWNED = true;
    }
}
