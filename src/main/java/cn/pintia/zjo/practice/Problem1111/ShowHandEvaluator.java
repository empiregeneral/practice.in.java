package cn.pintia.zjo.practice.problem1111;

import java.util.HashSet;
import java.util.Set;

public class ShowHandEvaluator {

    /**
     * 两个排序的数组比较最后一张牌的大小
     * @param blackHand
     * @param whiteHand
     * @return
     */
    public static Judgement straightFlush(Card[] blackHand, Card[] whiteHand) {
        int indexOfCard = 4;
        if (blackHand[indexOfCard].compareTo(whiteHand[indexOfCard]) >0) {
            return Judgement.BlackWin;
        } else if (blackHand[indexOfCard].compareTo(whiteHand[indexOfCard]) == 0) {
            return Judgement.Tie;
        } else {
            return Judgement.WhiteWin;
        }
    }

    public static Judgement fourOfAKind(Card[] blackHand, Card[] whiteHand) {
        Card blackCard = findRepeatRankCard(blackHand);
        Card whiteCard = findRepeatRankCard(whiteHand);

        if (blackCard.compareTo(whiteCard) >=0) {
            return Judgement.BlackWin;
        } else {
            return Judgement.WhiteWin;
        }
    }

    /**
     * 葫芦的判定规则是3张牌的大小
     * @param blackHand
     * @param whiteHand
     * @return
     */
    public static Judgement fullHouse(Card[] blackHand, Card[] whiteHand) {
        Card bCard = null;
        Card wCard = null;

        for (int i = 0; i < blackHand.length - 2; i++) {
            if (blackHand[i].getRank() == blackHand[i + 1].getRank()
                    && blackHand[i + 1].getRank() == blackHand[i + 2].getRank()) {
                bCard = blackHand[i];
                break;
            }
        }

        for (int i = 0; i < blackHand.length - 2; i++) {
            if (whiteHand[i].getRank() == whiteHand[i + 1].getRank()
                    && whiteHand[i + 1].getRank() == whiteHand[i + 2].getRank()) {
                wCard = whiteHand[i];
                break;
            }
        }

        if (bCard.compareTo(wCard) >= 0) {
            return Judgement.BlackWin;
        } else {
            return Judgement.WhiteWin;
        }
    }

    /**
     * 同花的判定规则和高牌的判定规则相同，都依次比较最大的一张牌
     * @param blackHand
     * @param whiteHand
     * @return
     */
    public static Judgement flush(Card[] blackHand, Card[] whiteHand) {
        Card bCard = null;
        Card wCard = null;

        Judgement result = Judgement.Tie;
        for (int len = blackHand.length - 1; len >=0; len--) {
            bCard = blackHand[len];
            wCard = whiteHand[len];
            if (bCard.compareTo(wCard) > 0 ) {
                result = Judgement.BlackWin;
                break;
            } else if (bCard.compareTo(wCard) == 0) {
                result = Judgement.Tie;
            } else {
                result = Judgement.WhiteWin;
                break;
            }
        }
        return result;
    }

    /**
     * 顺子比较的是最大的一张牌，两个排序后的数组肯定是最后一张牌的大小
     * @param blackHand
     * @param whiteHand
     * @return
     */
    public static Judgement straight(Card[] blackHand, Card[] whiteHand) {
        int indexOfCard = 4;
        if (blackHand[indexOfCard].compareTo(whiteHand[indexOfCard]) > 0) {
            return Judgement.BlackWin;
        } else if (blackHand[indexOfCard].compareTo(whiteHand[indexOfCard]) == 0) {
            return Judgement.Tie;
        } else {
            return Judgement.WhiteWin;
        }
    }

    public static Judgement threeOfKind(Card[] blackHand, Card[] whiteHand) {
        Card bCard = null;
        Card wCard = null;

        for (int i = 0; i < blackHand.length - 2; i++) {
            if (blackHand[i].getRank() == blackHand[i + 1].getRank()
                    && blackHand[i + 1].getRank() == blackHand[i + 2].getRank()) {
                bCard = blackHand[i];
                break;
            }
        }

        for (int i = 0; i < blackHand.length - 2; i++) {
            if (whiteHand[i].getRank() == whiteHand[i + 1].getRank()
                    && whiteHand[i + 1].getRank() == whiteHand[i + 2].getRank()) {
                wCard = whiteHand[i];
                break;
            }
        }

        if (bCard.compareTo(wCard) >= 0) {
            return Judgement.BlackWin;
        } else {
            return Judgement.WhiteWin;
        }
    }

    public static Judgement twoPair(Card[] blackHand, Card[] whiteHand) {
        return null;
    }

    public static Judgement pair(Card[] blackHand, Card[] whiteHand) {
        return null;
    }

    /**
     * 两手牌已经排序好了，一次求最大的牌好了
     * @param blackHand
     * @param whiteHand
     * @return
     */
    public static Judgement highCard(Card[] blackHand, Card[] whiteHand) {
        Card bCard = null;
        Card wCard = null;

        Judgement result = Judgement.Tie;
        for (int len = blackHand.length - 1; len >=0; len--) {
            bCard = blackHand[len];
            wCard = whiteHand[len];
            if (bCard.compareTo(wCard) > 0 ) {
                result = Judgement.BlackWin;
                break;
            } else if (bCard.compareTo(wCard) == 0) {
                result = Judgement.Tie;
            } else {
                result = Judgement.WhiteWin;
                break;
            }
        }
        return result;
    }

    /**
     * 判断4条中相同的牌
     * @param cards
     * @return
     */
    private static Card findRepeatRankCard(Card[] cards) {
        Set<Card.Rank> set = new HashSet<>();
        int index = 0;
        for (int i = 0; i < cards.length; ++i) {
            if (!set.add(cards[i].rank)) {
                index = i;
                break;
            }
        }
        return cards[index];
    }

}
