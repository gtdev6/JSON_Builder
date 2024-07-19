package model;

public class Movement {
    private boolean rideable;
    private boolean canFly;
    private boolean canSurf;
    private boolean canRideShoulder = false;

    private RidingOffSets ridingOffsets;

    private FlyingParameters flyingParameters;
    private SwimmingParameters swimmingParameters;
    private MountedFlyingParameters mountedFlyingParameters;

    public RidingOffSets getRidingOffSets() {
        return ridingOffsets;
    }

    public void setRidingOffSets(RidingOffSets ridingOffSets) {
        this.ridingOffsets = ridingOffSets;
    }

    public Movement() {
    }

    public Movement(boolean rideable, boolean canFly, boolean canSurf, boolean canRideShoulder) {
        this.rideable = rideable;
        this.canFly = canFly;
        this.canSurf = canSurf;
        this.canRideShoulder = canRideShoulder;
    }

    public Movement(boolean rideable, boolean canFly, boolean canSurf, boolean canRideShoulder,
            RidingOffSets ridingOffsets, FlyingParameters flyingParameters, SwimmingParameters swimmingParameters,
            MountedFlyingParameters mountedFlyingParameters) {
        this.rideable = rideable;
        this.canFly = canFly;
        this.canSurf = canSurf;
        this.canRideShoulder = canRideShoulder;
        this.ridingOffsets = ridingOffsets;
        this.flyingParameters = flyingParameters;
        this.swimmingParameters = swimmingParameters;
        this.mountedFlyingParameters = mountedFlyingParameters;
    }

    public FlyingParameters getFlyingParameters() {
        return flyingParameters;
    }

    public void setFlyingParameters(FlyingParameters flyingParameters) {
        this.flyingParameters = flyingParameters;
    }

    public SwimmingParameters getSwimmingParameters() {
        return swimmingParameters;
    }

    public void setSwimmingParameters(SwimmingParameters swimmingParameters) {
        this.swimmingParameters = swimmingParameters;
    }

    public MountedFlyingParameters getMountedFlyingParameters() {
        return mountedFlyingParameters;
    }

    public void setMountedFlyingParameters(MountedFlyingParameters mountedFlyingParameters) {
        this.mountedFlyingParameters = mountedFlyingParameters;
    }

    public boolean isRideable() {
        return rideable;
    }

    public void setRideable(boolean rideable) {
        this.rideable = rideable;
    }

    public boolean isCanFly() {
        return canFly;
    }

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }

    public boolean isCanSurf() {
        return canSurf;
    }

    public void setCanSurf(boolean canSurf) {
        this.canSurf = canSurf;
    }

    public boolean isCanRideShoulder() {
        return canRideShoulder;
    }

    public void setCanRideShoulder(boolean canRideShoulder) {
        this.canRideShoulder = canRideShoulder;
    }

    public void setAll(boolean rideable, boolean fly, boolean surf, boolean rideShoulder, RidingOffSets ridingOffSets,
            SwimmingParameters swimmingParameters, FlyingParameters flyingParameters,
            MountedFlyingParameters mountedFlyingParameters) {
        this.rideable = rideable;
        this.canFly = fly;
        this.canSurf = surf;
        this.canRideShoulder = rideShoulder;
        this.ridingOffsets = ridingOffSets;
        this.swimmingParameters = swimmingParameters;
        this.flyingParameters = flyingParameters;
        this.mountedFlyingParameters = mountedFlyingParameters;
    }

    @Override
    public String toString() {
        return "movement{" +
                "rideable=" + rideable +
                ", canFly=" + canFly +
                ", canSurf=" + canSurf +
                ", canRideShoulder=" + canRideShoulder +
                '}';
    }
}