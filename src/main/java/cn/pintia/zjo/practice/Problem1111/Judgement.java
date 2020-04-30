package cn.pintia.zjo.practice.problem1111;

/**
 * @author Administrator
 */

public enum Judgement {
    BlackWin("Black Win."),
    Tie("Tie."),
    WhiteWin("White Win."),
    ;
    private String description;

    Judgement(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
