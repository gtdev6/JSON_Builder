package EvoConditions;

import java.util.Arrays;
import java.util.List;

public enum ScrollBlockType {
    DARKNESS,
    WATERS;

    public static ScrollBlockType getScroll(String scroll) {
        List<ScrollBlockType> scrolls = Arrays.stream(ScrollBlockType.values()).toList().stream()
                .filter(rockEnum -> rockEnum.toString().equals(scroll)).toList();

        return (scrolls.isEmpty()) ? null : scrolls.get(0);
    }
}
