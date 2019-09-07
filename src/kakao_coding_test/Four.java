package kakao_coding_test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Four {

  final int LEFT = -1;
  final int ALL = 0;
  final int RIGHT = 1;

  public int[] solution(String[] words, String[] queries) {
    Map<String, Integer> answerMap = new HashMap<>();

    return Stream.of(queries).parallel().map(query -> {
      if (answerMap.containsKey(query)) {
        return answerMap.get(query);
      } else {
        String newQuery;
        int leftOrRightOrAll;
        if (query.charAt(0) != '?' && query.charAt(query.length() - 1) == '?') leftOrRightOrAll = LEFT;
        else if (query.charAt(0) == '?' && query.charAt(query.length() - 1) != '?') leftOrRightOrAll = RIGHT;
        else leftOrRightOrAll = ALL;

        if (leftOrRightOrAll == ALL) {
          return (int) Arrays.stream(words).parallel()
              .filter(word -> word.length() == query.length())
              .count();
        } else {
          newQuery = query.replace("?", "");
          String finalNewQuery = newQuery;
          int count = (int) Arrays.stream(words).parallel()
              .filter(word -> word.length() == query.length())
              .filter(word -> {
                if (leftOrRightOrAll == LEFT) {
                  return word.startsWith(finalNewQuery);
                } else {
                  return word.endsWith(finalNewQuery);
                }
              }).count();
          answerMap.put(query, count);
          return count;
        }
      }
    }).mapToInt(Integer::intValue).toArray();
  }

  public static void main(String[] args) {
    String[] words = {
        "frodo", "front", "frost", "frozen", "frame", "kakao"
    };
    String[] queries = {
        "fro??", "????o", "fr???", "fro???", "pro?"
    };

    Four four = new Four();
    int[] answer = four.solution(words, queries);
    for (int x : answer) {
      System.out.println(x);
    }
  }

}
