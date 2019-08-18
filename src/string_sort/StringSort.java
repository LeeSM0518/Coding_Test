package string_sort;

import java.util.Arrays;
import java.util.Comparator;

public class StringSort {

  public String[] solution(String[] strings, int n) {
    return Arrays.stream(strings)
        .sorted()
        .sorted(Comparator.comparing(str -> str.charAt(n)))
        .toArray(String[]::new);
  }

  public static void main(String[] args) {
    String[] strings = {"sun", "bed", "car"};
    int n = 1;

    StringSort stringSort = new StringSort();

    String[] answers = stringSort.solution(strings, n);

    for(String str : answers) {
      System.out.println(str);
    }
  }

}
