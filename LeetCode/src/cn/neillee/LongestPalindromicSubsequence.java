package cn.neillee;

/**
 * Created by Neil on 2017/8/3.
 * https://leetcode.com/problems/longest-palindromic-subsequence/description/
 */
public class LongestPalindromicSubsequence {
    private int maxLength = 0;

    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() <= 0) return 0;
        for (int i = 0; i < s.length(); i++) {
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i + 1);
        }
        return maxLength;
    }

    private void extendPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            int length = right - left + 1;
            if (length > maxLength) maxLength = length;
            left--;
            right++;
        }
    }
}
