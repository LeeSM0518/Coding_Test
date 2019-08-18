package integer_sum;

public class IntegerSum {

  public long solution(int a, int b) {
    long answer = 0;
    for (int start = (a < b) ? a : b, end = (start == a) ? b : a;
         start <= end;
         start++)
      answer += start;
    return answer;
  }

}
