package mock_test;

import java.util.*;
import java.util.stream.Collectors;

public class MockTest {

  class Pattern {

    int[] patterns;
    int answerCount;
    int currentIndex;
    int number;

    public Pattern(int[] patterns, int number) {
      this.patterns = patterns;
      this.number = number;
      answerCount = 0;
      currentIndex = 0;
    }

    public void answerCheck(int answer) {
      if (patterns[currentIndex] == answer) answerCount++;
      currentIndex = (currentIndex + 1) % patterns.length;
    }
  }

  public int[] solution(int[] answers) {
    Pattern firstPattern = new Pattern(new int[]{1, 2, 3, 4, 5}, 1);
    Pattern secondPattern = new Pattern(new int[]{2, 1, 2, 3, 2, 4, 2, 5}, 2);
    Pattern thirdPattern = new Pattern(new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}, 3);

    List<Pattern> patternList = new ArrayList<>(Arrays.asList(firstPattern, secondPattern, thirdPattern));

    for (int problemAnswer : answers) {
      patternList.forEach(pattern -> pattern.answerCheck(problemAnswer));
    }

    List<Pattern> sortedList = patternList.stream()
        .sorted((a, b) -> Integer.compare(b.answerCount, a.answerCount))
        .collect(Collectors.toList());

    List<Pattern> sortedList2 = sortedList.stream()
        .filter(pattern -> pattern.answerCount == sortedList.get(0).answerCount)
        .sorted(Comparator.comparingInt(a -> a.number))
        .collect(Collectors.toList());

    int[] answer = new int[sortedList2.size()];

    for (int i = 0; i < answer.length; i++) {
      answer[i] = sortedList2.get(i).number;
    }

    return answer;
  }

  public static void main(String[] args) {
    int[] answers = {1, 2, 3, 4, 5};
    MockTest mockTest = new MockTest();
    int[] answer = mockTest.solution(answers);

    for (int a : answer) {
      System.out.println(a);
    }
  }

}
