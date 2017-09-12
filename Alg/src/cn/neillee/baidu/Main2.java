package cn.neillee.baidu;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Neil
 * @date 2017/9/11.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            StringBuilder sb = new StringBuilder();
            int num = sc.nextInt();
            int n = sc.nextInt();
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
            int count = 0;
            for (int i = 0; i < n; i++) {
                int m = sc.nextInt();
                count += m;
                priorityQueue.add(m);
            }
            sb.append(count).append(" ");
            for (int i = n; i < num; i++) {
                int m = sc.nextInt();
                int x = priorityQueue.poll();
                if (m < x) {
                    priorityQueue.add(x);
                    sb.append(count).append(" ");
                    continue;
                } else {
                    priorityQueue.add(m);
                    count = count + m - x;
                    sb.append(count).append(" ");
                }
            }
            String result = sb.toString();
            System.out.println(result.substring(0, result.length() - 1));
        }
    }
}
