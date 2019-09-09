package remove_smallest_number;

import java.util.stream.IntStream;

public class RemoveSmallestNumber {

  public int[] solution(int[] arr) {
    int[] answer = IntStream.of(arr).parallel().filter(x ->
        x != IntStream.of(arr).min().getAsInt()).toArray();
    return answer.length == 0 ? new int[]{-1} : answer;
  }

  public static void main(String[] args) {
    int[] arr = {10};
    RemoveSmallestNumber number = new RemoveSmallestNumber();
    for (int i : number.solution(arr)) {
      System.out.println(i);
    }
  }

}
