package kth_number;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class KthNumber {

  public int[] solution(int[] array, int[][] commands) {
    return Stream.of(commands)
        .mapToInt(ints -> IntStream.of(array)
            .skip(ints[0] - 1)
            .limit(ints[1] - ints[0] + 1)
            .sorted().toArray()[ints[2] - 1])
        .toArray();
  }

  public static void main(String[] args) {
    int[] array = new int[]{1, 5, 2, 6, 3, 7, 4};
    int[][] commands = {
        {2, 5, 3},
        {4, 4, 1},
        {1, 7, 3}
    };

    KthNumber kthNumber = new KthNumber();

    int[] answer = kthNumber.solution(array, commands);

    for (int i = 0; i < answer.length; i++) {
      System.out.print(answer[i] + ",");
    }
  }

}
