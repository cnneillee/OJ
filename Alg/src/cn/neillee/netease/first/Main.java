package cn.neillee.netease.first;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Neil
 * @date 2017/9/9.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            ArrayList<String> list = new ArrayList<>();
            int N = line.length();

            char last = line.charAt(0);
            StringBuilder sb = new StringBuilder();
            sb.append(last);
            for (int i = 1; i < N; i++) {
                if (last != line.charAt(i)) {
                    list.add(sb.toString());
                    sb.delete(0, sb.length());
                    last = line.charAt(i);
                    sb.append(last);
                } else {
                    sb.append(last);
                }
            }
            list.add(sb.toString());

//            System.out.println(list);
            int sum = 0;
            int count = 0;
            for (String s : list) {
                sum += s.length();
                count++;
            }

            double avg = (sum * 1.0 / count);
            System.out.println(String.format("%.02f", avg));
        }
    }
}
