package n_count_number;

import java.util.stream.IntStream;

public class CountNumber {

  public long[] solution(int x, int n) {
    long[] answer = new long[n];
    long sum = 0;

    for (int i = 1; i <= n; i++) {
      sum += x;
      answer[i-1] = sum;
    }
    return answer;
  }

  public static void main(String[] args) {
    int x = -4, n = 2;
    CountNumber countNumber = new CountNumber();
    long[] answer = countNumber.solution(x, n);

    for (long i : answer) {
      System.out.println(i);
    }
  }

}
