package model;

public class SwimmingParameters {
    private Integer depthRangeStart, depthRangeEnd, refreshRate;
    private Double swimSpeed, decayRate;
    private BlockParameter blockParameter;
    private boolean hasBlockParameter;
    private boolean canRotateParameter;

    public boolean isCanRotateParameter() {
        return canRotateParameter;
    }

    public void setCanRotateParameter(boolean canRotateParameter) {
        this.canRotateParameter = canRotateParameter;
    }

    public SwimmingParameters() {
    }

    public SwimmingParameters(int depthMin, int depthMax, int refreshRate, double swimSpeed, double decayRate) {
        this.depthRangeStart = depthMin;
        this.depthRangeEnd = depthMax;
        this.refreshRate = refreshRate;
        this.swimSpeed = swimSpeed;
        this.decayRate = decayRate;
    }

    public BlockParameter getBlockParameter() {
        return blockParameter;
    }

    public void setBlockParameter(BlockParameter blockParameter) {
        this.blockParameter = blockParameter;
    }

    public boolean isHasBlockParameter() {
        return hasBlockParameter;
    }

    public void setHasBlockParameter(boolean hasBlockParameter) {
        this.hasBlockParameter = hasBlockParameter;
    }

    public SwimmingParameters(int depthMin, int depthMax, int refreshRate, double swimSpeed, double decayRate,
            BlockParameter blockParameter) {
        this.depthRangeStart = depthMin;
        this.depthRangeEnd = depthMax;
        this.refreshRate = refreshRate;
        this.swimSpeed = swimSpeed;
        this.decayRate = decayRate;
        this.blockParameter = blockParameter;
    }

    public int getDepthRangeStart() {
        return depthRangeStart;
    }

    public void setDepthRangeStart(int depthRangeStart) {
        this.depthRangeStart = depthRangeStart;
    }

    public int getDepthRangeEnd() {
        return depthRangeEnd;
    }

    public void setDepthRangeEnd(int depthRangeEnd) {
        this.depthRangeEnd = depthRangeEnd;
    }

    public int getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(int refreshRate) {
        this.refreshRate = refreshRate;
    }

    public double getSwimSpeed() {
        return swimSpeed;
    }

    public void setSwimSpeed(double swimSpeed) {
        this.swimSpeed = swimSpeed;
    }

    public double getDecayRate() {
        return decayRate;
    }

    public void setDecayRate(double decayRate) {
        this.decayRate = decayRate;
    }

}
