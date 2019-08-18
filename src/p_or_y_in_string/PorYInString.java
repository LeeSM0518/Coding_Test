package p_or_y_in_string;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PorYInString {

  boolean solution(String s) {
    List<String> strings = Arrays.stream(s.split(""))
        .map(String::toLowerCase)
        .collect(Collectors.toList());

    return strings.stream().filter(character -> character.equals("p")).count()
        == strings.stream().filter(character -> character.equals("y")).count();
  }

  public static void main(String[] args) {
    String str = "pPoooyY";
    PorYInString porYInString = new PorYInString();
    System.out.println(porYInString.solution(str));
  }

}
