package cn.neillee.utils;

/**
 * Created by Neil on 2017/8/7.
 * Utils工具类
 */
public class Utils {
    public static void print2DimArray(int[][] array) {
        if (array == null) return;
        int rowNum = array.length;
        int colNum = array[0].length;
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++)
                System.out.print(array[i][j] + "\t");
            System.out.println("");
        }
    }
}
