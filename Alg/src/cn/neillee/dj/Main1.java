package cn.neillee.dj;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String num = line.substring(1, line.length() - 1);
        String[] numStringArrs = num.split(",");
        int N = numStringArrs.length;
        int[] nums = new int[N];
        for (int i = 0; i < N; i++)
            nums[i] = Integer.parseInt(numStringArrs[i]);
        Arrays.sort(nums);

        int max = 1;
        int pos = 1;

        for (int i = 1; i < N; i++) {
            if (nums[i - 1] + 1 == nums[i]) {
                pos++;
            } else {
                max = Math.max(pos, max);
                pos = 1;
            }
        }
        max = Math.max(pos, max);
        System.out.println(max);
    }
}