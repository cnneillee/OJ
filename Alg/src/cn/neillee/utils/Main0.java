package cn.neillee.utils;

import java.util.Scanner;
import java.lang.String;

public class Main0 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String countStr = in.nextLine();
        String timesStr = in.nextLine();
        String[] timesStrArr = timesStr.split(" ");
        int count = Integer.valueOf(countStr);
        int[] times = new int[count];
        int sum = 0;
        for (int i = 0; i < count; i++) {
            times[i] = Integer.valueOf(timesStrArr[i]) / 1024;
            sum += times[i];
        }

        // 背包问题
        int max = 0;
        int maxW = sum / 2;
        int[][] result = new int[count + 1][maxW + 1];
        for (int i = 1; i < count + 1; i++) result[i][0] = 0;
        for (int j = 1; j < maxW + 1; j++) result[0][j] = 0;
        for (int i = 1; i < count + 1; i++) {
            for (int j = 1; j < maxW + 1; j++) {
                if (times[i - 1] <= j) {
                    int pre = result[i - 1][j];
                    int post = result[i - 1][j - times[i - 1]] + times[i - 1];
                    result[i][j] = pre > post ? pre : post;
                } else result[i][j] = result[i - 1][j];
                if (max < result[i][j]) max = result[i][j];
            }
        }

        int m1 = sum - max;
        int m2 = max;
        System.out.println((m1 > m2 ? m1 : m2) * 1024);
    }
}