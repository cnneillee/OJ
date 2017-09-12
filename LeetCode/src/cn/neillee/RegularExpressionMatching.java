package cn.neillee;

/**
 * @author Neil
 * @date 2017/8/30.
 * https://leetcode.com/problems/regular-expression-matching/description/
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        int i, j = 0;
        int N = p.length();
        int lastStarMatch = -1;
        for (i = 0; i < s.length() && j < N; ) {
            char c = s.charAt(i);
            if (c == p.charAt(j) || p.charAt(j) == '.') {
                j++;
                i++;
            } else if (p.charAt(j) == '*' && j + 1 < N) {
                lastStarMatch = j - 1;
                j++;
            } else if (p.charAt(j) == '*' && j + 1 >= N) {
                lastStarMatch = --j;
            } else if (lastStarMatch < 0) {
                return false;
            } else j = lastStarMatch;
        }
        return i == s.length();
    }

    public static void main(String[] args) {
        boolean re = new RegularExpressionMatching().isMatch("aa", "a");
        System.out.println(re);
        re = new RegularExpressionMatching().isMatch("aa", "aa");
        System.out.println(re);
        re = new RegularExpressionMatching().isMatch("aaa", "aa");
        System.out.println(re);
        re = new RegularExpressionMatching().isMatch("aa", "a*");
        System.out.println(re);
        re = new RegularExpressionMatching().isMatch("aa", ".*");
        System.out.println(re);
        re = new RegularExpressionMatching().isMatch("ab", ".*");
        System.out.println(re);
        re = new RegularExpressionMatching().isMatch("aab", "c*a*b");
        System.out.println(re);
    }

    public boolean isMatch1(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
