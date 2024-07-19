package model.ModelLocator;

import java.util.ArrayList;

public class ModelLocator {
    // 4 Types of ModelLocator 1. alwaysModelLocator, 2.battleModelLocator, 3.
    // flyingModelLocator, 4.ridingModelLocator,

    private String factoryType;
    private ArrayList<String> pqc = new ArrayList<>();

    private Double animationIncrement;
    private Double movementThreshold;
    private Double rotateAngleX;
    private Double rotateAngleY;
    private Double transparency;
    private Double transparency2;
    private Double xOffset;
    private Double xRotation;
    private Double yOffset;
    private Double yRotation;
    private Double zOffset;
    private Double zRotation;

    public ModelLocator() {
    }

    public String getFactoryType() {
        return factoryType;
    }

    public void setFactoryType(String factoryType) {
        this.factoryType = factoryType;
    }

    public ArrayList<String> getPqc() {
        return pqc;
    }

    public void setPqc(ArrayList<String> pqc) {
        this.pqc = pqc;
    }

    public Double getAnimationIncrement() {
        return animationIncrement;
    }

    public void setAnimationIncrement(Double animationIncrement) {
        this.animationIncrement = animationIncrement;
    }

    public Double getMovementThreshold() {
        return movementThreshold;
    }

    public void setMovementThreshold(Double movementThreshold) {
        this.movementThreshold = movementThreshold;
    }

    public Double getRotateAngleX() {
        return rotateAngleX;
    }

    public void setRotateAngleX(Double rotateAngleX) {
        this.rotateAngleX = rotateAngleX;
    }

    public Double getRotateAngleY() {
        return rotateAngleY;
    }

    public void setRotateAngleY(Double rotateAngleY) {
        this.rotateAngleY = rotateAngleY;
    }

    public ModelLocator(String factoryType, ArrayList<String> pqc, Double animationIncrement, Double movementThreshold,
            Double rotateAngleX,
            Double rotateAngleY, Double transparency, Double transparency2, Double xOffset, Double xRotation,
            Double yOffset, Double yRotation, Double zOffset, Double zRotation) {
        this.factoryType = factoryType;
        this.pqc = pqc;
        this.animationIncrement = animationIncrement;
        this.movementThreshold = movementThreshold;
        this.rotateAngleX = rotateAngleX;
        this.rotateAngleY = rotateAngleY;
        this.transparency = transparency;
        this.transparency2 = transparency2;
        this.xOffset = xOffset;
        this.xRotation = xRotation;
        this.yOffset = yOffset;
        this.yRotation = yRotation;
        this.zOffset = zOffset;
        this.zRotation = zRotation;
    }

    public Double getTransparency() {
        return transparency;
    }

    public void setTransparency(Double transparency) {
        this.transparency = transparency;
    }

    public Double getTransparency2() {
        return transparency2;
    }

    public void setTransparency2(Double transparency2) {
        this.transparency2 = transparency2;
    }

    public Double getxOffset() {
        return xOffset;
    }

    public void setxOffset(Double xOffset) {
        this.xOffset = xOffset;
    }

    public Double getxRotation() {
        return xRotation;
    }

    public void setxRotation(Double xRotation) {
        this.xRotation = xRotation;
    }

    public Double getyOffset() {
        return yOffset;
    }

    public void setyOffset(Double yOffset) {
        this.yOffset = yOffset;
    }

    public Double getyRotation() {
        return yRotation;
    }

    public void setyRotation(Double yRotation) {
        this.yRotation = yRotation;
    }

    public Double getzOffset() {
        return zOffset;
    }

    public void setzOffset(Double zOffset) {
        this.zOffset = zOffset;
    }

    public Double getzRotation() {
        return zRotation;
    }

    public void setzRotation(Double zRotation) {
        this.zRotation = zRotation;
    }

    @Override
    public String toString() {
        return "ModelLocator{" +
                "factoryType='" + factoryType + '\'' +
                ((yRotation != null) ? ", yRotation=" + yRotation : "") +
                '}';
    }
}
