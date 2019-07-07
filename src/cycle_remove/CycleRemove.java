package cycle_remove;

public class CycleRemove {

  public static boolean isCycle;
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
    boolean haveCycle = false;
    isCycle = false;

    recursiveTraversalDFS(startNodeIndex);

    for (int i = 0; i < nodeCount; i++) {
      if (visitNode[i] > 1) {
        haveCycle = true;
        break;
      }
    }

    for (int i = 0; i < nodeCount; i++) {
      visitNode[i] = 0;
    }

    return haveCycle;
  }

  public void recursiveTraversalDFS(int startNodeIndex) {
    visitNode[startNodeIndex]++;

    if (visitNode[startNodeIndex] > 1 || isCycle) {
      isCycle = true;
      return;
    }

    for (int i = 0; i < nodeCount; i++) {
      if (i != startNodeIndex) {
        if (visitEdges[startNodeIndex][i] != 0) {
          visitEdges[startNodeIndex][i] = 0;
          visitEdges[i][startNodeIndex] = 0;
          if (visitNode[startNodeIndex] > 1 || isCycle) {
            isCycle = true;
            return;
          }
          recursiveTraversalDFS(i);
        }
      }
    }
  }

  public int[][] removeNode(final int nodeNumber, final int[][] adjacentEdges) {
    int[][] alteredEdges = new int[nodeCount][nodeCount];

    for (int i = 0; i < nodeCount; i++) {
      System.arraycopy(adjacentEdges[i], 0, alteredEdges[i], 0, adjacentEdges[i].length);
    }

    for (int i = 0; i < adjacentEdges.length; i++) {
      alteredEdges[i][nodeNumber] = 0;
      alteredEdges[nodeNumber][i] = 0;
    }

    return alteredEdges;
  }

  public int haveEdge(int[][] edges) {
    int nodeNumber;

    out:
    for (nodeNumber = 0; nodeNumber < nodeCount; nodeNumber++) {
      for (int i = 0; i < nodeCount; i++) {
        if (edges[nodeNumber][i] == 1 || edges[i][nodeNumber] == 1) {
          break out;
        }
      }
    }

    return nodeNumber;
  }

  public int solution(int n, int[][] edges) {
    int[][] adjacentEdges = makeAdjacentEdges(n, edges);
    visitNode = new int[n];
    nodeCount = n;

    for (int i = 0; i < n; i++) {
      boolean isCycle = true;
      visitEdges = removeNode(i, adjacentEdges);
      while (haveEdge(visitEdges) < nodeCount) {
        isCycle = traversalDFS(haveEdge(visitEdges));
        if (isCycle) break;
      }
      if (!isCycle) {
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