package model;

public class Dimensions {
    private Double height;
    private Double width;
    private Integer length;
    private Double eyeHeight;
    private Double hoverHeight;

    public Dimensions() {
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Double getEyeHeight() {
        return eyeHeight;
    }

    public void setEyeHeight(Double eyeHeight) {
        this.eyeHeight = eyeHeight;
    }

    public Double getHoverHeight() {
        return hoverHeight;
    }

    public void setHoverHeight(Double hoverHeight) {
        this.hoverHeight = hoverHeight;
    }

    @Override
    public String toString() {
        return "Dimension { Height: " + getHeight() + ", Width: " + getWidth() + ", Length: " + getLength()
                + ", EyeHeight: " + getEyeHeight() +
                ", HoverHeight: " + getHoverHeight() + " }, ";
    }
}