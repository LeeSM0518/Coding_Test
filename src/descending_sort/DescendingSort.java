package descending_sort;

import java.util.Arrays;
import java.util.Comparator;

public class DescendingSort {

  public String solution(String s) {
    return Arrays.stream(s.split(""))
        .sorted(Comparator.reverseOrder())
        .reduce(String::concat).get();
  }

  public static void main(String[] args) {
    String s = "Zbcdefg";
    DescendingSort descendingSort = new DescendingSort();
    System.out.println(descendingSort.solution(s));
  }

}
