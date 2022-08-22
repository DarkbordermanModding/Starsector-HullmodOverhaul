package mod.hullmodoverhaul.docks;

import com.fs.starfarer.api.combat.ShipHullSpecAPI;

public class customShipHullSpecAPI implements ShipHullSpecAPI, Cloneable{

    private final ShipHullSpecAPI origin;

    public customShipHullSpecAPI(ShipHullSpecAPI hull){
        this.origin = hull;
    }

    @Override
    public com.fs.starfarer.api.combat.ShipHullSpecAPI.ShieldSpecAPI getShieldSpec(){
        return origin.getShieldSpec();
    }
    @Override
    public  com.fs.starfarer.api.combat.ShieldAPI.ShieldType getDefenseType(){
        return origin.getDefenseType();
    }
    @Override
    public  java.lang.String getHullId(){
        return origin.getHullId();
    }
    @Override
    public  java.lang.String getHullName(){
        return origin.getHullName();
    }
    @Override
    public   java.util.EnumSet<com.fs.starfarer.api.combat.ShipHullSpecAPI.ShipTypeHints> getHints(){
        return origin.getHints();
    }
    @Override
    public  float getNoCRLossTime(){
        return origin.getNoCRLossTime();
    }
    @Override
    public  float getCRToDeploy(){
        return origin.getCRToDeploy();
    }
    @Override
    public  float getCRLossPerSecond(){
        return origin.getCRLossPerSecond();
    }
    @Override
    public  float getBaseValue(){
        return origin.getBaseValue();
    }
    @Override
    public  int getOrdnancePoints(com.fs.starfarer.api.characters.MutableCharacterStatsAPI arg0){
        return origin.getOrdnancePoints(arg0);
    }
    @Override
    public  com.fs.starfarer.api.combat.ShipAPI.HullSize getHullSize(){
        return origin.getHullSize();
    }
    @Override
    public  float getHitpoints(){
        return origin.getHitpoints();
    }
    @Override
    public  float getArmorRating(){
        return origin.getArmorRating();
    }
    @Override
    public  float getFluxCapacity(){
        return origin.getFluxCapacity();
    }
    @Override
    public  float getFluxDissipation(){
        return origin.getFluxDissipation();
    }
    @Override
    public  com.fs.starfarer.api.combat.ShieldAPI.ShieldType getShieldType(){
        return origin.getShieldType();
    }
    @Override
    public   java.util.List<com.fs.starfarer.api.loading.WeaponSlotAPI> getAllWeaponSlotsCopy(){
        return origin.getAllWeaponSlotsCopy();
    }
    @Override
    public  java.lang.String getSpriteName(){
        return origin.getSpriteName();
    }
    @Override
    public  boolean isCompatibleWithBase(){
        return origin.isCompatibleWithBase();
    }
    @Override
    public  java.lang.String getBaseHullId(){
        return origin.getBaseHullId();
    }
    @Override
    public  float getBaseShieldFluxPerDamageAbsorbed(){
        return origin.getBaseShieldFluxPerDamageAbsorbed();
    }
    @Override
    public  java.lang.String getHullNameWithDashClass(){
        return origin.getHullName();
    }
    @Override
    public  boolean hasHullName(){
        return origin.hasHullName();
    }
    @Override
    public  float getBreakProb(){
        return origin.getBreakProb();
    }
    @Override
    public  float getMinPieces(){
        return origin.getMinPieces();
    }
    @Override
    public  float getMaxPieces(){
        return origin.getMaxPieces();
    }
    @Override
    public  int getFighterBays(){
        return origin.getFighterBays();
    }
    @Override
    public  float getMinCrew(){
        return origin.getMinCrew();
    }
    @Override
    public  float getMaxCrew(){
        return origin.getMaxCrew();
    }
    @Override
    public  float getCargo(){
        return origin.getCargo();
    }
    @Override
    public  float getFuel(){
        return origin.getFuel();
    }
    @Override
    public  float getFuelPerLY(){
        return origin.getFuelPerLY();
    }
    @Override
    public  boolean isDHull(){
        return origin.isDHull();
    }
    @Override
    public  boolean isDefaultDHull(){
        return origin.isDefaultDHull();
    }
    @Override
    public void setDParentHullId(java.lang.String arg0){
        origin.setDParentHullId(arg0);
    }
    @Override
    public  java.lang.String getDParentHullId(){
        return origin.getDParentHullId();
    }
    @Override
    public  com.fs.starfarer.api.combat.ShipHullSpecAPI getDParentHull(){
        return origin.getDParentHull();
    }
    @Override
    public  com.fs.starfarer.api.combat.ShipHullSpecAPI getBaseHull(){
        return origin.getBaseHull();
    }
    @Override
    public   java.util.List<java.lang.String> getBuiltInWings(){
        return origin.getBuiltInWings();
    }
    @Override
    public  boolean isBuiltInWing(int arg0){
        return origin.isBuiltInWing(arg0);
    }
    @Override
    public  java.lang.String getDesignation(){
        return origin.getDesignation();
    }
    @Override
    public  boolean hasDesignation(){
        return origin.hasDesignation();
    }
    @Override
    public  boolean isRestoreToBase(){
        return origin.isRestoreToBase();
    }
    @Override
    public  void setRestoreToBase(boolean arg0){
        origin.setRestoreToBase(arg0);
    }
    @Override
    public  org.lwjgl.util.vector.Vector2f getModuleAnchor(){
        return origin.getModuleAnchor();
    }
    @Override
    public  void setModuleAnchor(org.lwjgl.util.vector.Vector2f arg0){
        origin.setModuleAnchor(arg0);
    }
    @Override
    public  void setCompatibleWithBase(boolean arg0){
        origin.setCompatibleWithBase(arg0);
    }
    @Override
    public   java.util.Set<java.lang.String> getTags(){
        return origin.getTags();
    }
    @Override
    public  void addTag(java.lang.String arg0){
        origin.addTag(arg0);
    }
    @Override
    public  boolean hasTag(java.lang.String arg0){
        return origin.hasTag(arg0);
    }
    @Override
    public  float getRarity(){
        return origin.getRarity();
    }
    @Override
    public  java.lang.String getNameWithDesignationWithDashClass(){
        return origin.getNameWithDesignationWithDashClass();
    }
    @Override
    public  java.lang.String getDescriptionId(){
        return origin.getDescriptionId();
    }
    @Override
    public  boolean isBaseHull(){
        return origin.isBaseHull();
    }
    @Override
    public  void setManufacturer(java.lang.String arg0){
        origin.setManufacturer(arg0);
    }
    @Override
    public  java.lang.String getManufacturer(){
        return origin.getManufacturer();
    }
    @Override
    public  int getFleetPoints(){
        return origin.getFleetPoints();
    }
    @Override
    public   java.util.List<java.lang.String> getBuiltInMods(){
        return origin.getBuiltInMods();
    }
    @Override
    public  com.fs.starfarer.api.loading.WeaponSlotAPI getWeaponSlotAPI(java.lang.String arg0){
        return origin.getWeaponSlotAPI(arg0);
    }
    @Override
    public  java.lang.String getDescriptionPrefix(){
        return origin.getDescriptionPrefix();
    }
    @Override
    public  boolean isBuiltInMod(java.lang.String arg0){
        return origin.isBuiltInMod(arg0);
    }
    @Override
    public  void addBuiltInMod(java.lang.String arg0){
        origin.addBuiltInMod(arg0);
    }
    @Override
    public  boolean isCivilianNonCarrier(){
        return origin.isCivilianNonCarrier();
    }
    @Override
    public  void setHullName(java.lang.String arg0){
        origin.setHullName(arg0);
    }
    @Override
    public  void setDesignation(java.lang.String arg0){
        origin.setDesignation(arg0);
    }
    @Override
    public  boolean isPhase(){
        return origin.isPhase();
    }
    @Override
    public  java.lang.String getShipFilePath(){
        return origin.getShipFilePath();
    }
    @Override
    public  java.lang.String getTravelDriveId(){
        return origin.getTravelDriveId();
    }
    @Override
    public  void setTravelDriveId(java.lang.String arg0){
        origin.setTravelDriveId(arg0);
    }
    @Override
    public  com.fs.starfarer.api.combat.ShipHullSpecAPI.EngineSpecAPI getEngineSpec(){
        return origin.getEngineSpec();
    }
    @Override
    public  float getSuppliesToRecover(){
        return origin.getSuppliesToRecover();
    }
    @Override
    public  void setSuppliesToRecover(float arg0){
        origin.setSuppliesToRecover(arg0);
    }
    @Override
    public  float getSuppliesPerMonth(){
        return origin.getSuppliesPerMonth();
    }
    @Override
    public  void setSuppliesPerMonth(float arg0){
        origin.setSuppliesPerMonth(arg0);
    }
    @Override
    public  void setRepairPercentPerDay(float arg0){
        origin.setRepairPercentPerDay(arg0);
    }
    @Override
    public  void setCRToDeploy(float arg0){
        origin.setCRToDeploy(arg0);
    }
    @Override
    public  float getNoCRLossSeconds(){
        return origin.getNoCRLossSeconds();
    }
    @Override
    public  void setNoCRLossSeconds(float arg0){
        origin.setNoCRLossSeconds(arg0);
    }
    @Override
    public  void setCRLossPerSecond(float arg0){
        origin.setCRLossPerSecond(arg0);
    }
    @Override
    public   java.util.HashMap<java.lang.String,java.lang.String> getBuiltInWeapons(){
        return origin.getBuiltInWeapons();
    }
    @Override
    public  boolean isBuiltIn(java.lang.String arg0){
        return origin.isBuiltIn(arg0);
    }
    @Override
    public  void addBuiltInWeapon(java.lang.String arg0, java.lang.String arg1){
        origin.addBuiltInWeapon(arg0, arg1);
    }
    @Override
    public  java.lang.String getShipDefenseId(){
        return origin.getShipDefenseId();
    }
    @Override
    public  void setShipDefenseId(java.lang.String arg0){
        origin.setShipDefenseId(arg0);
    }
    @Override
    public  java.lang.String getShipSystemId(){
        return origin.getShipSystemId();
    }
    @Override
    public  void setShipSystemId(java.lang.String arg0){
        origin.setShipSystemId(arg0);
    }
}
