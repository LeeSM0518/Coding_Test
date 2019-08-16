package carpet;

import java.util.*;

public class Carpet {

  public static int[] solution(int brown, int red) {
    int[] answer = new int[2];
    int row, col;
    Map<Integer, Integer> redMatrixMap = new HashMap<>();

    for (row = 1; row <= red; row++) {
      for (col = 1; col <= red; col++) {
        if (row * col == red) {
          redMatrixMap.put(row, col);
        }
        else if (row * col > red) break;
      }
    }

    Map.Entry redMatrix = redMatrixMap.entrySet().stream()
        .filter((entry -> brown == (entry.getKey() + entry.getValue()) * 2 + 4))
        .findFirst()
        .get();

    answer[0] = (Integer)redMatrix.getValue() + 2;
    answer[1] = (Integer)redMatrix.getKey() + 2;

    return answer;
  }

  public static void main(String[] args) {
    int brown = 24;
    int red = 24;

    int[] answer = solution(brown, red);

    for (int x : answer) {
      System.out.println(x);
    }
  }

}
