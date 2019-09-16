package collatz_guess;

public class CollatzGuess {

  public int solution(int num) {
    long cal = num;
    int answer = 0;

    while (cal != 1) {
      System.out.println(cal + ", " + answer);
      cal = cal % 2 == 0 ? cal / 2 : cal * 3 + 1;
      if (answer > 500) {
        return -1;
      }
      answer++;
    }

    return answer;
  }

  public static void main(String[] args) {
    int n = 626331;
    CollatzGuess collatzGuess = new CollatzGuess();
    System.out.println(collatzGuess.solution(n));
  }

}
