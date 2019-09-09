package integer_square_root;

import java.util.stream.Stream;

public class IntegerSquareRoot {

  public long solution(long n) {
    long[] answer = Stream.of(n)
        .mapToDouble(Math::sqrt)
        .filter(x -> Math.floor(x) == Math.ceil(x))
        .mapToLong(x -> (long) ((x+1) * (x+1)))
        .toArray();
    return answer.length == 0 ? -1 : answer[0];
  }

  public static void main(String[] args) {
    long n = 3;
    IntegerSquareRoot squareRoot = new IntegerSquareRoot();
    System.out.println(squareRoot.solution(n));
  }

}
