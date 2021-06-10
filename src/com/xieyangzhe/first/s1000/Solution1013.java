package com.xieyangzhe.first.s1000;

//1013. Partition Array Into Three Parts With Equal Sum
//Easy
//
//732
//
//87
//
//Add to List
//
//Share
//Given an array of integers arr, return true if we can partition the array into three non-empty parts with equal sums.
//
//Formally, we can partition the array if we can find indexes i + 1 < j with (arr[0] + arr[1] + ... + arr[i] == arr[i + 1] + arr[i + 2] + ... + arr[j - 1] == arr[j] + arr[j + 1] + ... + arr[arr.length - 1])
//
//Input: arr = [0,2,1,-6,6,-7,9,1,2,0,1]
//Output: true
//Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
//Example 2:
//
//Input: arr = [0,2,1,-6,6,7,9,-1,2,0,1]
//Output: false
//Example 3:
//
//Input: arr = [3,3,6,5,-2,2,5,1,-9,4]
//Output: true
//Explanation: 3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
//
//
//Constraints:
//
//3 <= arr.length <= 5 * 104
//-104 <= arr[i] <= 104

public class Solution1013 {
    public static void main(String[] args) {
        System.out.println(new Solution1013().canThreePartsEqualSum(new int[]{1,2}));
    }
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        if (sum % 3 != 0) {
            return false;
        }
        int sumSoFar = 0, done = 0;
        for (int num : arr) {
            sumSoFar += num;
            if (sumSoFar == sum / 3) {
                done++;
                sumSoFar = 0;
            }
            if (done == 3) {
                break;
            }
        }
        return done == 3;
    }
}
