package kakao_coding_test;

import java.util.*;

public class First2 {

  public int solution(String s) {
    int answer = 0;
    List<List<String>> listOfStringList = new ArrayList<>();

    for (int i = 1; i < s.length(); i++) {
      List<String> stringList = new ArrayList<>();
      int j = 0;
      for (; j < s.length() - i; j += i) {
        stringList.add(s.substring(j, j + i));
      }
      stringList.add(s.substring(j));
      listOfStringList.add(stringList);
    }

//    listOfStringList.stream()
//        .forEach(list -> {
//          System.out.println(list);
//        });

    List<String> strings = new ArrayList<>();
    Map<String, Integer> patternMap = new HashMap<>();

    for (List<String> list : listOfStringList) {
      String before = null;
      for (int i = 0; i < list.size(); i++) {
        String currentPattern = list.get(i);
        if (!patternMap.containsKey(list.get(i))) {
          patternMap.put(currentPattern, 1);
          before = currentPattern;
        } else {
          if (currentPattern.equals(before)) {
            patternMap.put(currentPattern, patternMap.get(currentPattern) + 1);
          } else {
            before = currentPattern;
          }
        }
      }
      String str = "";
      for (Map.Entry<String, Integer> entry : patternMap.entrySet()) {
        str += entry.getValue() + entry.getKey();
      }
      strings.add(str);
    }

    strings.stream().forEach(System.out::println);

    return answer;
  }

  public static void main(String[] args) {
    String s = "aabbaccc";
    First2 first = new First2();
    int answer = first.solution(s);
    System.out.println(answer);
  }

}
