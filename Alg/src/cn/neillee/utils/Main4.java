package cn.neillee.utils;

import java.util.ArrayList;
import java.util.Scanner;


public class Main4 {
    private static class MyQueue {
        ArrayList<Integer> numList = new ArrayList<>();

        void put(int num) {
            Integer integer = null;
            for (Integer num1 : numList) {
                if (num1.equals(num)) integer = num1;
            }
            if (integer != null) numList.remove(integer);
            numList.add(num);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < numList.size(); i++) {
                if (i != numList.size() - 1) sb.append(numList.get(i)).append(" ");
                else sb.append(numList.get(i)).append("");
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String countStr = in.nextLine();
        String numStr = in.nextLine();
        String[] numStrArr = numStr.split(" ");
        int count = Integer.valueOf(countStr);
        MyQueue que = new MyQueue();
        for (int i = 0; i < count; i++) {
            que.put(Integer.valueOf(numStrArr[i]));
        }
        System.out.println(que.toString());
    }
}