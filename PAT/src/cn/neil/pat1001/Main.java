package cn.neil.pat1001;

import java.util.Scanner;

/**
 * Created by Neil on 2017/4/22.
 * pat 1001
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 1; i <= T; i++) {
            long a = in.nextLong();
            long b = in.nextLong();
            long c = in.nextLong();
            if (a + b > c) {
                System.out.println("Case #" + i + ": true");
                continue;
            }
            System.out.println("Case #" + i + ": false");
        }
    }
}
