package EvoConditions;

public class FriendshipCondition {
    private int friendship;
    public final String evoConditionType = "friendship";

    public FriendshipCondition(int friendship) {
        this.friendship = friendship;
    }

    public int getFriendship() {
        return friendship;
    }

    public void setFriendship(int friendship) {
        this.friendship = friendship;
    }

    @Override
    public String toString() {
        return "{" + "friendship=" + friendship + ", evoConditionType='" + evoConditionType + '\'' + '}';
    }

}
