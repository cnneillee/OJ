package cn.neillee;

import cn.neillee.utils.BooleanBackPack;
import cn.neillee.utils.Utils;

/**
 * Created by Neil on 2017/8/7.
 * 01背包问题
 */
public class Main {
    public static void main(String[] args) {
        int m = 10;
        int n = 3;
        int w[] = {3, 4, 5};
        int p[] = {4, 5, 6};
        System.out.println("用工具类打印");
        Utils.print2DimArray(BooleanBackPack.solve(m, n, w, p));
    }
}
