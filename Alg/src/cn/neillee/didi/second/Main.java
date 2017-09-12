package cn.neillee.didi.second;

import java.util.Scanner;

/**
 * @author Neil
 * @date 2017/9/10.
 */
public class Main {
    private static boolean uglyNumber;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int N = in.nextInt();
            System.out.println(getNUglyNumber(N));
        }
    }

    private static int getNUglyNumber(int index) {
        int[] a = new int[index];
        int count = 1;
        a[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        while (count < index) {
            int min = min(a[index2] * 2, a[index3] * 3, a[index5] * 5);
            a[count] = min;
            while (a[index2] * 2 <= a[count]) index2++;
            while (a[index3] * 3 <= a[count]) index3++;
            while (a[index5] * 5 <= a[count]) index5++;
            count++;
        }
        return a[index - 1];
    }

    private static int min(int a, int b, int c) {
        int temp = a > b ? b : a;
        return temp > c ? c : temp;
    }
}
