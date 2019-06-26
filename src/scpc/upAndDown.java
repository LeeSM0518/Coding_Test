package scpc;

import java.util.Scanner;
import java.util.TreeMap;

public class upAndDown {
  static int Answer;
  static int before;

  public static void main(String args[]) throws Exception {
    TreeMap<Integer, Integer> answerList = new TreeMap<>();

    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();
    int cul, count;

    for (int test_case = 0; test_case < T; test_case++) {
      Answer = 0;
      int n1 = sc.nextInt();
      int n2 = sc.nextInt();
      for (int i = n1; i <= n2; i++) {
        cul = i;
        count = 0;
        if (i != n1 && i / 2 == 0) {
          count = before - 1;
          Answer += before - 1;
        } else {
          while (cul != 1) {
            if (answerList.floorEntry(cul) != null &&
                answerList.floorEntry(cul).getKey() == i) {
              count += answerList.floorEntry(cul).getValue();
              break;
            } else if (cul % 2 == 1) {
              cul++;
              count++;
            } else if (cul % 2 == 0) {
              cul /= 2;
              count++;
            }
          }
          before = count;
          Answer += count;
        }
        answerList.put(i, count);
      }

      System.out.println("Case #" + (test_case + 1));
      System.out.println(Answer);
    }
  }
}