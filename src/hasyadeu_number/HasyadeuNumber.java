package hasyadeu_number;

import java.util.stream.Stream;

public class HasyadeuNumber {

  public boolean solution(int x) {
    return x % Stream.of(String.valueOf(x).split(""))
        .mapToInt(Integer::valueOf)
        .sum() == 0;
  }

  public static void main(String[] args) {
    int arr = 10;
    HasyadeuNumber hasyadeuNumber = new HasyadeuNumber();
    System.out.println(hasyadeuNumber.solution(arr));
  }

}
