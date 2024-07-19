package EvoConditions;

public class HeldItemCondition {
    private Item item;
    public final String evoConditionType = "heldItem";

    public HeldItemCondition() {
    }

    public HeldItemCondition(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "{" +
                "item=" + item +
                ", evoConditionType='" + evoConditionType + '\'' +
                '}';
    }
}
