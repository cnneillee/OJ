package cn.neillee.jd.first;

import java.util.Scanner;

/**
 * @author Neil
 * @date 2017/9/8.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int l = sc.nextInt();
            int r = sc.nextInt();

            int count = 0;
            for (int i = l; i < r + 1; i++)
                count += isSpecialNumber(i + "") ? 1 : 0;

            System.out.println(count);
        }
    }

    private static boolean isSpecialNumber(String str) {
        int N = str.length();
        // 个数小于2
        if (N <= 1) return false;

        short[] nums = new short[N];
        int sum = 0;
        for (int i = 0; i < N; i++) { // 求和
            char ch = str.charAt(i);
            nums[i] = (short) Character.getNumericValue(ch);
            sum += nums[i];
        }

        // 和为奇数
        if (sum % 2 != 0) return false;

        int arg = sum / 2;
        boolean[] dp = new boolean[arg + 1];
        dp[0] = true;
        for (int i = 1; i <= N; i++)
            for (int j = arg; j >= nums[i - 1]; j--)
                dp[j] = dp[j] || dp[j - nums[i - 1]];

        return dp[arg];
    }
}
