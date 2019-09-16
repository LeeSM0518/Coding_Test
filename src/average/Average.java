package average;

import java.util.stream.IntStream;

public class Average {

  public double solution(int[] arr) {
    return IntStream.of(arr).average().getAsDouble();
  }

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4};
    Average average = new Average();
    System.out.println(average.solution(arr));
  }

}
