package EvoConditions;

import java.util.Arrays;

public class RecoilCondition {
    private int recoil;
    public final String evoConditionType = "recoil";

    public RecoilCondition(int recoil) {
        this.recoil = recoil;
    }

    public int getRecoil() {
        return recoil;
    }

    public void setRecoil(int recoil) {
        this.recoil = recoil;
    }

    @Override
    public String toString() {
        return "{" + "recoil=" + recoil + ", evoConditionType='" + evoConditionType + '\'' + '}';
    }

}
