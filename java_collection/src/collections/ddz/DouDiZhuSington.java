package collections.ddz;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author lgl
 * @Description: 斗地主综合案例(单例)
 * 1.准备牌
 * 2.洗牌
 * 3.发牌
 * 4.看牌
 * @date 2020/3/12 10:57 下午
 */
public class DouDiZhuSington {
    public static void main(String[] args) {
        //准备用户
        ArrayList<String> user1 = new ArrayList<>();
        ArrayList<String> user2 = new ArrayList<>();
        ArrayList<String> user3 = new ArrayList<>();
        ArrayList<String> finalPokers = new ArrayList<>();

        // 1.初始化的牌/准备牌
        ArrayList<String> pokers = initPokers();
        // 2.洗牌
        pokers = changePokers(pokers);
        // 3. 发牌
        for (int i = 0; i < pokers.size(); i++) {
            String p = pokers.get(i);
            if (i < 51) {
                if (i % 3 == 0) {
                    user1.add(p);
                } else if (i % 3 == 1) {
                    user2.add(p);
                } else {
                    user3.add(p);
                }
            } else {
                finalPokers.add(p);
            }
        }
        // 4. 看牌
        System.out.println("user1 : "+ user1);
        System.out.println("user1 : "+user1.size());
        System.out.println("user2 : "+ user2);
        System.out.println("user2 : "+user2.size());
        System.out.println("user3 : "+ user3);
        System.out.println("user3 : "+user3.size());
        System.out.println("finalPokers : "+ finalPokers);
        System.out.println("finalPokers : "+finalPokers.size());
    }

    /**
     * 洗牌
     *
     * @param pokers
     * @return
     */
    public static ArrayList<String> changePokers(ArrayList<String> pokers) {
        Collections.shuffle(pokers);
        System.out.println("洗牌: " + pokers);
        System.out.println("cards : " + pokers.size());
        return pokers;
    }

    /**
     * 1. 准备(初始化)牌
     *
     * @return
     */
    public static ArrayList<String> initPokers() {
        // 准备牌集合
        ArrayList<String> pokers = new ArrayList<>();
        // 准备花色集合
        ArrayList<String> flowers = new ArrayList<>();
        flowers.add("♠");
        flowers.add("♥");
        flowers.add("♣");
        flowers.add("♦");
        // 准备大小集合
        ArrayList<String> sizes = new ArrayList<>();
        for (int i = 2; i < 11; i++) {
            sizes.add(i + "");
        }
        sizes.add("J");
        sizes.add("Q");
        sizes.add("K");
        sizes.add("A");
        // 准备大小王集合
        ArrayList<String> kings = new ArrayList<>();
        kings.add("大王");
        kings.add("小王");
        // 组装牌
        for (String flower : flowers) {
            for (String size : sizes) {
                pokers.add(flower + size);
            }
        }
        // 放入大小王
        pokers.addAll(kings);
        System.out.println("初始化: " + pokers);
        System.out.println("cards : " + pokers.size());
        return pokers;
    }
}
