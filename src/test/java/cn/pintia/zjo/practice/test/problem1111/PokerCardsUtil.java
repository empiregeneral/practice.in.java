package cn.pintia.zjo.practice.test.problem1111;

import cn.pintia.zjo.practice.problem1111.Card;

public abstract class PokerCardsUtil {
    /** Sample cards */
    protected Card _2C, _3C, _4C, _5C, _6C, _7C, _8C, _9C, _TC, _JC, _QC, _KC,
            _AC;
    protected Card _2D, _3D, _4D, _5D, _6D, _7D, _8D, _9D, _TD, _JD, _QD, _KD,
            _AD;
    protected Card _2H, _3H, _4H, _5H, _6H, _7H, _8H, _9H, _TH, _JH, _QH, _KH,
            _AH;
    protected Card _2S, _3S, _4S, _5S, _6S, _7S, _8S, _9S, _TS, _JS, _QS, _KS,
            _AS;

    /**
     * Constructor.
     */
    protected PokerCardsUtil() {
        _2C = new Card(Card.Rank.TWO, Card.Suit.C);
        _3C = new Card(Card.Rank.THREE, Card.Suit.C);
        _4C = new Card(Card.Rank.FOUR, Card.Suit.C);
        _5C = new Card(Card.Rank.FIVE, Card.Suit.C);
        _6C = new Card(Card.Rank.SIX, Card.Suit.C);
        _7C = new Card(Card.Rank.SEVEN, Card.Suit.C);
        _8C = new Card(Card.Rank.EIGHT, Card.Suit.C);
        _9C = new Card(Card.Rank.NINE, Card.Suit.C);
        _TC = new Card(Card.Rank.TEN, Card.Suit.C);
        _JC = new Card(Card.Rank.JACK, Card.Suit.C);
        _QC = new Card(Card.Rank.QUEEN, Card.Suit.C);
        _KC = new Card(Card.Rank.KING, Card.Suit.C);
        _AC = new Card(Card.Rank.ACE, Card.Suit.C);

        _2D = new Card(Card.Rank.TWO, Card.Suit.D);
        _3D = new Card(Card.Rank.THREE, Card.Suit.D);
        _4D = new Card(Card.Rank.FOUR, Card.Suit.D);
        _5D = new Card(Card.Rank.FIVE, Card.Suit.D);
        _6D = new Card(Card.Rank.SIX, Card.Suit.D);
        _7D = new Card(Card.Rank.SEVEN, Card.Suit.D);
        _8D = new Card(Card.Rank.EIGHT, Card.Suit.D);
        _9D = new Card(Card.Rank.NINE, Card.Suit.D);
        _TD = new Card(Card.Rank.TEN, Card.Suit.D);
        _JD = new Card(Card.Rank.JACK, Card.Suit.D);
        _QD = new Card(Card.Rank.QUEEN, Card.Suit.D);
        _KD = new Card(Card.Rank.KING, Card.Suit.D);
        _AD = new Card(Card.Rank.ACE, Card.Suit.D);

        _2H = new Card(Card.Rank.TWO, Card.Suit.H);
        _3H = new Card(Card.Rank.THREE, Card.Suit.H);
        _4H = new Card(Card.Rank.FOUR, Card.Suit.H);
        _5H = new Card(Card.Rank.FIVE, Card.Suit.H);
        _6H = new Card(Card.Rank.SIX, Card.Suit.H);
        _7H = new Card(Card.Rank.SEVEN, Card.Suit.H);
        _8H = new Card(Card.Rank.EIGHT, Card.Suit.H);
        _9H = new Card(Card.Rank.NINE, Card.Suit.H);
        _TH = new Card(Card.Rank.TEN, Card.Suit.H);
        _JH = new Card(Card.Rank.JACK, Card.Suit.H);
        _QH = new Card(Card.Rank.QUEEN, Card.Suit.H);
        _KH = new Card(Card.Rank.KING, Card.Suit.H);
        _AH = new Card(Card.Rank.ACE, Card.Suit.H);

        _2S = new Card(Card.Rank.TWO, Card.Suit.S);
        _3S = new Card(Card.Rank.THREE, Card.Suit.S);
        _4S = new Card(Card.Rank.FOUR, Card.Suit.S);
        _5S = new Card(Card.Rank.FIVE, Card.Suit.S);
        _6S = new Card(Card.Rank.SIX, Card.Suit.S);
        _7S = new Card(Card.Rank.SEVEN, Card.Suit.S);
        _8S = new Card(Card.Rank.EIGHT, Card.Suit.S);
        _9S = new Card(Card.Rank.NINE, Card.Suit.S);
        _TS = new Card(Card.Rank.TEN, Card.Suit.S);
        _JS = new Card(Card.Rank.JACK, Card.Suit.S);
        _QS = new Card(Card.Rank.QUEEN, Card.Suit.S);
        _KS = new Card(Card.Rank.KING, Card.Suit.S);
        _AS = new Card(Card.Rank.ACE, Card.Suit.S);
    }
}
