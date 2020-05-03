package cn.pintia.zjo.practice.problem1111;

/**
 * @author Administrator
 */

public enum Judgement {
    BlackWin("Black wins."),
    Tie("Tie."),
    WhiteWin("White wins."),
    ;
    private String description;

    Judgement(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
