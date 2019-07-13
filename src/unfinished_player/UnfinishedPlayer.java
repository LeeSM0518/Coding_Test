package unfinished_player;

import java.util.*;

public class UnfinishedPlayer {

  public String solution(String[] participant, String[] completion) {
    Map<String, Integer> players = new HashMap<>();

    for (String player : completion) {
      if (!players.containsKey(player)) {
        players.put(player, 1);
      } else {
        players.put(player, players.get(player) + 1);
      }
    }

    for (String player : participant) {
      if (!players.containsKey(player)) {
        return player;
      } else {
        int sum = players.get(player);
        if (sum > 1) {
          players.put(player, sum - 1);
        } else {
          players.remove(player);
        }
      }
    }

    return null;
  }

  public static void main(String[] args) {
    String[] participant = {
        "a", "b", "a", "c"
    };

    String[] completion = {
        "b", "c", "a"
    };

    UnfinishedPlayer unfinishedPlayer = new UnfinishedPlayer();

    System.out.println(unfinishedPlayer.solution(participant, completion));
  }
}