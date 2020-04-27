package cn.pintia.zjo.practice.Problem1111;

/**
  * @Author lei.zhu
  * @Description blackCards and whiteCards are sorted array, both of same size.
  * @Date 22:22 2020/4/27
  * @Param
  * @return
 **/
public class HighCardRule implements Rule {
    private Card[] blackCards;
    private Card[] whiteCards;

    public HighCardRule(Card[] blackCards, Card[] whiteCards) {
        this.blackCards = blackCards;
        this.whiteCards = whiteCards;
    }


    @Override
    public JudgeResult judge(Card[] blackCards, Card[] whiteCards) {
        JudgeResult result = JudgeResult.Tie;
        for (int i = blackCards.length - 1; i >=0; i--) {
            if (blackCards[i].compareTo(whiteCards[i]) > 0) {
                result = JudgeResult.BLACK_WIN;
            } else if (blackCards[i].compareTo(whiteCards[i]) == 0) {
                result = JudgeResult.Tie;
            } else {
                result = JudgeResult.WHITE_WIN;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
