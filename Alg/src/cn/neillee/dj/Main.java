package cn.neillee.dj;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int numCount = Integer.valueOf(sc.nextLine());
            int maxBitCount = OneBits(4294967295L);
            int[] bitArr = new int[maxBitCount + 1];
            for (int i = 0; i < numCount; i++) {
                String line = sc.nextLine();
                long a = Long.parseLong(line);
                bitArr[OneBits(a)]++;
            }
            int sum = 0;
            for (int i = 0; i < maxBitCount; i++) {
                sum += bitArr[i];
            }
            int count = 0;
            for (int i = 0; i < maxBitCount; i++) {
                count += bitArr[i] * (sum - bitArr[i]);
            }
            System.out.println(count);
        }
    }

    /*新的解法*/
    public static int OneBits(long num) {
        int count = 0;
        while (num != 0) {
            num = (num - 1) & num;
            count++;
        }
        return count;
    }
}
