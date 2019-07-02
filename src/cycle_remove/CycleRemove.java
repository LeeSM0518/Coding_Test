package cycle_remove;

public class CycleRemove {

  public int[][] visitEdges;
  public int[] visitNode;
  public int nodeCount;
  public int answer = 0;

  public int[][] makeAdjacentEdges(int n, int[][] edges) {
    int[][] adjacentEdges = new int[n][n];

    for (int[] edge : edges) {
      adjacentEdges[edge[0] - 1][edge[1] - 1] = 1;
      adjacentEdges[edge[1] - 1][edge[0] - 1] = 1;
    }

    return adjacentEdges;
  }

  public boolean traversalDFS(int startNodeIndex) {
    int visitNodeCount = 0;

    recursiveTraversalDFS(startNodeIndex);

    for (int i = 0; i < nodeCount; i++) {
      visitNodeCount += visitNode[i];
      visitNode[i] = 0;
    }

    return visitNodeCount <= nodeCount - 1;
  }

  public void recursiveTraversalDFS(int startNodeIndex) {
    visitNode[startNodeIndex]++;
    for (int i = 0; i < nodeCount; i++) {
      if (i != startNodeIndex) {
        if (visitEdges[startNodeIndex][i] != 0) {
          visitEdges[startNodeIndex][i] = 0;
          visitEdges[i][startNodeIndex] = 0;
          recursiveTraversalDFS(i);
        }
      }
    }
  }

  public int[][] removeNode(final int nodeNumber, final int[][] adjacentEdges) {
    int[][] alteredEdges = new int[nodeCount][nodeCount];

    for (int i = 0; i < nodeCount; i++) {
      for (int j = 0; j < nodeCount; j++) {
        alteredEdges[i][j] = adjacentEdges[i][j];
      }
    }

    for (int i = 0; i < adjacentEdges.length; i++) {
      alteredEdges[i][nodeNumber] = 0;
      alteredEdges[nodeNumber][i] = 0;
    }

    return alteredEdges;
  }

  public int solution(int n, int[][] edges) {
    int[][] adjacentEdges = makeAdjacentEdges(n, edges);
    visitNode = new int[n];
    nodeCount = n;

    for (int i = 0; i < n; i++) {
      visitEdges = removeNode(i, adjacentEdges);
      if (traversalDFS((i + 1) % n)) {
        answer += i + 1;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    int n = 8;
//    [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7],[7,8],[8,1],[2,7],[3,6]]
    int[][] edges = {
        {1, 2},
        {2, 3},
        {3, 4},
        {4, 5},
        {5, 6},
        {6, 7},
        {7, 8},
        {8, 1},
        {2, 7},
        {3, 6}
    };

    CycleRemove cycleRemove = new CycleRemove();
    System.out.println(cycleRemove.solution(n, edges));
  }

}
