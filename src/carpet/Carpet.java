package carpet;

public class Carpet {

  public static int[] solution(int brown, int red) {
    int[] answer = new int[2];
    int i , j;

    for (i = 1, j = 1; i * j >= brown + red; i += 1, j += 1);

    while (i * j != brown + red) {
      j--;

      if (j == 0) {
        i++;
        j = i;
      }
    }

    answer[0] = i;
    answer[1] = j;

    return answer;
  }

  public static void main(String[] args) {
    int brown = 240;
    int red = 24;

    int[] answer = solution(brown, red);

    for (int x : answer) {
      System.out.println(x);
    }
  }

}