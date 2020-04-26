package com.xieyangzhe.second;

/**
 * @author Yangzhe Xie
 * @date 26/4/20
 */
public class Solution526 {
    //526. Beautiful Arrangement
    //Suppose you have N integers from 1 to N. We define a beautiful arrangement as an array that is constructed by these N numbers successfully if one of the following is true for the ith position (1 <= i <= N) in this array:
    //
    //The number at the ith position is divisible by i.
    //i is divisible by the number at the ith position.
    //
    //
    //Now given N, how many beautiful arrangements can you construct?
    private int cnt = 0;
    private boolean[] used;

    public int countArrangement(int N) {
        used = new boolean[N + 1];
        dfs(N, 1);
        return cnt;
    }

    private void dfs(int N, int index) {
        if (index > N) {
            cnt++;
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!used[i] && (index % i == 0 || i % index == 0)) {
                used[i] = true;
                dfs(N, index + 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution526().countArrangement(2));
    }
}
