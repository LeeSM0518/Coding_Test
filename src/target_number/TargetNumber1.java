package target_number;

public class TargetNumber1 {

  class TreeNode {
    public int data;
    public TreeNode leftChild;
    public TreeNode rightChild;
    public int number;

    public TreeNode(int data, int number) {
      this.data = data;
      this.number = number;
    }
  }

  class Tree {
    private TreeNode rootNode;           // 루트 노드
    private int levelCount;
    private int nodeCount;
    private int leftOrRight;
    private boolean searchSuccess;

    private final int LEFT = 0;
    private final int RIGHT = 1;

    public Tree() {
      rootNode = new TreeNode(0, 0);
      levelCount = 1;
      nodeCount = 0;
      leftOrRight = LEFT;
      searchSuccess = false;
    }

    public TreeNode getRootNode() {
      return rootNode;
    }

    public void sequentialAdd(int data) {
      searchSuccess = false;
      sequentialAddNode(this.getRootNode(), data);
      this.nodeCount++;
    }

    private void sequentialAddNode(TreeNode node, int data) {
      if (searchSuccess) return;

      if (node != null) {
        if (node.number == nodeCount / 2) {
          if (leftOrRight == LEFT) {
            node.leftChild = new TreeNode(data, nodeCount + 1);
          } else {
            node.rightChild = new TreeNode(data, nodeCount + 1);
          }
          leftOrRight = (leftOrRight == LEFT) ? RIGHT : LEFT;
          searchSuccess = true;
          return;
        }
        sequentialAddNode(node.leftChild, data);       // L
        sequentialAddNode(node.rightChild, data);      // R
      }
    }

    public void preorderTraversalRecursiveTree() {
      System.out.println("재귀 전위 순회");
      preorderTraversalRecursiveTreeNode(this.rootNode);
      System.out.println();
    }

    private void preorderTraversalRecursiveTreeNode(TreeNode node) {

      if (node != null) {
        count++;
        sum += node.data;
        if (count == levelCount && sum == target) answer++;
        preorderTraversalRecursiveTreeNode(node.leftChild);     // L
        preorderTraversalRecursiveTreeNode(node.rightChild);    // R
        count--;
        sum -= node.data;
      }
    }
  }

  public int answer = 0;
  public int sum = 0;
  public int count = 0;
  public int target;

  public int solution(int[] numbers, int target) {
    Tree tree = new Tree();
    this.target = target;
    int numberCount = 1;

    for (int number : numbers) {
      for (int i = 0; i < numberCount; i++) {
        tree.sequentialAdd(-number);
        tree.sequentialAdd(number);
      }
      tree.levelCount++;
      numberCount *= 2;
    }

    tree.preorderTraversalRecursiveTree();

    return answer;
  }

  public static void main(String[] args) {
    TargetNumber1 targetNumber1 = new TargetNumber1();
    int[] numbers = {1, 1, 1, 1, 1};
    int target = 3;

    System.out.println(targetNumber1.solution(numbers, target));
  }

}