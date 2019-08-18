package same_number;

import java.util.*;

public class SameNumber {

  public int[] solution(int[] arr) {
    Stack<Integer> stack = new Stack<>();
    Queue<Integer> queue = new LinkedList<>();

    for (int value : arr) {
      if (stack.empty() || !(stack.peek() == value)) {
        stack.push(value);
        queue.add(value);
      }
    }

    return queue.stream().mapToInt(Integer::intValue).toArray();
  }

  public static void main(String[] args) {
    SameNumber sameNumber = new SameNumber();
    int[] arr = {1, 1, 3, 3, 0, 1, 1};
    arr = sameNumber.solution(arr);

    for (int i : arr) {
      System.out.println(i);
    }
  }

}
