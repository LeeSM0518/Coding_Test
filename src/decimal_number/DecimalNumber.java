package decimal_number;

public class DecimalNumber {

  public int solution(int n) {
    int answer = n - 1;
    int i, j, x;
    int[] k = new int[n];

    for (i = 2; i <= n; i++) {
      if (k[i - 1] == 1) {
        answer--;
        continue;
      }
      for (j = 2, x = i * j; j <= n && x <= n; j++, x = i * j) {
        if (k[x - 1] == 1) {
          answer--;
          k[x - 1]++;
        } else if (k[x - 1] == 0) {
          k[x - 1] = 1;
        }
      }
    }
    return answer;
  }

}