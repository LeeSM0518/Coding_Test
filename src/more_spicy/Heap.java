package more_spicy;

public class Heap {

  private int[] nodes;
  private final int MAX_COUNT;
  private int currentCount;

  public Heap(final int maxCount) {
    this.MAX_COUNT = maxCount;
    nodes = new int[maxCount + 1];
  }

  public void insertMin(final int value) {
    int i = ++currentCount;

    while (i != 1 && value < nodes[i / 2]) {
      nodes[i] = nodes[i / 2];
      i /= 2;
    }

    nodes[i] = value;
  }

  public int removeMin() {
    int parent = 1, child = 2;
    int returnNode = nodes[parent];
    int lastNodeIndex = currentCount--;

    while (child <= currentCount) {
      if (child < currentCount && nodes[child] > nodes[child + 1]) child++;

      if (nodes[lastNodeIndex] <= nodes[child]) break;

      nodes[parent] = nodes[child];
      parent = child;
      child *= 2;
    }

    nodes[parent] = nodes[lastNodeIndex];
    nodes[lastNodeIndex] = 0;

    return returnNode;
  }

  public int peek() {
    return nodes[1];
  }

  public boolean empty() {
    return this.currentCount == 0;
  }

}