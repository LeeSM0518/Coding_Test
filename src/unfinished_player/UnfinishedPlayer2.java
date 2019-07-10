package unfinished_player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnfinishedPlayer2 {

  public String solution(String[] participant, String[] completion) {
    List<String> player = new ArrayList<>(Arrays.asList(participant));

    for (String str : completion) {
      player.remove(str);
    }

    return player.remove(0);
  }

  public static void main(String[] args) {
    String[] participant = {
        "a", "b", "a", "c"
    };

    String[] completion = {
        "b", "c", "a"
    };

//    UnfinishedPlayer2 unfinishedPlayer2 = new UnfinishedPlayer2();
//
//    System.out.println(unfinishedPlayer2.solution(participant, completion));

    int sum = 0;
    for (int i = 0; i < 20; i++) {
      sum += "z".charAt(0);
    }

    System.out.println(sum);
  }
}
