package com.xieyangzhe.com;

public class Main {

    public static void main(String[] args) {
        int[] arr = new int[] {2,3};
        int[][] in = {arr};
        print(new Solution054().spiralOrder(in));
    }

    private static void print(Object obg) {
        System.out.println(obg);
    }
}
