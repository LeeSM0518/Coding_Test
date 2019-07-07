package target_number;

public class TargetNumber2 {

  class Node {

    public int data;
    public boolean firstChange;
    public boolean secondChange;

    public Node(int data) {
      this.data = data;
      this.firstChange = false;
      this.secondChange = false;
    }

  }

  public int solution(int[] numbers, int target) {
    int answer = 0;
    int sum;
    int firstChangeCount = 0;

    Node[] nodes = new Node[numbers.length];

    for (int i = 0; i < nodes.length; i++) {
      nodes[i] = new Node(numbers[i]);
    }

    while (firstChangeCount != nodes.length) {
      firstChangeCount = 0;
      sum = 0;
      for (int i = 0; i < numbers.length; i++) {
        sum += nodes[i].data;
        if (i == 0) {
          nodes[i].data = -nodes[i].data;
          nodes[i].firstChange = !nodes[i].firstChange;
          nodes[i].secondChange = !nodes[i].firstChange;
        } else {
          if (nodes[i - 1].secondChange) {
            nodes[i].data = -nodes[i].data;
            nodes[i].firstChange = !nodes[i].firstChange;
            nodes[i].secondChange = !nodes[i].firstChange;
            nodes[i - 1].secondChange = false;
          }
        }
        if (nodes[i].firstChange) firstChangeCount++;
      }
      if (sum == target) answer++;
    }

    return answer;
  }

  public static void main(String[] args) {
    int[] numbers = {1, 1, 1, 1, 1};
    int target = 3;
    TargetNumber2 targetNumber2 = new TargetNumber2();

    System.out.println(targetNumber2.solution(numbers, target));
  }

}
