//package cn.neillee;
//
//import java.util.ArrayList;
//import java.util.Collections;
//
///**
// * @author Neil
// * @date 2017/9/7.
// * https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/description/
// */
//public class KthSmallestNumberInMultiplicationTable {
//    public static void main(String[] args) {
//        System.out.println(new Solution().findKthNumber(2,3,6));
//    }
///*
//根据规律，计算出位置：
//  j/i | 1  2  3  4  5  6  7
//    1   1  2  3  4  5  6  7
//    2   2  4  6  8  10 12 14
//    3   3  6  9
//    4   4
//    5   5
//    6   6
//    7   7
// */
//    static class Solution {
//        public int findKthNumber(int m, int n, int k) {
//            if (m < 0 || n < 0 || k < 0 || k > m*n) return 0;
//            int max = Math.max(m,n);
//            int min = Math.min(m,n);
//            int i =1, j =1;
//            while (k--<0){
//                if (j<=min)
//            }
//            ArrayList res = new ArrayList();
//            for (int i = 0; i < m; i++) {
//                for (int j = 0; j < n; j++) {
//                    res.add((i+1)*(j+1));
//                }
//            }
//            Collections.sort(res);
//            return (int) res.get(k-1);
//        }
//    }
//}
