package digits_plus;

import java.util.stream.Stream;

public class DigitsPlus2 {

  public int solution(int n) {
    return Stream.of(String.valueOf(n).split(""))
        .parallel()
        .mapToInt(Integer::valueOf)
        .sum();
  }

  public static void main(String[] args) {
    int n = 123;
    DigitsPlus digitsPlus = new DigitsPlus();
    System.out.println(digitsPlus.solution(n));
  }

}

