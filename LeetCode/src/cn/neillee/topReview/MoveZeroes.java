package cn.neillee.topReview;

import java.util.Arrays;

/**
 * @author Neil
 * @date 2017/9/10.
 * @difficulity easy
 * https://leetcode.com/problems/move-zeroes/description/
 */
public class MoveZeroes {
    public static void main(String[] args) {
        MoveZeroes thiz = new MoveZeroes();
        int[] nums = new int[]{0, 1, 0, 3, 12};
        Solution s = thiz.new Solution();
        s.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    class Solution {
        public void moveZeroes(int[] nums) {
            int N = nums.length;
            int p = 0, q = N - 1;
            while (q >= 0 && nums[q] == 0) q--;
            while (p < q) {
                if (nums[p] == 0) {
                    for (int i = p + 1; i <= q; i++) {
                        exch(nums, i, i - 1);
                    }
                    q--;
                } else p++;
            }
        }

        private void exch(int[] a, int i, int j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }
}
