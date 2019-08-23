package integer_descending_sort;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntegerDescendingSort {

  public long solution(long n) {
    return Long.parseLong(Stream.of(String.valueOf(n).split(""))
        .sorted(Comparator.reverseOrder())
        .collect(Collectors.joining()));
  }

  public static void main(String[] args) {
    long n = 118372;
    IntegerDescendingSort sort = new IntegerDescendingSort();
    System.out.println(sort.solution(n));
  }

}
