package number_array;

import java.util.Arrays;

public class NumberArray {

  public int[] solution(int[] arr, int divisor) {
    int[] answer =
        Arrays.stream(arr).boxed()
        .filter(value -> value % divisor == 0)
        .sorted()
        .mapToInt(Integer::intValue)
        .toArray();

    return answer.length == 0 ? new int[]{-1} : answer;
  }

  public static void main(String[] args) {
    int[] arr = {2, 36, 1, 3};
    int divisor = 40;

    NumberArray numberArray = new NumberArray();
    int[] answer = numberArray.solution(arr, divisor);

    for (int value : answer) {
      System.out.println(value);
    }
  }

}
