package model;

public class Aggression {
    private Integer timid;
    private Integer passive;
    private Integer aggressive;

    public Integer getTimid() {
        return timid;
    }

    public void setTimid(Integer timid) {
        this.timid = timid;
    }

    public Integer getPassive() {
        return passive;
    }

    public void setPassive(Integer passive) {
        this.passive = passive;
    }

    public Aggression() {
    }

    public Integer getAggressive() {
        return aggressive;
    }

    public void setAggressive(Integer aggressive) {
        this.aggressive = aggressive;
    }

    public void setAll(Integer _timid, Integer _passive, Integer _aggressive) {
        setTimid(_timid);
        setPassive(_passive);
        setAggressive(_aggressive);
    }

    @Override
    public String toString() {
        return "aggression{" +
                "timid=" + timid +
                ", passive=" + passive +
                ", aggressive=" + aggressive +
                '}';
    }
}