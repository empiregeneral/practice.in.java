package cn.pintia.zjo.practice.problem1111;

import java.util.*;

public class ShowHandEvaluator {

    /**
     * @descrition 两个人一手牌经过HandType判定后，在同是一个HandType场景之下，判断牌面大小。
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

        if (blackCard.compareTo(whiteCard) > 0) {
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
        TwoPairs bTwoPairs = new TwoPairs(blackHand);
        TwoPairs wTwoPairs = new TwoPairs(whiteHand);

        Comparator<TwoPairs> comparator = new TwoPairsComparator();
        int result = comparator.compare(bTwoPairs, wTwoPairs);
        if (result > 0) {
            return Judgement.BlackWin;
        } else if (result == 0) {
            return Judgement.Tie;
        } else {
            return Judgement.WhiteWin;
        }
    }

    public static Judgement pair(Card[] blackHand, Card[] whiteHand) {
        Card bCard = findRepeatRankCard(blackHand);
        Card[] bRemainderCards = remainderCards(blackHand, bCard);
        Card wCard = findRepeatRankCard(whiteHand);
        Card[] wRemainderCards = remainderCards(whiteHand, bCard);
        Judgement result = Judgement.Tie;

        if (bCard.compareTo(wCard) > 0) {
            result = Judgement.BlackWin;
        } else if (bCard.compareTo(wCard) == 0) {
            for (int i = bRemainderCards.length - 1; i >= 0; i--) {
                Card bTmpCard = bRemainderCards[i];
                Card wTmpCard = wRemainderCards[i];
                if (bTmpCard.compareTo(wTmpCard) == 0) {
                    result = Judgement.Tie;
                } else if (bTmpCard.compareTo(wTmpCard) > 0){
                    result = Judgement.BlackWin;
                    break;
                } else {
                    result = Judgement.WhiteWin;
                    break;
                }
            }
        } else {
            result = Judgement.WhiteWin;
        }

        return result;
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

    private static Card[] remainderCards(Card[] cards, Card repeatedCard) {
        Set<Card> set = new TreeSet<>();
        for (int i = 0; i < cards.length; i++) {
            set.add(cards[i]);
        }
        set.remove(repeatedCard);
        int size = set.size();
        return set.toArray(new Card[size]);
    }

    private static class TwoPairs {
        private Card[] originCards;
        private Card[] pairsOfCards;
        private Card remainderCard;

        public TwoPairs(Card[] cards) {
            this.originCards = cards;
            boolean[] flags = new boolean[]{false, false, false, false, false};
            int indx = -1;
            for (int i = 0 ; i < originCards.length - 1; i++) {
                if ((originCards[i].compareTo(originCards[i+1]) == 0)) {
                    indx = i;
                    flags[i] = true;
                    flags[i+1] = true;
                    break;
                }
            }

            for (int i = indx + 2; i < originCards.length - 1; i++) {
                if (originCards[i].compareTo(originCards[i+1]) == 0) {
                    flags[i] = true;
                    flags[i+1] = true;
                }
            }

            for (int i = 0 ; i < flags.length; i++) {
                if (!flags[i]) {
                    remainderCard = originCards[i];
                }
            }

            Set<Card> cardSet = new TreeSet<>();
            for (int i = 0; i < originCards.length; i++) {
                cardSet.add(originCards[i]);
            }
            cardSet.remove(remainderCard);
            pairsOfCards = cardSet.toArray(new Card[(originCards.length / 2) - 1]);
        }

        public Card[] getPairsOfCards() {
            return pairsOfCards;
        }

        public Card getRemainderCard() {
            return remainderCard;
        }

    }

    private static class TwoPairsComparator implements Comparator<TwoPairs> {

        @Override
        public int compare(TwoPairs o1, TwoPairs o2) {
            Card[] bPairsOfCards = o1.getPairsOfCards();
            Card bRemainderCard = o1.getRemainderCard();

            Card[] wPairsOfCards = o2.getPairsOfCards();
            Card wRemainderCard = o2.getRemainderCard();

            int result = 0;

            for (int i = bPairsOfCards.length - 1; i >=0 ; i--) {
                if (bPairsOfCards[i].compareTo(wPairsOfCards[i]) > 0) {
                    result = 1;
                    break;
                } else if (bPairsOfCards[i].compareTo(wPairsOfCards[i]) == 0) {
                    if (bRemainderCard.compareTo(wRemainderCard) > 0) {
                        result = 1;
                    } else if (bRemainderCard.compareTo(wRemainderCard) == 0) {
                        result = 0;
                    } else {
                        result = -1;
                    }
                } else {
                    result = -1;
                    break;
                }
            }
            return result;
        }
    }
}
