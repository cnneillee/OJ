package cn.neillee.utils;

import java.util.Scanner;
import java.lang.String;

public class Main1 {
    static class Pos {
        int x;
        int y;
        int cost;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String taxiCountStr = in.nextLine();
        String taxiXStr = in.nextLine();
        String taxiYStr = in.nextLine();
        String compPosStr = in.nextLine();
        String timesStr = in.nextLine();

        int taxiCount = Integer.valueOf(taxiCountStr);
        String[] taxiXStrArr = taxiXStr.split(" ");
        String[] taxiYStrArr = taxiYStr.split(" ");
        String[] compPosStrArr = compPosStr.split(" ");
        String[] timesStrArr = timesStr.split(" ");


        Pos taxis[] = new Pos[taxiCount];
        for (int i = 0; i < taxiCount; i++) {
            taxis[i] = new Pos(Integer.valueOf(taxiXStrArr[i]),
                    Integer.valueOf(taxiYStrArr[i]));
        }
        Pos comp= new Pos(Integer.valueOf(compPosStrArr[0]),
                Integer.valueOf(compPosStrArr[1]));

        int walkSpeed = Integer.valueOf(timesStrArr[0]);
        int taxiSpeed = Integer.valueOf(timesStrArr[1]);

        int min = Math.abs(comp.x + comp.y) * walkSpeed;
        for (int i = 0; i < taxiCount; i++) {
            taxiTimeCal(comp, taxis[i], walkSpeed, taxiSpeed);
            if (taxis[i].cost < min) min = taxis[i].cost;
        }

        System.out.println(min);
    }

    private static void taxiTimeCal(Pos comp, Pos taxi, int walkSpeed, int taxiSpeed) {
        taxi.cost = Math.abs((taxi.x + taxi.y)) * walkSpeed +
                (Math.abs(comp.x - taxi.x) + Math.abs(comp.y - taxi.y))
                        * taxiSpeed;
    }
}