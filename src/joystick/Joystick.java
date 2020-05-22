package joystick;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Joystick {

  // ABCDEFGHIJKLMNOPQRSTUVWXYZ 26
  // A = 0
  // Z = 25

  public int solution(String name) {
//    List<Integer> answer = Stream.of(name.split(""))
//        .map(i -> (int)i.charAt(0) - 65)
//        .map(i -> {
//          if ()
//        })
//        .collect(Collectors.toList());
//    System.out.println(answer);
    return 0;
  }

  public static void main(String[] args) {
    String name = "JEROENZ";
    Joystick joystick = new Joystick();
    System.out.println(joystick.solution(name));
  }

}
