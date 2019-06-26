package more_spicy;

public class MoreSpicy {
  public static int solution(int[] scoville, int K) {
    int answer = 0;

    Heap minHeap = new Heap(scoville.length);

    for (int i : scoville) minHeap.insertMin(i);

    while (minHeap.peek() <= K) {
      if (minHeap.empty()) return -1;
      int firstMin = minHeap.removeMin();
      int secondMin = minHeap.removeMin();
      int mix = firstMin + secondMin * 2;

      minHeap.insertMin(mix);
      answer++;
    }

    return answer;
  }

  public static void main(String[] args) {
    int[] scoville = new int[]{1, 2, 3, 9, 10, 12};
    int k = 7;

    System.out.println(solution(scoville, k));
  }

}
