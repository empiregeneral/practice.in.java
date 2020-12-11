HDU 3759 题目大意

The standard 52-card deck consists of 52 cards divided into 4 suits: clubs, diamonds, hearts and spades.
For each suit there are 13 ranks: 2, 3, 4, 5, 6, 7, 8, 9, 10, jack, queen, king and ace, listed from the lowest to the highest.
A card is denoted by its rank ('2'. . . '9' for 2. . . 9, 'T' for 10, 'J' for jack, 'Q' for queen, 'K' for king, and 'A' for ace) followed by its suit ('C' for clubs, 'D' for diamonds, 'H' for hearts, and 'S' for spades). Cards are partially ordered by their ranks. The suit does not play a role in the cards ordering. A Poker hand is a set of five distinct cards. Each hand is said to have a certain ranking. A hand with a higher ranking beats a hand with a lower one. Two hands of the same ranking are compared using a tie-breaking rule specific for their ranking | either one of them beats the other or they are tied.
The list of poker rankings is given below, from the worst ranking to the best ranking. If a hand satisfies several rankings, only the best one is considered.

1)High Card | Does not fit into any ranking below. When comparing with another High Card hand, the ranks of the highest cards in the two hands are first compared. If there is a tie, the second highest cards in each hand are compared, and so on. (Example: QS, JH, 9C, 7H, 3D)
2)One Pair | Two cards of the same rank. Pair with higher rank beats the lower pair. In case of a tie, the remaining three cards are used as tie-breakers, compared in the descending order of their ranks (as in High Card). (Example: 6D, 6H, QD, 9H, 4S)
3)Two Pairs | Two pairs of cards of the same rank. When comparing with another Two Pairs hand, the higher pair is first compared, then the lower pair, and finally the rank of the fifth remaining card. (Example: JH, JS, TS, TD, 8S)
4)Three of a Kind | Three cards of the same rank. Three-of-a-kind with the higher rank beats the lower one. In case of a tie, the remaining two cards are used as tie-breakers, compared in the descending order. (Example: 5S, 5H, 5D, JH, 6D)
5)Straight | Five cards in consecutive rank. An ace can either be accounted above a king or below a two, but not both, so wrapping is not allowed. Two straights are compared using the rank of the highest card (in the case of A, 2, 3, 4, 5, the highest card is considered to be 5). (Example: QH,JC, TH, 9D, 8D)
6)Flush | Five cards of the same suit. When comparing two Flushes, the rank of the highest card is first considered, then the second highest and so on (as in High Card). (Example: AS, JS, 8S, 6S,5S)
7)Full House | Three cards of the same rank, and two cards of same rank. When comparing with another Full House, the rank of the three cards is first compared, then the rank of the two cards.(Example: 7S, 7H, 7C, JC, JH)
8)Four of a Kind | Four cards of the same rank. Two four-of-a-kinds are first compared by the ranks of the four cards. In case of a tie, the rank of the fifth card is used as a tie-breaker. (Example: 4C,4D, 4H, 4S, TD)
9)Straight Flush | A hand that is both a Straight and a Flush. Same tie-breaker as for a Straight. (Example: TH, 9H, 8H, 7H, 6H)

Consider the set H of all Poker hands. Let us introduce an evaluation function v : H -> {1 ,..., 7462}, such that for any two Poker hands a and b, a beats b if and only if v(a) > v(b). There exists exactly one such evaluation function v.
Given a Poker hand a, find the value of v(a).

这儿问题也来了，AH 2H 3H 4H 5H在同花顺的队列中怎么排序，设计说明要求是以Rank 5为最大值，程序中显示AH 2H 3H 4H 5H这手牌也是同花顺中最小值

