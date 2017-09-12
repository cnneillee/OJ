package cn.neillee.utils;

import java.util.Scanner;
import java.lang.String;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        int bCount = 0;
        int gCount = 0;
        int j = 0;
        // 男生全移到左边
        while (j < line.length() && line.charAt(j) != 'G') j++;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == 'B' && i > j) {
                bCount += (i - j);
                j++;
                while (j < line.length() && line.charAt(j) != 'G') j++;
            }
        }

        // 女生全移到左边
        int k = 0;
        while (k < line.length() && line.charAt(k) != 'B') k++;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == 'G' && i > k) {
                gCount += (i - k);
                k++;
                while (k < line.length() && line.charAt(k) != 'B') k++;
            }
        }
        System.out.println(Math.min(bCount, gCount));
    }
}
