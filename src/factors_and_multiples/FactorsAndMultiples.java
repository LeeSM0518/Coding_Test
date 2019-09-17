package factors_and_multiples;

import java.util.TreeSet;

public class FactorsAndMultiples {

  public int[] solution(int n, int m) {
    TreeSet<Integer> factors = new TreeSet<>();
    for (int i = 1; i <= m; i++) {
      if (n % i == 0 && m % i == 0) {
        factors.add(i);
      }
    }
    return new int[]{factors.last(), n * m / factors.last()};
  }

  public static void main(String[] args) {
    int n = 2;
    int m = 5;
    FactorsAndMultiples factorsAndMultiples = new FactorsAndMultiples();
    int[] answer = factorsAndMultiples.solution(n, m);
  }

}