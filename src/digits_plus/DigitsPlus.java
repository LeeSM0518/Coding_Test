package digits_plus;

import java.util.stream.Stream;

public class DigitsPlus {

  int sum = 0;

  public int recursionFunc(int n) {
    if (n == 0) return 0;
    sum += n % 10;
    recursionFunc(n / 10);
    return 0;
  }

  public int solution(int n) {
    recursionFunc(n);
    return sum;
  }

  public static void main(String[] args) {
    int n = 123;
    DigitsPlus digitsPlus = new DigitsPlus();
    System.out.println(digitsPlus.solution(n));
  }

}
