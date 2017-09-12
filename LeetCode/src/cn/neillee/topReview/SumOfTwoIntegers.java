package cn.neillee.topReview;

/**
 * @author Neil
 * @date 2017/9/7.
 * https://leetcode.com/problems/sum-of-two-integers/description/
 */
public class SumOfTwoIntegers {
    public static void main(String[] args){
        SumOfTwoIntegers st = new SumOfTwoIntegers();
        Solution s = st.new Solution();
        int res = s.getSum(2147483647,-2147483648);
        System.out.println(res);
    }
    class Solution {
        public int getSum(int a, int b) {
            double result =  (Math.pow(2,a)*Math.pow(2,b));
            int times = 0;
            boolean minus = result >= 1;

            while (result != 1){
                result = result * (minus?0.5:2);
                times+=  (minus?1:-1);
            }
            return times;
        }
    }
}
