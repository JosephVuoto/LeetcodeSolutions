package com.xieyangzhe.com.s500;

/**
 * @author Yangzhe Xie
 * @date 10/1/20
 */
public class Solution453 {
    //453. Minimum Moves to Equal Array Elements
    //Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.
    //
    //Example:
    //
    //Input:
    //[1,2,3]
    //
    //Output:
    //3
    //
    //Explanation:
    //Only three moves are needed (remember each move increments two elements):
    //
    //[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int num: nums) {
            min = Math.min(min, num);
        }
        for (int num: nums) {
            result += (num - min);
        }
        return result;
    }
}
