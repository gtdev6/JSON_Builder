package model;

public class BattleStats {
    private Integer hp;
    private Integer attack;
    private Integer defense;
    private Integer specialAttack;
    private Integer specialDefense;
    private Integer speed;

    public Integer getHp() {
        return hp;
    }

    public BattleStats() {
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getDefense() {
        return defense;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }

    public Integer getSpecialAttack() {
        return specialAttack;
    }

    public void setSpecialAttack(Integer specialAttack) {
        this.specialAttack = specialAttack;
    }

    public Integer getSpecialDefense() {
        return specialDefense;
    }

    public void setSpecialDefense(Integer specialDefense) {
        this.specialDefense = specialDefense;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public void addAll(Integer _hp, Integer _attack, Integer _defense, Integer _specialAttack, Integer _specialDefense,
            Integer _speed) {
        setHp(_hp);
        setAttack(_attack);
        setDefense(_defense);
        setSpecialAttack(_specialAttack);
        setSpecialDefense(_specialDefense);
        setSpeed(_speed);
    }

    @Override
    public String toString() {
        return "battleStats{" +
                ((hp != null) ? "hp=" + hp : "") +
                ((attack != null) ? ", attack=" + attack : "") +
                ((defense != null) ? ", defense=" + defense : "") +
                ((specialAttack != null) ? ", specialAttack=" + specialAttack : "") +
                ((specialDefense != null) ? ", specialDefense=" + specialDefense : "") +
                ((speed != null) ? ", speed=" + speed : "") +
                '}';
    }
}