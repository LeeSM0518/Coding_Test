package create_character;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreateCharacter {

  int currentIndex = 0;

  public String solution(String s) {
    return Stream.of(s.split(""))
        .map(StringBuilder::new)
        .peek(str -> {
          if (str.charAt(0) == ' ') currentIndex = 0;
          else {
            if (currentIndex % 2 == 0) str.setCharAt(0, Character.toUpperCase(str.charAt(0)));
            else str.setCharAt(0, Character.toLowerCase(str.charAt(0)));
            currentIndex++;
          }
        })
        .collect(Collectors.joining());
  }

  public static void main(String[] args) {
    String s = " try hello  world";
    CreateCharacter createCharacter = new CreateCharacter();
    System.out.println(createCharacter.solution(s));
  }

}
