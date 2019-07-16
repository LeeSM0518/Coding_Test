package best_album;

import com.sun.tools.javah.Gen;

import java.util.*;

public class BestAlbum3 {

  class Play implements Comparable<Play> {
    int times;
    int number;

    Play(int times, int number) {
      this.times = times;
      this.number = number;
    }

    @Override
    public int compareTo(Play o) {
      if (o.times == times) {
        if (number < o.number) return -1;
        else return 1;
      } else return Integer.compare(o.times, times);
    }
  }

  class Genre implements Comparable<Genre> {
    String name;
    int sum;
    TreeSet<Play> playSet;

    Genre(String name, int play, int number) {
      this.name = name;
      sum = play;
      playSet = new TreeSet<>();
      playSet.add(new Play(play, number));
    }

    @Override
    public int compareTo(Genre o) {
      if (name.equals(o.name)) return 0;
      else {
        if (sum < o.sum) return 1;
        else return -1;
      }
    }

  }

  public int[] solution(String[] genres, int[] plays) {
    TreeSet<Genre> genreSet = new TreeSet<>();
    List<Integer> albumList = new ArrayList<>();

    for (int i = 0; i < genres.length; i++) {
      Genre genre = new Genre(genres[i], plays[i], i);

      if (!genreSet.contains(genre)) {
        genreSet.add(genre);
      } else {
        Genre beforeGenre = genreSet.ceiling(genre);
        System.out.println(genreSet.remove(beforeGenre));
        beforeGenre.sum += genre.sum;
        beforeGenre.playSet.add(new Play(genre.sum, i));
        genreSet.add(beforeGenre);
      }

      genreSet.forEach(genre1 -> {
        System.out.println(genre1.name + ", " + genre1.sum);
        genre1.playSet.forEach(play -> {
          System.out.print(play.times + ", ");
        });
        System.out.println();
      });
      System.out.println();
    }

    genreSet.forEach(genre -> {
      albumList.add(genre.playSet.pollFirst().number);
      if (!genre.playSet.isEmpty()) {
        albumList.add(genre.playSet.pollFirst().number);
      }
    });

    int[] answer = new int[albumList.size()];

    albumList.forEach(x -> {
      System.out.println(x);
    });

    for (int i = 0; i < answer.length; i++) {
      answer[i] = albumList.get(i);
    }

    return answer;
  }

  public static void main(String[] args) {
    String[] genres = {
        "classic",
        "d",
        "classic",
        "classic",
        "pop",
        "classic",
        "classic",
        "pop",
        "c",
        "c",
        "c",
        "d"
    };

    int[] plays = {
        500, 200, 500, 500, 600, 1150, 800, 2500, 100, 200, 200, 4000
    };

    BestAlbum3 bestAlbum3 = new BestAlbum3();

    bestAlbum3.solution(genres, plays);

  }

}
