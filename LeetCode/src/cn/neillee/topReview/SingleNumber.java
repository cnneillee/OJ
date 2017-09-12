package cn.neillee.topReview;

import java.util.Arrays;

/**
 * @author Neil
 * @date 2017/9/7.
 * https://leetcode.com/problems/single-number/description/
 */
public class SingleNumber {
    public static void main(String[] args){
        SingleNumber thiz = new SingleNumber();
        SingleNumber.Solution s = thiz.new Solution();
        int res = s.singleNumber(new int[]{1,2,3,2,1});
        System.out.println(res);
    }

    class Solution {
        public int singleNumber(int[] nums) {
            Arrays.sort(nums);
            int N = nums.length;
            for (int i = 1; i < N; i+=2) {
                if (nums[i-1] != nums[i]) return nums[i-1];
            }
            return nums[N-1];
        }
    }
}
