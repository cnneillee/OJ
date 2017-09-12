package cn.neillee.dj;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int target = sc.nextInt();

        int[] nums = new int[N];
        for (int i = 0; i < N; i++)
            nums[i] = sc.nextInt();

        int[] result = search(nums, target);
    }

    private static int[] search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1, mid = (lo + hi) / 2;
        begin = 0;
        end = hi;
        binarySearch(nums, lo, hi, mid, target);
        return new int[0];
    }

    private static int begin = -1;
    private static int end = -1;

    private static void binarySearch(int[] nums, int lo, int hi, int mid, int target) {
        if (nums[mid] < target) {
            begin = lo = mid + 1;
            mid = (lo + hi) / 2;
            binarySearch(nums, lo, hi, mid, target);
        } else if (nums[mid] > target) {
            end = hi = mid - 1;
            mid = (lo + hi) / 2;
            binarySearch(nums, lo, hi, mid, target);
        } else {
            if ((mid < nums.length - 1 && nums[mid + 1] > target) ||
                    (mid == nums.length - 1)) {
                end = mid;
            }
            if ((mid > 0 && nums[mid - 1] < nums[mid]) ||
                    mid == 0) {
                begin = mid;
            }
        }
    }
}
