package cn.neillee.didi.first;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Neil
 * @date 2017/9/10.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int N = in.nextInt();
            int a[] = new int[N];
            for (int i = 0; i < N; i++) {
                a[i] = in.nextInt();
            }
            Arrays.sort(a);
        }
    }
}
