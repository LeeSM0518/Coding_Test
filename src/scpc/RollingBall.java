package scpc;

import java.util.Scanner;

public class RollingBall {

  static double Answer;

  public static void main(String args[]) throws Exception {
    Scanner sc = new Scanner(System.in);
    //Scanner sc = new Scanner(new FileInputStream("input.txt"));

    int T = sc.nextInt();

    double[] radius = new double[T];
    double[] start = new double[T];
    double[] end = new double[T];
    int[] obstacleNum = new int[T];
    double[][] left = new double[T][0];
    double[][] right = new double[T][0];
    double[][] height = new double[T][0];
    double[] edge = new double[T];

    for (int i = 0; i < T; i++) {
      radius[i] = sc.nextInt();
      start[i] = sc.nextInt();
      end[i] = sc.nextInt();
      obstacleNum[i] = sc.nextInt();
      left[i] = new double[obstacleNum[i]];
      right[i] = new double[obstacleNum[i]];
      height[i] = new double[obstacleNum[i]];
      for (int j = 0; j < obstacleNum[i]; j++) {
        left[i][j] = sc.nextInt();
        right[i][j] = sc.nextInt();
        height[i][j] = sc.nextInt();
      }
      edge[i] = (Math.PI * radius[i]) / 2.0;
    }

    for (int test_case = 0; test_case < T; test_case++) {
      Answer = 0;
      for (int i = 0; i < obstacleNum[test_case]; i++) {
        Answer += (i == 0) ? left[test_case][i] - (start[test_case] + radius[test_case]) : left[test_case][i] - start[test_case];
        Answer += (height[test_case][i] > radius[test_case]) ? (height[test_case][i] - radius[test_case]) * 2 + (edge[test_case] * 2) + (right[test_case][i] - left[test_case][i])
            : ((2 * Math.PI * radius[test_case]) / (radius[test_case] * 4 / height[test_case][i])) * 2 + (right[test_case][i] - left[test_case][i]);
        start[test_case] = right[test_case][i] + radius[test_case] * 2;
      }
      Answer += (end[test_case] + radius[test_case]) - start[test_case];

      System.out.println("Case #" + (test_case + 1));
      System.out.println(Answer);
    }
  }
}

/*
2
10 15 1000
5
100 200 35
250 300 40
333 444 50
500 600 55
630 780 25
5 105 1000
6
200 300 15
353 390 41
423 467 50
500 600 3
630 780 25
812 939 22

Case #1
1352.079632679489
Case #2
1181.967459757107
 */
