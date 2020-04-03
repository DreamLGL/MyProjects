package collections.ddz;

import java.util.*;

/**
 * @author lgl
 * @Description: 斗地主综合案例(多例):有序版本
 * 1.准备牌
 * 2.洗牌
 * 3.发牌
 * 4.看牌
 * @date 2020/3/12 10:57 下午
 */
public class DouDiZhuMultiton {
    public static void main(String[] args) {
        //准备用户
        ArrayList<String> player1;
        ArrayList<String> player2;
        ArrayList<String> player3;
        ArrayList<String> finalPokers;
        ArrayList<Integer> playerIndex1 = new ArrayList<>();
        ArrayList<Integer> playerIndex2 = new ArrayList<>();
        ArrayList<Integer> playerIndex3 = new ArrayList<>();
        ArrayList<Integer> finalPokersIndex = new ArrayList<>();

        // 1. 准备牌
        ArrayList<String> pokers = initPokers();
        // 2.获取牌序
        Map<Integer, String> pokersMap = sort(pokers);
        ArrayList<Integer> pokersIndex = getIndex(pokersMap);
        // 3. 洗牌
        pokersIndex = changePokers(pokersIndex);
        // 4. 发牌
        for (int i = 0; i < pokersIndex.size(); i++) {
            Integer p = pokersIndex.get(i);
            if (i < 51) {
                if (i % 3 == 0) {
                    playerIndex1.add(p);
                } else if (i % 3 == 1) {
                    playerIndex2.add(p);
                } else {
                    playerIndex3.add(p);
                }
            } else {
                finalPokersIndex.add(p);
            }
        }
        // 5.理牌
        player1 = trimPoker(playerIndex1, pokersMap);
        player2 = trimPoker(playerIndex2, pokersMap);
        player3 = trimPoker(playerIndex3, pokersMap);
        finalPokers = trimPoker(finalPokersIndex, pokersMap);

        // 6.看牌
        System.out.println("player1 : " + player1);
        System.out.println("player1 : " + player1.size());
        System.out.println("player2 : " + player2);
        System.out.println("player2 : " + player2.size());
        System.out.println("player3 : " + player3);
        System.out.println("player3 : " + player3.size());
        System.out.println("finalPokers : " + finalPokers);
        System.out.println("finalPokers : " + finalPokers.size());
    }

    /**
     * 理牌
     *
     * @param playerIndex1
     * @param pokersMap
     * @return
     */
    private static ArrayList<String> trimPoker(ArrayList<Integer> playerIndex1, Map<Integer, String> pokersMap) {
        ArrayList<String> list = new ArrayList<>();
        Collections.sort(playerIndex1);
        for (Integer integer : playerIndex1) {
            list.add(pokersMap.get(integer));
        }
        return list;
    }


    /**
     * 获取牌下标
     *
     * @param pokersMap
     * @return
     */
    private static ArrayList<Integer> getIndex(Map<Integer, String> pokersMap) {
        ArrayList<Integer> list = new ArrayList<>();
        Set<Integer> integers = pokersMap.keySet();
        for (Integer integer : integers) {
            list.add(integer);
        }
        return list;
    }

    /**
     * 得到牌序的map
     *
     * @param pokers
     * @return
     */
    private static Map<Integer, String> sort(ArrayList<String> pokers) {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < pokers.size(); i++) {
            map.put(i, pokers.get(i));
        }
        return map;
    }

    /**
     * 洗牌
     *
     * @param pokers
     * @return
     */
    public static ArrayList<Integer> changePokers(ArrayList<Integer> pokers) {
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
        // 放入大小王
        pokers.addAll(kings);
        // 组装牌
        for (String flower : flowers) {
            for (String size : sizes) {
                pokers.add(flower + size);
            }
        }
        System.out.println("初始化: " + pokers);
        System.out.println("cards : " + pokers.size());
        return pokers;
    }
}
