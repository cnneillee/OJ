package cn.neillee;

import java.util.Scanner;

public class Main {
    static int max0Start = 0, max0Length = 0;
    static int max1Start = 0, max1Length = 0;

    static int myAns(int[] timeList) {
        // 1.首先找到最长的0和最长的1
        for (int i = 0; i < timeList.length; i++) {
            if (timeList[i] == 0) {
                max0(timeList, i);
            } else {
                max1(timeList, i);
            }
        }
        int count = 0;
        // 情况1：【最长0】【最长1】
        if (max0Start < max1Start) {
            for (int i = 0; i < max1Start; i++) {
                if (timeList[i] == 0) {
                    count++;
                }
            }
            return count + max1Length;
        }
        // 情况2：【最长1】【最长0】
        int count0 = 0;
        // 选【最长0】
        for (int i = 0; i < max0Start + max0Length; i++) {
            if (timeList[i] == 0) {
                count0++;
            }
        }
        int subArr[] = new int[timeList.length - max0Start - max0Length - 1];
        System.arraycopy(timeList, max0Start + max0Length + 1, subArr, 0,
                timeList.length - max0Start - max0Length - 1);
        int temp0 = count0 + myAns(subArr);// 递归
        // 选【最长1】
        int subArr1[] = new int[max1Start - 1];
        int temp1 = count0 + myAns(subArr1);// 递归

        return temp1 > temp0 ? temp1 : temp0;
    }

    private static void max1(int[] timeList, int i) {
        int start = i;
        while (i < timeList.length && timeList[i] == 1) {
            i++;
        }
        if (max1Length < i - start + 1) {
            max1Start = i;
            max1Length = i - start + 1;
        }
    }

    private static void max0(int[] timeList, int i) {
        int start = i;
        while (i < timeList.length && timeList[i] == 0) {
            i++;
        }
        if (max0Length < i - start + 1) {
            max0Start = i;
            max0Length = i - start + 1;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int _timeList_size = 0;
        _timeList_size = Integer.parseInt(in.nextLine().trim());
        int[] _timeList = new int[_timeList_size];
        int _timeList_item;
        for (int _timeList_i = 0; _timeList_i < _timeList_size; _timeList_i++) {
            _timeList_item = Integer.parseInt(in.nextLine().trim());
            _timeList[_timeList_i] = _timeList_item;
        }

        res = myAns(_timeList);
        System.out.println(String.valueOf(res));

    }
}