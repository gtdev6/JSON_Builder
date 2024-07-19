package EvoConditions;

public class BlocksWalkedOutsideBallCondition {
    private int blocksToWalk;
    public final String evoConditionType = "blocksToWalkOutsideBall";

    public BlocksWalkedOutsideBallCondition() {
    }

    public BlocksWalkedOutsideBallCondition(int blocksToWalk) {
        this.blocksToWalk = blocksToWalk;
    }

    public int getBlocksToWalk() {
        return blocksToWalk;
    }

    public void setBlocksToWalk(int blocksToWalk) {
        this.blocksToWalk = blocksToWalk;
    }

    @Override
    public String toString() {
        return "{" + "blocksToWalk=" + blocksToWalk + ", evoConditionType='" + evoConditionType + '\'' + '}';
    }
}
