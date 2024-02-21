package 集合;

import java.io.FileReader;
import java.util.*;

/**
 * 实现斗地主的洗牌、发牌和看牌（牌自动排好序）
 */
public class FightingTheLandlord {
    private HashMap<Integer, String> pokers;    //存放所有牌和对应的索引
    private List<Integer> indexes;  //存放牌的索引，用来洗牌和发牌

    /**
     * 构造方法，得到一副新牌和对应索引
     */
    public FightingTheLandlord() {
        pokers = new HashMap<>();
        indexes = new ArrayList<>();
        String[] suit = {"♠", "♦", "♥", "♣"};   //存放花色
        String[] faceValue = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        int index = 0;
        for (String s : suit) {
            for (String s1 : faceValue) {
                pokers.put(index, s + s1);    //将牌和对应索引值存放到哈希映射中
                indexes.add(index++);
            }
        }
        pokers.put(index, "小王");
        indexes.add(index++);
        pokers.put(index, "大王");
        indexes.add(index);
    }

    /**
     * 洗牌、发牌和看牌的具体操作
     */
    public void operate() {
        Collections.shuffle(indexes);   //将牌打乱

        //将牌发给3个人，并留下底牌
        TreeSet<Integer> human1 = new TreeSet<>();
        TreeSet<Integer> human2 = new TreeSet<>();
        TreeSet<Integer> human3 = new TreeSet<>();
        TreeSet<Integer> holeCard = new TreeSet<>();
        for (int i = 0; i < indexes.size(); i++) {
            int element = indexes.get(i);
            if (i >= indexes.size() - 3)
                holeCard.add(element);
            else if (i % 3 == 0)
                human1.add(element);
            else if (i % 3 == 1)
                human2.add(element);
            else if (i % 3 == 2)
                human3.add(element);
        }

        //让3个人看牌，和看到底牌
        checkTheCards(human1);
        checkTheCards(human2);
        checkTheCards(human3);
        checkTheCards(holeCard);
    }

    /**
     * 实现看牌操作
     * @param poker 要看的牌
     */
    public void checkTheCards(TreeSet<Integer> poker) {
        for (int s : poker) {
            System.out.printf("%4s", pokers.get(s));
        }
        System.out.println();
    }
}

class Test {
    public static void main(String[] args) {
        FightingTheLandlord fightingTheLandlord = new FightingTheLandlord();
        fightingTheLandlord.operate();
    }
}
