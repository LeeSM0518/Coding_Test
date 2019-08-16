package mock_test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MockTest {
  // 1번 : 12345
  // 2번 : 21232425
  // 3번 : 3311224455

  class Pattern {

    int[] patterns;
    int answerCount;
    int currentIndex;

    public Pattern(int[] patterns) {
      this.patterns = patterns;
      answerCount = 0;
      currentIndex = 0;
    }

    public void answerCheck(int answer) {
      if (patterns[currentIndex] == answer) answerCount++;
      currentIndex = (currentIndex + 1) % patterns.length;
    }

  }

  public int[] solution(int[] answers) {
    Pattern firstPattern = new Pattern(new int[]{1, 2, 3, 4, 5});
    Pattern secondPattern = new Pattern(new int[]{2, 1, 2, 3, 2, 4, 2, 5});
    Pattern thirdPattern = new Pattern(new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5});

    for (int problemAnswer : answers) {
      firstPattern.answerCheck(problemAnswer);
      secondPattern.answerCheck(problemAnswer);
      thirdPattern.answerCheck(problemAnswer);
    }

    System.out.println(firstPattern.answerCount);
    System.out.println(secondPattern.answerCount);
    System.out.println(thirdPattern.answerCount);

    return null;
  }

  public static void main(String[] args) {
    int[] answer = {1, 2, 3, 4, 5};
    MockTest mockTest = new MockTest();
    System.out.println(mockTest.solution(answer));
  }

}
