package best_album;

import java.util.Comparator;

public class BestAlbum2 {

  class Genre implements Comparable<Genre> {
    String name;
    int sum;

    Genre(String name) {
      this.name = name;
      sum = 0;
    }

    @Override
    public int hashCode() {
      int sum = 0;

      for (int i = 0; i < name.length(); i++) {
        sum += name.charAt(i);
      }

      return sum;
    }

    @Override
    public boolean equals(Object obj) {
      Genre genre = (Genre) obj;
      return name.equals(genre.name);
    }

    @Override
    public int compareTo(Genre o) {
      return Integer.compare(o.sum, sum);
    }
  }

  public int[] solution(String[] genres, int[] plays) {
    int[] answer = {};

    return answer;
  }

  public static void main(String[] args) {
    String[] genres = {
        "classic",
        "pop",
        "classic",
        "classic",
        "pop",
    };

    int[] plays = {
        500, 600, 150, 800, 2500
    };

    BestAlbum2 bestAlbum2 = new BestAlbum2();

    int[] answer = bestAlbum2.solution(genres, plays);

    for (int x : answer) {
      System.out.println(x);
    }
  }



}
