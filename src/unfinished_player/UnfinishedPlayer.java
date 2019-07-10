package unfinished_player;

public class UnfinishedPlayer {

  public Player[] hashTable;
  public int tableSize;

  class Player {
    String name;
    boolean check;

    Player (String name) {
      this.name = name;
      check = false;
    }
  }

  private int transform(String str) {
    int sum = 0;

    for (int i = 0; i < str.length(); i++) {
      sum += str.charAt(i);
    }

    return sum;
  }

  private int hashFunction(String str) {
    return transform(str) % tableSize;
  }

  public void quadraticAdd(String item) {
    int hashValue = hashFunction(item);
    int i = hashValue;
    int inc = 0;

    while (hashTable[i] != null) {
      i = (hashValue + inc * inc) % tableSize;
      inc += 1;
    }

    hashTable[i] = new Player(item);
  }

  public boolean quadraticSearch(String item) {
    int hashValue = hashFunction(item);
    int i = hashValue;
    int inc = 0;

    while (hashTable[i] != null) {
      if (item.equals(hashTable[i].name) && !hashTable[i].check) {
        hashTable[i].check = true;
        return true;
      }

      i = (hashValue + inc * inc) % tableSize;
      inc += 1;

      if (i == hashValue) {
        return false;
      }
    }

    return false;
  }

  public String solution(String[] participant, String[] completion) {
    String answer = "";
    tableSize = 1000019;
    hashTable = new Player[tableSize];

    for (String name : completion) {
      quadraticAdd(name);
    }

    for (String name : participant) {
      boolean searchSuccess = quadraticSearch(name);
      if (!searchSuccess) return name;
    }

    return answer;
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
