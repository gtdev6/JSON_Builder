package model;

public class FlyingParameters {
    private int flyHeightMin, flyHeightMax, flyRefreshRateY, flyRefreshRateXZ, flyRefreshRateSpeed, flightTimeMin,
            flightTimeMax, flapRate;
    private double flySpeedModifier;
    private String landingMaterials;

    public FlyingParameters() {
    };

    // public FlyingParameters(int flyHeightMin, int flyHeightMax, int
    // flyRefreshRateY, int flyRefreshRateXZ, int flyRefreshRateSpeed, int
    // flightTimeMin, int flightTimeMax, int flapRate, double flySpeedModifier,
    // ArrayList<String> landingMaterials) {
    // this.flyHeightMin = flyHeightMin;
    // this.flyHeightMax = flyHeightMax;
    // this.flyRefreshRateY = flyRefreshRateY;
    // this.flyRefreshRateXZ = flyRefreshRateXZ;
    // this.flyRefreshRateSpeed = flyRefreshRateSpeed;
    // this.flightTimeMin = flightTimeMin;
    // this.flightTimeMax = flightTimeMax;
    // this.flapRate = flapRate;
    // this.flySpeedModifier = flySpeedModifier;
    // this.landingMaterials = landingMaterials;
    // }

    public FlyingParameters(int heightMin, int flyHeightMax, int flyRefreshRateY, int flyRefreshRateXZ,
            int flyRefreshRateSpeed, int flightTimeMin, int flightTimeMax, int flapRate, double speedMod,
            String landingMaterials) {
        this.flyHeightMin = heightMin;
        this.flyHeightMax = flyHeightMax;
        this.flyRefreshRateY = flyRefreshRateY;
        this.flyRefreshRateXZ = flyRefreshRateXZ;
        this.flyRefreshRateSpeed = flyRefreshRateSpeed;
        this.flightTimeMin = flightTimeMin;
        this.flightTimeMax = flightTimeMax;
        this.flapRate = flapRate;
        this.flySpeedModifier = speedMod;
        this.landingMaterials = landingMaterials;
    }

    public int getFlyHeightMin() {
        return flyHeightMin;
    }

    public void setFlyHeightMin(int flyHeightMin) {
        this.flyHeightMin = flyHeightMin;
    }

    public int getFlyHeightMax() {
        return flyHeightMax;
    }

    public void setFlyHeightMax(int flyHeightMax) {
        this.flyHeightMax = flyHeightMax;
    }

    public int getFlyRefreshRateY() {
        return flyRefreshRateY;
    }

    public void setFlyRefreshRateY(int flyRefreshRateY) {
        this.flyRefreshRateY = flyRefreshRateY;
    }

    public int getFlyRefreshRateXZ() {
        return flyRefreshRateXZ;
    }

    public void setFlyRefreshRateXZ(int flyRefreshRateXZ) {
        this.flyRefreshRateXZ = flyRefreshRateXZ;
    }

    public int getFlyRefreshRateSpeed() {
        return flyRefreshRateSpeed;
    }

    public void setFlyRefreshRateSpeed(int flyRefreshRateSpeed) {
        this.flyRefreshRateSpeed = flyRefreshRateSpeed;
    }

    public int getFlightTimeMin() {
        return flightTimeMin;
    }

    public void setFlightTimeMin(int flightTimeMin) {
        this.flightTimeMin = flightTimeMin;
    }

    public int getFlightTimeMax() {
        return flightTimeMax;
    }

    public void setFlightTimeMax(int flightTimeMax) {
        this.flightTimeMax = flightTimeMax;
    }

    public int getFlapRate() {
        return flapRate;
    }

    public void setFlapRate(int flapRate) {
        this.flapRate = flapRate;
    }

    public double getFlySpeedModifier() {
        return flySpeedModifier;
    }

    public void setFlySpeedModifier(double flySpeedMod) {
        this.flySpeedModifier = flySpeedMod;
    }

    // public ArrayList<String> getLandingMaterials() {
    // return landingMaterials;
    // }
    //
    // public void setLandingMaterials(ArrayList<String> landingMaterials) {
    // this.landingMaterials = landingMaterials;
    // }

    public String getLandingMaterials() {
        return landingMaterials;
    }

    public void setLandingMaterials(String landingMaterials) {
        this.landingMaterials = landingMaterials;
    }

}
