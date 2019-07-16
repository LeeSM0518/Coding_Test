package best_album;

import java.util.*;

public class BestAlbum2 {

  class Genre implements Comparable<Genre> {
    String name;
    int sum;

    Genre(String name, int play) {
      this.name = name;
      sum = play;
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
    TreeMap<Genre, TreeSet<Integer>> genreMap = new TreeMap<>();

    for (int i = 0; i < genres.length; i++) {
      Genre genre = new Genre(genres[i], plays[i]);


      System.out.println(genreMap.containsKey(genre));
      if (!genreMap.containsKey(genre)) {
        genre.sum += plays[i];
        genreMap.put(genre, new TreeSet<>());
        genreMap.get(genre).add(plays[i]);
      } else {
        Set<Map.Entry<Genre, TreeSet<Integer>>> containGenre = genreMap.entrySet();

      }
    }

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
