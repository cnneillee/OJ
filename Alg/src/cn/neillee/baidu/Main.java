package cn.neillee.baidu;

import java.util.Scanner;

/**
 * @author Neil
 * @date 2017/9/11.
 * 1尾击：用字符‘R’表示；
 * 2撕咬：用字符‘B’表示；
 * 3光束：用字符‘L’表示
 * <p>
 * 1切挡：用字符‘S’表示，可以用来防御尾击；
 * 2踢蹬：用字符‘K’表示，可以用来防御撕咬；
 * 3护盾：用字符‘H’表示，可以用来防御光束。
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            int N = line.length();
            char[] response = new char[N];
            for (int i = 0; i < N; i++) {
                switch (line.charAt(i)) {
                    case 'R':// 0
                        response[i] = 'S';
                        break;
                    case 'B':
                        response[i] = 'K';
                        break;
                    case 'L':
                        response[i] = 'H';
                        break;
                }
            }
            String responseString = new String(response);
            String result = responseString.replaceAll("(SKH)|(SHK)|(KHS)|(KSH)|(HSK)|(HKS)", "C");
            System.out.println(result);
        }
    }
}
