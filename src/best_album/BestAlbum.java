package best_album;

import java.util.TreeMap;
import java.util.TreeSet;

public class BestAlbum {

  final int TABLE_SIZE = 103; // 101, 103, 107, 109, 113
  TreeSet<Song>[] hashTable = new TreeSet[TABLE_SIZE];
  TreeSet<Genre> genreTreeSet = new TreeSet<>();

  static class Genre implements Comparable<Genre> {
    String genre;
    int playSum;
    int hash;

    Genre(String genre, int playSum) {
      this.genre = genre;
      this.playSum = playSum;
    }

    @Override
    public int hashCode() {
      int sum = 0;
      for (int i = 0; i < genre.length(); i++) {
        sum += genre.charAt(i);
      }
      hash = sum;
      return hash;
    }

    @Override
    public int compareTo(Genre o) {
      return Integer.compare(o.playSum, playSum);
    }
  }

  static class Song implements Comparable<Song> {
    String genre;
    int play;
    int number;

    Song(String genre, int play, int number) {
      this.genre = genre;
      this.play = play;
      this.number = number;
    }

    @Override
    public int compareTo(Song o) {
      if (play < o.play) return 1;
      else if (play == o.play) {
        if (number > o.number) return 1;
        else return -1;
      } else return -1;
    }
  }

  int transform(String str) {
    int sum = 0;

    for (int i = 0; i < str.length(); i++) {
      sum += str.charAt(i);
    }

    return sum;
  }

  int hashFunction(String str) {
    return transform(str) % TABLE_SIZE;
  }

  public void linearAdd(String genre, int play, int number) {
    Song song = new Song(genre, play, number);

    int hashValue = hashFunction(genre);
    int i = hashValue;

    while (hashTable[i] != null) {
      if (hashTable[i].first().genre.equals(genre)) {
        hashTable[i].add(song);
        return;
      }

      i = (i + 1) % TABLE_SIZE;
    }

    hashTable[i] = new TreeSet<>();
    hashTable[i].add(song);
  }

  public int[] solution(String[] genres, int[] plays) {
    int[] answer = {};

    for (int i = 0; i < genres.length; i++) {
      linearAdd(genres[i], plays[i], i);
      Genre genre = new Genre(genres[i], plays[i]);
      System.out.println(genre.hashCode());
      if (!genreTreeSet.add(genre)) {
        genre = genreTreeSet.floor(genre);
        genre.playSum += plays[i];
      }
    }

    for (TreeSet<Song> treeSet : hashTable) {
      if (treeSet != null) {
        System.out.println(treeSet.first().genre);
        treeSet.forEach(s -> {
          System.out.print(s.play + " ");
        });
        System.out.println();
      }
    }

    System.out.println();

    for (Genre genre : genreTreeSet) {
//      System.out.println(genre.hashCode());
      System.out.println(genre.genre);
      System.out.println(genre.playSum);
    }


    return answer;
  }


  public static void main(String[] args) {
//    TreeSet<Song> songs = new TreeSet<>();
//
//    songs.add(new Song("classic", 500, 0));
//    songs.add(new Song("pop", 600, 1));
//    songs.add(new Song("classic", 150, 2));
//    songs.add(new Song("classic", 800, 3));
//    songs.add(new Song("pop", 2500, 4));

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

    BestAlbum bestAlbum = new BestAlbum();

    int[] answer = bestAlbum.solution(genres, plays);

    for (int x : answer) {
//      System.out.println(x);
    }

  }

}
