package cn.neillee.dj;

import java.util.Scanner;

public class Main2 {
    static class Punch {
        int start;
        int millies;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Punch[] caches = new Punch[32];
        int START = millies("03:00:00");
        while (sc.hasNextLine()) {
            int N = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < N; i++) {
                String line = sc.nextLine();
                String[] arr = line.split(" ");
                int day = Integer.parseInt(arr[0].substring(3, 5));
                int s = millies(arr[1]);
                if (s < START) {
                    day--;
                    s += millies("24:00:00");
                }
                processPunch(s, caches, day);
            }
            int zeroCount = 0;
            for (int i = 1; i < N; i++)
                if (caches[i] != null && caches[i].millies > 0) {
                    System.out.println(String.format("08.%02d %d", i, caches[i].millies));
                } else {
                    zeroCount++;
                }
            if (zeroCount == 31) {
                System.out.println(-1);
            }
        }
    }

    private static void processPunch(int s, Punch[] caches, int day) {
        if (day <= 0) return;
        Punch p = caches[day];
        if (p == null) {
            p = caches[day] = new Punch();
            p.start = s;
            p.millies = 0;
        } else {
            int end = p.start + p.millies;
            if (s < p.start) {
                p.millies = p.start - s;
                p.start = s;
            } else if (s > end) {
                p.millies = s - p.start;
            }
        }
    }

    private static int millies(String s) {
        String[] timeArr = s.split(":");
        int hour = Integer.parseInt(timeArr[0]);
        int min = Integer.parseInt(timeArr[1]);
        int sec = Integer.parseInt(timeArr[2]);
        return hour * 60 * 60 + min * 60 + sec;
    }
}
