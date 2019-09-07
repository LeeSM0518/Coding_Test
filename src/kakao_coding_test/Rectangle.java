package kakao_coding_test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class Rectangle {

  public int[] solution(int[][] v) {
    Set<Integer> left = new HashSet<>();
    Set<Integer> right = new HashSet<>();

    for (int[] v2 : v) {
      left.add(v2[0]);
      right.add(v2[1]);
    }

    return left.stream()
        .flatMap(x -> right.stream().map(y -> new int[]{x, y}))
        .filter(arr -> Stream.of(v).anyMatch(x -> (x[0] == arr[0]) && (x[1] == arr[1])))
        .flatMapToInt(Arrays::stream)
        .toArray();
  }

  public static void main(String[] args) {
    int[][] v = {{1, 4}, {3, 4}, {3, 10}};
    Rectangle rectangle = new Rectangle();
    int[] test = rectangle.solution(v);

    for (int x : test) {
      System.out.println(x);
    }
  }

}
