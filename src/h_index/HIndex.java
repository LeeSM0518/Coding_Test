package h_index;

import java.util.TreeSet;

public class HIndex {

  static class Quotation implements Comparable<Quotation>{
    int times;

    public Quotation(int times) {
      this.times = times;
    }

    @Override
    public int compareTo(Quotation o) {
      if (this.times == o.times) return 1;
      else return Integer.compare(o.times, times);
    }
  }

  public static int solution(int[] citations) {
    int citationNumber = 1;
    TreeSet<Quotation> citationSet = new TreeSet<>();

    for (int citation : citations) {
      citationSet.add(new Quotation(citation));
    }

    for (Quotation citation : citationSet) {
      if (citationNumber == citation.times) return citationNumber;
      else if (citationNumber > citation.times) return --citationNumber;
      citationNumber++;
    }

    return --citationNumber;
  }

  public static void main(String[] args) {
    int[] citations = {3, 0, 6, 1, 5};

    System.out.println(solution(citations));
  }

}
