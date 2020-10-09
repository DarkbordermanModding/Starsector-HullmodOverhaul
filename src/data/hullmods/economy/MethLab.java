package data.hullmods.economy;

import java.util.HashMap;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.combat.BaseHullMod;
import com.fs.starfarer.api.combat.ShipAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;
import com.fs.starfarer.api.fleet.FleetMemberAPI;
import com.fs.starfarer.api.ui.TooltipMakerAPI;
import com.fs.starfarer.api.util.IntervalUtil;
import com.fs.starfarer.api.util.Misc;
import com.fs.starfarer.api.util.Pair;

public class MethLab extends BaseHullMod{

    public static final IntervalUtil HARVEST_INTERVAL = new IntervalUtil(10f, 10f);
    public HashMap<HullSize, Pair<Float, Float>> CONVERT_MAP =new HashMap<HullSize, Pair<Float, Float>>() {{
        put(HullSize.DEFAULT, new Pair<Float, Float>(0f,0f));
        put(HullSize.FIGHTER, new Pair<Float, Float>(0f,0f));
        put(HullSize.FRIGATE, new Pair<Float, Float>(5f,1f));
        put(HullSize.DESTROYER, new Pair<Float, Float>(10f, 2f));
        put(HullSize.CRUISER, new Pair<Float, Float>(15f, 3f));
        put(HullSize.CAPITAL_SHIP, new Pair<Float, Float>(20f, 4f));
    }};

    public void addPostDescriptionSection(TooltipMakerAPI tooltip, HullSize hullSize, ShipAPI ship, float width, boolean isForModSpec){
        tooltip.addPara(
            "Install a meth lab on ship." +
            "Transform %s units of organics to %s units of drugs per in-game day.",
            -10f,
            Misc.getHighlightColor(),
            "5/10/15/20", "1/2/3/4"
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
            float quantity = Global.getSector().getPlayerFleet().getCargo().getCommodityQuantity("organics");
            Pair<Float, Float> rate = CONVERT_MAP.get(member.getHullSpec().getHullSize());

            if(quantity >= rate.one){
                Global.getSector().getPlayerFleet().getCargo().removeCommodity("organics", rate.one);
                Global.getSector().getPlayerFleet().getCargo().addCommodity("drugs", rate.two);
            }
        }
    }
}
