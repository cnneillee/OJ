package cn.neillee.netease.second;//package nowcoder.netease.second;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Scanner;
//
///**
// * @author Neil
// * @date 2017/9/9.
// */
//public class Main {
//    class TreeNode {
//
//    }
//
//    static class Node implements Comparable<Node> {
//        int a;
//        int b;
//        Node parent = null;
//
//        public void setParent(Node parent) {
//            this.parent = parent;
//        }
//
//        public Node(int a, int b) {
//            this.a = a;
//            this.b = b;
//        }
//
//        @Override
//        public int compareTo(Node o) {
//            if (this.a == o.a && this.b == o.b) return 0;
//            if (this.a > o.a || (this.a == o.a && this.b > o.b)) return 1;
//            else return -1;
//        }
//
//        @Override
//        public String toString() {
//            return a + "-" + b;
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNextInt()) {
//            int N = sc.nextInt();
//            int L = sc.nextInt();
////            int[][] relations = new int[N - 1][2];
//            List<Node> list = new ArrayList<Node>();
//            for (int i = 0; i < N - 1; i++) {
//                Node node = new Node(sc.nextInt(), i + 1);
////                relations[i][0] = sc.nextInt();
////                relations[i][1] = i + 1;
//                list.add(node);
//            }
////            System.out.println(Arrays.deepToString(relations));
//            Collections.sort(list);
//            System.out.println(list);
//
//            for (int i = 0; i < list.size(); i++) {
//                int a = list.get(i).b
//            }
//        }
//    }
//}
