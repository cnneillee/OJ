package cn.neillee.topReview;

/**
 * @author Neil
 * @date 2017/9/7.
 * https://leetcode.com/problems/reverse-string/description/
 * @difficulity Easy
 */
public class ReverseString {
    public static void main(String[] args){
        ReverseString thiz = new ReverseString();
        Solution s = thiz.new Solution();
        String res = s.reverseString("hello");
        System.out.println(res);
    }
    class Solution {
        public String reverseString(String s) {
            int N = s.length();
            byte[] bytes = s.getBytes();
            for (int i = 0; i < N/2; i++) {
                exch(bytes,i,N-1-i);
            }
            return new String(bytes);
        }

        private void exch(byte[] bytes, int i, int i1) {
            byte temp = bytes[i];
            bytes[i]=bytes[i1];
            bytes[i1]=temp;
        }
    }
}
