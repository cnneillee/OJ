package cn.neillee.topReview;

import cn.neillee.topReview.support.Point;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Neil
 * @date 2017/9/10.
 * @difficulity difficult
 * https://leetcode.com/problems/max-points-on-a-line/description/
 * TODO 待完成
 */
public class MaxPointsOnALine {
    public static void main(String[] args) {
        MaxPointsOnALine thiz = new MaxPointsOnALine();
        Solution s = thiz.new Solution();
        int res = s.maxPoints(new Point[]{
//                new Point(0, 0),
//                new Point(1, 1),
//                new Point(1, -1)

//                new Point(1, 1),
//                new Point(1, 1),
//                new Point(-1, -1)

//                new Point(0, 0),
//                new Point(-1, -1),
//                new Point(2, 2)

//                new Point(3, 1),
//                new Point(12, 3),
//                new Point(3, 1),
//                new Point(-6, -1)

                new Point(84, 250),
                new Point(0, 0),
                new Point(1, 0),
                new Point(0, -70),
                new Point(0, -70),
                new Point(1, -1),
                new Point(21, 10),
                new Point(42, 90),
                new Point(-42, -230)
        });
        System.out.println(res);
    }

    class Solution {
        public int maxPoints(Point[] points) {
            if (points == null) return 0;
            int N = points.length;
            if (N <= 2) return N;

            Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
            int result = 0;
            for (int i = 0; i < N; i++) {
                map.clear();
                int overlap = 0;
                int max = 0;

                for (int j = i + 1; j < N; j++) {
                    int x = points[j].x - points[i].x;
                    int y = points[j].y - points[i].y;
                    if (x == 0 && y == 0) {
                        overlap++;
                        continue;//overlap
                    }
                    int gcd = genGCD(x, y);
                    int b = Math.abs(genDistinct(x, y));
                    if (map.get(gcd) != null) {
                        if (map.get(gcd).containsKey(b)) {
                            int num = map.get(gcd).get(b);
                            map.get(gcd).put(b, num + 1);
                        } else {
                            map.get(gcd).put(b, 1);
                        }
                    } else {
                        Map<Integer, Integer> m = new HashMap<>();
                        m.put(b, 1);
                        map.put(gcd, m);
                    }
                    max = Math.max(max, map.get(gcd).get(b));
                }
                result = Math.max(result, max + overlap + 1);
            }
            return result;
        }

        // 大概的斜率
        private int genGCD(int x, int y) {
            if (x == 0) return Integer.MAX_VALUE;
            if (y == 0) return 0;
            return y / x;
        }

        // 用于区分斜率类似的情况
        private int genDistinct(int x, int y) {
            if (x == 0 || y == 0) return 0;
            return y % x;
        }
    }
}
