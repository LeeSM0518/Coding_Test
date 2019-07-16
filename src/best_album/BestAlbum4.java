package best_album;

import java.util.*;

public class BestAlbum4 {

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

  class Genre implements Comparable<Genre>{
    String name;
    int sum;

    Genre(String name, int sum) {
      this.name = name;
      this.sum = sum;
    }


    @Override
    public int compareTo(Genre o) {
      return Integer.compare(o.sum, sum);
    }
  }

  public int[] solution(String[] genres, int[] plays) {
    HashMap<String, TreeSet<Play>> playMap = new HashMap<>();
    HashMap<String, Integer> genreMap = new HashMap<>();
    TreeSet<Genre> genreSet = new TreeSet<>();
    List<Integer> answerList = new ArrayList<>();

    for (int i = 0; i < genres.length; i++) {
      if (!playMap.containsKey(genres[i])) {
        TreeSet<Play> playTreeSet = new TreeSet<>();
        playTreeSet.add(new Play(plays[i], i));
        playMap.put(genres[i], playTreeSet);
        genreMap.put(genres[i], plays[i]);
      } else {
        TreeSet<Play> playTreeSet = playMap.get(genres[i]);
        playTreeSet.add(new Play(plays[i], i));
        genreMap.put(genres[i], genreMap.get(genres[i]) + plays[i]);
      }
    }

    genreMap.forEach((s, integer) -> {
      genreSet.add(new Genre(s, integer));
    });

    genreSet.forEach(genre -> {
      TreeSet<Play> playTreeSet = playMap.get(genre.name);
      answerList.add(playTreeSet.pollFirst().number);
      if (!playTreeSet.isEmpty()) answerList.add(playTreeSet.pollFirst().number);
    });

    int[] answer = new int[answerList.size()];

    for (int i = 0; i < answer.length; i++) {
      answer[i] = answerList.get(i);
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

    BestAlbum4 bestAlbum4 = new BestAlbum4();

    bestAlbum4.solution(genres, plays);
  }

}
