package com.xieyangzhe.others;

/**
 * @author Yangzhe Xie
 * @date 9/5/20
 */
public class Tmp {
    public static void main(String[] args) {
        float lastDistance = 10.0f;
        float totalDistance = lastDistance;
        for (int i = 0; i < 9; i++) {
            totalDistance += lastDistance;
            lastDistance /= 2;
        }
        lastDistance /= 2;
        System.out.println(totalDistance);
        System.out.println(lastDistance);
    }
}
