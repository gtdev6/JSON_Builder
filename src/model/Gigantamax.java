package model;

public class Gigantamax {
    private Boolean canHaveFactor;
    private Boolean canGigantamax;
    private String form;
    private String move;

    public Gigantamax() {
    }

    public Gigantamax(Boolean canHaveFactor, Boolean canGigantamax, String form, String move) {
        this.canHaveFactor = canHaveFactor;
        this.canGigantamax = canGigantamax;
        this.form = form;
        this.move = move;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getMove() {
        return move;
    }

    public void setMove(String move) {
        this.move = move;
    }

    public Boolean isCanHaveFactor() {
        return canHaveFactor;
    }

    public void setCanHaveFactor(Boolean canHaveFactor) {
        this.canHaveFactor = canHaveFactor;
    }

    public Boolean isCanGigantamax() {
        return canGigantamax;
    }

    public void setCanGigantamax(Boolean canGigantamax) {
        this.canGigantamax = canGigantamax;
    }

    public void setAll(Boolean _canHaveFactor, Boolean _canGigantamax) {
        setCanHaveFactor(_canHaveFactor);
        setCanGigantamax(_canGigantamax);
    }

}
