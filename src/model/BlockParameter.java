package model;

import java.util.ArrayList;

public class BlockParameter {
    private Double chanceToStopOnBlock;
    private ArrayList<String> blocksToStopOn;
    private Integer minStopTime;
    private Integer maxStopTime;
    private Integer minStopCooldownTime;
    private Integer maxStopCooldownTime;
    private Boolean canRotateWhileStopped;

    public BlockParameter() {
    }

    public BlockParameter(Double chanceToStopOnBlock, ArrayList<String> blocksToStopOn, Integer minStopTime,
            Integer maxStopTime, Integer minStopCooldownTime, Integer maxStopCooldownTime,
            Boolean canRotateWhileStopped) {
        this.chanceToStopOnBlock = chanceToStopOnBlock;
        this.blocksToStopOn = blocksToStopOn;
        this.minStopTime = minStopTime;
        this.maxStopTime = maxStopTime;
        this.minStopCooldownTime = minStopCooldownTime;
        this.maxStopCooldownTime = maxStopCooldownTime;
        this.canRotateWhileStopped = canRotateWhileStopped;
    }

    public Double getChanceToStopOnBlock() {
        return chanceToStopOnBlock;
    }

    public void setChanceToStopOnBlock(Double chanceToStopOnBlock) {
        this.chanceToStopOnBlock = chanceToStopOnBlock;
    }

    public ArrayList<String> getBlocksToStopOn() {
        return blocksToStopOn;
    }

    public void setBlocksToStopOn(ArrayList<String> blocksToStopOn) {
        this.blocksToStopOn = blocksToStopOn;
    }

    public Integer getMinStopTime() {
        return minStopTime;
    }

    public void setMinStopTime(Integer minStopTime) {
        this.minStopTime = minStopTime;
    }

    public Integer getMaxStopTime() {
        return maxStopTime;
    }

    public void setMaxStopTime(Integer maxStopTime) {
        this.maxStopTime = maxStopTime;
    }

    public Integer getMinStopCooldownTime() {
        return minStopCooldownTime;
    }

    public void setMinStopCooldownTime(Integer minStopCooldownTime) {
        this.minStopCooldownTime = minStopCooldownTime;
    }

    public Integer getMaxStopCooldownTime() {
        return maxStopCooldownTime;
    }

    public void setMaxStopCooldownTime(Integer maxStopCooldownTime) {
        this.maxStopCooldownTime = maxStopCooldownTime;
    }

    public Boolean getCanRotateWhileStopped() {
        return canRotateWhileStopped;
    }

    public void setCanRotateWhileStopped(Boolean canRotateWhileStopped) {
        this.canRotateWhileStopped = canRotateWhileStopped;
    }
}
