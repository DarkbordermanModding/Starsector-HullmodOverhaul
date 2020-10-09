package data.hullmods.economy;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.SectorEntityToken;
import com.fs.starfarer.api.combat.BaseHullMod;
import com.fs.starfarer.api.fleet.FleetMemberAPI;
import com.fs.starfarer.api.impl.campaign.terrain.AsteroidBeltTerrainPlugin;
import com.fs.starfarer.api.util.IntervalUtil;
import com.fs.starfarer.api.util.Misc;
import com.fs.starfarer.campaign.CampaignTerrain;

public class MiningDrill extends BaseHullMod{

    public static final IntervalUtil HARVEST_INTERVAL = new IntervalUtil(1.0F, 1.0F);

    public void addPostDescriptionSection(com.fs.starfarer.api.ui.TooltipMakerAPI tooltip, com.fs.starfarer.api.combat.ShipAPI.HullSize hullSize, com.fs.starfarer.api.combat.ShipAPI ship, float width, boolean isForModSpec){
        float opad = 10f;
        tooltip.addPara(
            "much to %s.",
            opad,
            Misc.getHighlightColor(),
            "5%"
        );
    }

    public void advanceInCampaign(FleetMemberAPI member, float amount) {
        HARVEST_INTERVAL.advance(amount);
        if (HARVEST_INTERVAL.intervalElapsed() &&
            member.getFleetData() != null &&
            member.getFleetData().getFleet() != null &&
            member.getFleetCommander().isPlayer()
        )
        {
            SectorEntityToken orbit = Global.getSector().getPlayerFleet().getOrbitFocus();
            if(orbit != null && orbit.getClass() == CampaignTerrain.class){
                CampaignTerrain terrain = (CampaignTerrain)orbit;
                System.out.println(terrain.getPlugin());
                if(terrain.getPlugin().getClass() == AsteroidBeltTerrainPlugin.class){
                    Global.getSector().getPlayerFleet().getCargo().addCommodity("ore", 10f);
                    member.getFleetData().getFleet().addFloatingText("ore 10 f", Misc.getTextColor(), 0.5F);
                }
            }
        }
    }
}
