package model;

public class RidingOffSets {
    private Standing standing;
    private Moving moving;

    public RidingOffSets() {
    }

    public RidingOffSets(Moving moving, Standing standing) {
        this.moving = moving;
        this.standing = standing;
    }

    public Moving getMoving() {
        return moving;
    }

    public void setMoving(Moving moving) {
        this.moving = moving;
    }

    public Standing getStanding() {
        return standing;
    }

    public void setStanding(Standing standing) {
        this.standing = standing;
    }
}
