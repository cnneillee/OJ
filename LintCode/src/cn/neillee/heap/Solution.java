package cn.neillee.heap;

public class Solution {
    public static void main(String[] args) {
        int[] A = {42, 30, 27, 93, 8, 34, 47, 64, 82, 76, 70, 79, 23, 5, 67, 9, 97, 29, 7, 61, 73, 3, 44, 85, 51, 49, 90, 59, 38, 55, 39, 62, 54, 81, 26, 50, 22, 71, 52, 41, 77, 32, 2, 96, 84, 20, 48, 17, 87, 94, 12, 13, 89, 24, 6, 74, 69, 78, 65, 35, 15, 28, 25, 16, 33, 63};
        new Solution().heapify(A);
    }

    /**
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] A) {
        // write your code here
        int pos = (A.length) / 2 - 1;
        for (int i = pos; i >= 0; i--) {
            if (i * 2 + 2 < A.length) {
                if (A[i * 2 + 1] > A[i * 2 + 2]) {
                    int temp = A[i * 2 + 1];
                    A[i * 2 + 1] = A[i * 2 + 2];
                    A[i * 2 + 2] = temp;
                }
                if (A[i * 2 + 1] < A[i] && A[i] < A[i * 2 + 2]) {
                    int temp = A[i];
                    A[i] = A[i * 2 + 1];
                    A[i * 2 + 1] = temp;
                } else if (A[i] > A[i * 2 + 2]) {
                    int temp = A[i];
                    A[i] = A[i * 2 + 1];
                    A[i * 2 + 1] = A[i * 2 + 2];
                    A[i * 2 + 2] = temp;
                }
            } else {
                if (A[i * 2 + 1] < A[i]) {
                    int temp = A[i];
                    A[i] = A[i * 2 + 1];
                    A[i * 2 + 1] = temp;
                }
            }
        }
    }

    private void reverseHeapfy(int[] A, int pos) {
        if (pos * 2 + 2 < A.length) {// 三个数
            if (A[pos*2+1]>A[pos*2+2]){
                int temp = A[pos];
                A[pos] = A[2 * pos + 1];
                A[2 * pos + 1] = temp;
            }
        } else {// 两个数
            if (A[pos] > A[pos * 2 + 1]) {
                int temp = A[pos];
                A[pos] = A[2 * pos + 1];
                A[2 * pos + 1] = temp;
            }
        }
    }
    private void exchange(int[] A,int pos1,int pos2)
}