handScore iHandScore计算的分数
pos C1 C2 C3 C4 C5
hc 花色 0 -> C, 1 -> D, 2 -> S, 3 -> H
canflush 是否同花
递归函数generate(int handScore, int pos, int rankOfHight, int hc, boolean canflush)
先进行如下推到
C1   C2   C3   C4   C5
0000 0000 0000 0000 0000 第1次 pos=4 C1 hc = 0 rank = 12
1100 0000 0000 0000 0000 第2次 pos=3 C2 hc = 1 rank = 12
1100 1100 0000 0000 0000 第3次 pos=2 C3 hc = 2 rank = 12
1100 1100 1100 0000 0000 第4次 pos=1 C4 hc = 3 rank = 12
1100 1100 1100 1100 0000 第5次 pos=0 C5 hc = 4 rank = 11
根据hc进行循环，初始化阶段
根据rank进行循环
1100 1100 1100 1100 1011 第6次          pos=0 C5 hc = 1 rank = 10   以下状态存储到List中 通过pos = -2
1100 1100 1100 1100 1010 第7次          pos=0 C5 hc = 1 rank = 9
1100 1100 1100 1100 1001 第8次          pos=0 C5 hc = 1 rank = 8
1100 1100 1100 1100 0111 第9次          pos=0 C5 hc = 1 rank = 7
1100 1100 1100 1100 0110 第10次         pos=0 C5 hc = 1 rank = 6
1100 1100 1100 1100 0101 第11次         pos=0 C5 hc = 1 rank = 5
1100 1100 1100 1100 0100 第12次         pos=0 C5 hc = 1 rank = 4
1100 1100 1100 1100 0011 第13次         pos=0 C5 hc = 1 rank = 3
1100 1100 1100 1100 0010 第14次         pos=0 C5 hc = 1 rank = 2
1100 1100 1100 1100 0001 第15次         pos=0 C5 hc = 1 rank = 1
1100 1100 1100 1100 0000 第16次         pos=0 C5 hc = 1 rank = 0
1100 1100 1100 1011 1011 第17次         pos=1 C4 C5 hc = 1 rank = 11
1100 1100 1100 1011 1010 第18次         pos=0 C4 C5 hc = 1 rank = 10   
1100 1100 1100 1011 1001 第19次
1100 1100 1100 1011 1000 第20次
1100 1100 1100 1011 0111
1100 1100 1100 1011 0110
1100 1100 1100 1011 0101
1100 1100 1100 1011 0100
1100 1100 1100 1011 0011
1100 1100 1100 1011 0010
1100 1100 1100 1011 0001
1100 1100 1100 1011 0000
1100 1100 1100 1010 1010                pos=1
......




-----------------------------------------------------------------------------------------------------------------------------------------

ZJO 1111 题目大意

A poker deck contains 52 cards - each card has a suit which is one of clubs, diamonds, hearts, or spades (denoted C, D, H, S in the input data). Each card also has a value which is one of 2, 3, 4, 5, 6, 7, 8, 9, 10, jack, queen, king, ace (denoted 2, 3, 4, 5, 6, 7, 8, 9, T, J, Q, K, A). For scoring purposes, the suits are unordered while the values are ordered as given above, with 2 being the lowest and ace the highest value.

A poker hand consists of 5 cards dealt from the deck. Poker hands are ranked by the following partial order from lowest to highest

High Card. Hands which do not fit any higher category are ranked by the value of their highest card. If the highest cards have the same value, the hands are ranked by the next highest, and so on.
Pair. 2 of the 5 cards in the hand have the same value. Hands which both contain a pair are ranked by the value of the cards forming the pair. If these values are the same, the hands are ranked by the values of the cards not forming the pair, in decreasing order.
Two Pairs. The hand contains 2 different pairs. Hands which both contain 2 pairs are ranked by the value of their highest pair. Hands with the same highest pair are ranked by the value of their other pair. If these values are the same the hands are ranked by the value of the remaining card.
Three of a Kind. Three of the cards in the hand have the same value. Hands which both contain three of a kind are ranked by the value of the 3 cards.
Straight. Hand contains 5 cards with consecutive values. Hands which both contain a straight are ranked by their highest card.
Flush. Hand contains 5 cards of the same suit. Hands which are both flushes are ranked using the rules for High Card.
Full House. 3 cards of the same value, with the remaining 2 cards forming a pair. Ranked by the value of the 3 cards.
Four of a kind. 4 cards with the same value. Ranked by the value of the 4 cards.
Straight flush. 5 cards of the same suit with consecutive values. Ranked by the highest card in the hand.
Your job is to compare several pairs of poker hands and to indicate which, if either, has a higher rank.

-----------------------------------------------------------------------------------------------------------------------------------------

那么问题来了， 第一手牌：AS 2S 3S 4S 5S 第二手牌：AD KD QD JD TD 哪手牌大， 程序显示是Tie.
按照 ZJO 1111的题目意思这两手牌应该是相等
电影中
周润发（赌神） AH 5H 4H 3H 2H 仇笑痴 KH QH JH TH 9H 所以周润发赢

两个问题一起看，如果将牌面的值计分，符合 ZJO 1111 顺子和同花顺的判断条件，即计算最大牌面的值

