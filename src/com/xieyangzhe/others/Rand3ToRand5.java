package com.xieyangzhe.others;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author Yangzhe Xie
 * @date 21/6/20
 */
public class Rand3ToRand5 {
    private int rand3() {
        return new Random().nextInt(3) + 1;
    }

    private int rand5() {
        int tmp;
        do {
            tmp = rand3() * 3 - rand3() + 1;
        } while (tmp > 5);
        return tmp;
    }

    private int rand7() {
        int tmp;
        do {
            tmp = rand5() * 5 - rand5() + 1;
        } while (tmp > 21);
        return tmp % 7 + 1;
    }

    public static void main(String[] args) {
        Rand3ToRand5 rand3ToRand5 = new Rand3ToRand5();
        Map<Integer, Integer> memo = new HashMap<>();
        for (int i = 0; i < 10000000; i++) {
            int n = rand3ToRand5.rand7();
            memo.put(n, memo.getOrDefault(n, 0) + 1);
        }
        System.out.println(memo);
    }
}
