package h_index;

import java.util.TreeSet;

public class HIndex {

  class Quotation implements Comparable<Quotation>{
    int times;

    public Quotation(int times) {
      this.times = times;
    }


    @Override
    public int compareTo(Quotation o) {
      return Integer.compare(times, o.times);
    }
  }

  public static int solution(int[] citations) {
    int answer = 0;
    TreeSet<Integer> citationSet = new TreeSet<>();

    for (int citation : citations) {
      citationSet.add(citation);
    }

    citationSet.forEach(System.out::println);

    return answer;
  }

  public static void main(String[] args) {
    int[] citations = {3, 0, 6, 1, 5};

    System.out.println(solution(citations));
  }

}
