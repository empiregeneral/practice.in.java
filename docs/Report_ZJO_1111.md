# ZJO 1111 Solved Report

## Subject
模拟香港电影中梭哈的游戏，由黑方和白方的两手牌决定最终的胜者或者平手。
有52张扑克牌，每张牌有4种花色：梅花(club)、方块(diamond)、红桃(heart)和黑桃(spade)。
牌面大小为2, 3, 4, 5, 6, 7, 8, 9, T, J, Q, K, A顺序排列，不考虑花色顺序只考虑牌面顺序。

等级之间的排序规则如下，注意皇家同花顺就是同花顺，题目中不做区分。

<img src="https://a1s.unicdn.net/polopoly_fs/1.696321.1585232084!/image/1470891313.jpg" alt="Poker hand rankings and downloadable cheat sheet" style="zoom:80%;" />

相同等级间排序规则，正如两个人都拿了同样类型的一手牌那样，其规则和题目中描述的一样，英文后有规则的翻译和解释。

- High Card. Hands which do not fit any higher category are ranked by the value of their highest card. If the highest cards have the same value, the hands are ranked by the next highest, and so on. （高牌依次比较的每张牌面的大小，如果都相等就打和。）
- Pair. 2 of the 5 cards in the hand have the same value. Hands which both contain a pair are ranked by the value of the cards forming the pair. If these values are the same, the hands are ranked by the values of the cards not forming the pair, in decreasing order. （对子首先比较的是对子的大小，如果对子大小相等，比较的是剩余牌，每张牌面的大小，如果都相等就打和。）
- Two Pairs. The hand contains 2 different pairs. Hands which both contain 2 pairs are ranked by the value of their highest pair. Hands with the same highest pair are ranked by the value of their other pair. If these values are the same the hands are ranked by the value of the remaining card. （两对比较的是最大的一对牌面的大小，如果都相同的话比较小一对牌面的大小，再相同的话，比较剩余牌面的大小，这个规则最难编写。）
- Three of a Kind. Three of the cards in the hand have the same value. Hands which both contain three of a kind are ranked by the value of the 3 cards. （三条比较的是3张牌，牌面的大小，注意三条在52张牌中只能唯一出现，所以三条的对决无和局。）
- Straight. Hand contains 5 cards with consecutive values. Hands which both contain a straight are ranked by their highest card. （两个人都拿了顺子就比较的是最大的一张牌的大小，如果相等话就是和局。）
- Flush. Hand contains 5 cards of the same suit. Hands which are both flushes are ranked using the rules for High Card.  （同花的比较规则和高牌一样。）
- Full House. 3 cards of the same value, with the remaining 2 cards forming a pair. Ranked by the value of the 3 cards. （葫芦的比较规则和三条类似，比的是3张同样的牌的牌面的大小，葫芦没有和局。）
- Four of a kind. 4 cards with the same value. Ranked by the value of the 4 cards. （四条的比较规则是比较牌面最大的牌的大小，四条没有和局。）
- Straight flush. 5 cards of the same suit with consecutive values. Ranked by the highest card in the hand. （同花顺比较的最大的一张牌的大小，如果相等就是和局。）

## 解题思路

很多网上的答案就是根据牌面计分来计算最终的大小，看过源代码后感觉面条似的代码让人瞧着呕吐，根本无法读。这也是国内很多程序员的通病，写出的代码没有几个人能够看得懂……

这里阅读了 [The Psychic Poker Player]( https://github.com/piotrpl/ThePsychicPokerPlayer.git)

的源代码，Java语言编写Card类对表现扑克牌属性深有启发。

Card类包含了两个枚举，enum Rank和enum Suite分别代表了牌面和花色，每一张牌就代表了Card类实例，设计的简洁明了。

enum HandType是**策略枚举**的集中体现，根据等级之间的规则来判定一副牌是属于哪个等级。

```
public enum HandType implements IHandType{

    HIGH_CARD("HIGH_CARD", 0) {
     ……
    },

    PAIR("PAIR",1) {
       ……
    },
	……
    …… 
    protected abstract boolean isValid(Card[] hand);

 }
```



想通了以上几步后同等级的排序规则可以用**ShowHandType策略枚举**来实现。

在判定输出过程中，可以用简单工厂方法模式来选择ShowHandType中的判定方法。

在此类繁复的模拟程序设计过程中，通过组织相关的测试，可以理清楚每个判断规则的设计的思路。

比如判定HandType的测试用例的设计：

```
@Test
    @Parameters(method = "dataProvider")
    public void testGetHandType(String cards, HandType handType) {
        IHandType machine = new IHandTypeImp(cards);
        Assert.assertEquals(machine.getHandType(), handType);
    }

    private Object[] dataProvider() {
        return $(
                $("3C KD 2S QC AH", HandType.HIGH_CARD),
                $("2C KD 2S QC AH", HandType.PAIR),
                $("KS KD 2S 2D 3H", HandType.TWO_PAIRS),
                $("JS JD KS KD QS", HandType.TWO_PAIRS),
                $("AS AH AC KS JD", HandType.THREE_OF_A_KIND),
                $("2C 3D 4S 5H 6H", HandType.STRAIGHT),
                $("AH 3H 2H KH JH", HandType.FLUSH),
                $("KS KC AH AC AD", HandType.FULL_HOUSE),
                $("2C 2D 2H 2S KS", HandType.FOUR_Of_A_KIND),
                $("TH JH QH KH AH", HandType.STRAIGHT_FLUSH)
        );
    }
```

还有同等级牌面双方的胜负判定用例设计：

```
   @Test
    @Parameters(method = "highCardProvider")
    public void testHighCard(String blackHands, String whiteHands, Judgement result) {
        		Assert.assertEquals(ShowHandJudgement.HIGH_CARD.judgement(toCard(blackHands), toCard(whiteHands)), result);

    }
    
     private Object[] highCardProvider() {
        return $(
                $("AS KH JC 3S TS", "AC KD JD TD 2C", Judgement.BlackWin),
                $("TD 2S 3H 7S 8D", "TC 2D 3C 7H 8C", Judgement.Tie),
                $("9C 8D 7C 2H 3C", "TH 2C 3H 4S 5D", Judgement.WhiteWin)
        );
    }
```



## 经验总结

1. 这是一道非常好的模拟题，通过面向对象、面向接口的编程可以写出非常清晰的基础类的设计，枚举的实现，以及理解如果使用面向接口编程设计原则（理氏替换原则）。
2. 测试用例需要考虑的非常全面，一共设计了36条测试用例，基本覆盖牌面的所有判定规则了。
3. 设计模式方面，简单工厂模式和策略模式特别是枚举策略反复多次的使用。
4. 代码还是略显冗余有1000行之多！？程序是用来读的，相信这些代码比“面条”代码易读的多。

题后思考：
1. 否设计一个发牌程序，这样组织测试代码的数据就容易一些？
2. 可否再精简一下。

## Hit Problems