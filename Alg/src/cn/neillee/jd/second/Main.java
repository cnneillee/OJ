package cn.neillee.jd.second;

import java.util.Scanner;

/**
 * @author Neil
 * @date 2017/9/8.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            long mod = 10000000007L;
            long count = 1;
            int tot = 0;

            String line = sc.nextLine();
            int N = line.length();
            for (int i = N - 1; i >= 0; i--) {
                char ch = line.charAt(i);
                if (ch == ')') tot++;
                else if (ch == '(') {
                    count = (count * tot) % mod;
                    tot--;
                }
            }
            System.out.println(count + "");
        }
    }
}
