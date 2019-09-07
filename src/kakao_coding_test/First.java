package kakao_coding_test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class First {

  public int solution(String s) {
    int answer = 0;
    int patternCount = 1;
    Map<Integer, Set<String>> patternMap = new HashMap<>();
    Map<String, Integer> patternCountMap = new HashMap<>();

    for (patternCount = 1; patternCount < s.length(); patternCount++) {
      Set<String> patterns = new HashSet<>();
      for (int i = 0; i < s.length() - patternCount; i++) {
        patterns.add(s.substring(i, i + patternCount));
      }
      patternMap.put(patternCount, patterns);
    }

    for (patternCount = 1; patternCount < s.length(); patternCount++) {
      Set<String> patternSet = patternMap.get(patternCount);

      for (String str : patternSet) {
        patternCountMap.put(str, 0);
      }

      Stack<String> strings = new Stack<>();
      String before = null;
      int count = 0;
      for (int j = 0; j < s.length() - patternCount; j++) {
        String str = s.substring(j, j + patternCount);


      }
    }

    patternCountMap.entrySet()
        .stream()
        .forEach(entry -> {
          System.out.println("key: " + entry.getKey() + ", value : " + entry.getValue());
        });


    return answer;
  }

  public static void main(String[] args) {
    String s = "aabbaccc";
    First first = new First();
    int answer = first.solution(s);
    System.out.println(answer);
  }

}
