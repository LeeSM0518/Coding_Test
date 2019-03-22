package kth_number;

import java.util.Arrays;

public class KthNumber {
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int[] sort;

        return answer;
    }

    public static int[] sortArray(int[] array) {
        int[] sorted = array.clone();
        int tmp;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (sorted[j-1] > sorted[j]) {
                    tmp = sorted[j-1];
                    sorted[j-1] = sorted[j];
                    sorted[j] = tmp;
                }
            }
        }
        return sorted;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {
                {2, 5, 3},
                {4, 4, 1},
                {1, 7, 3}
        };
    }
}
