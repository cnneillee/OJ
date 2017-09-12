package cn.neillee.topReview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Neil
 * @date 2017/9/7.
 * @difficulity easy
 * https://leetcode.com/problems/fizz-buzz/description/
 */
public class FizzBuzz {
    public static void main(String[] args){
        FizzBuzz thiz = new FizzBuzz();
        Solution s = thiz.new Solution();
        List res = s.fizzBuzz(15);
        System.out.println(res);
    }
    class Solution {
        public List<String> fizzBuzz(int n) {
            if (n<=0)return null;
            List<String> res = new ArrayList<>();
//            while (n > 0){
//                if (n%15 == 0) res.add("FizzBuzz");
//                else if (n%5 == 0) res.add("Buzz");
//                else if (n%3 == 0) res.add("Fizz");
//                else res.add(n+"");
//                n--;
//            }
            for (int i = 1; i < n+1; i++) {
                if (i%15 == 0) res.add("FizzBuzz");
                else if (i%5 == 0) res.add("Buzz");
                else if (i%3 == 0) res.add("Fizz");
                else res.add(i+"");
            }
            return res;
        }
    }
}
