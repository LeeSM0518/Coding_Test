package dual_priority_queue;

public class DualPriorityQueue {

  public int[] solution(String[] operations) {
    int[] answer = new int[2];
    Heap heap = new Heap(1000000);

    for (String operation : operations) {
      if (operation.equals("D 1") && !heap.empty()) {
        heap.removeMax();
      }
      else if (operation.equals("D -1") && !heap.empty()) {
        heap.removeMin();
      }
      else if (operation.split(" ")[0].equals("I")){
        String[] splits = operation.split(" ");
        heap.insert(Integer.valueOf(splits[1]));
      }
    }

    if (!heap.empty()) {
      answer[0] = heap.removeMax();
      answer[1] = heap.removeMin();
    }

    return answer;
  }

  public static void main(String[] args) {
    String[] operations = new String[]{"I 16", "D 1"};
    DualPriorityQueue dualPriorityQueue = new DualPriorityQueue();
    int[] arr = dualPriorityQueue.solution(operations);

    for (int i : arr) System.out.println(i);
  }

}