package ranking;

import java.util.ArrayList;
import java.util.List;

public class Ranking {

  public static List<Integer> returnRank = new ArrayList<>();

  public class DirectArrayGraph {

    private int nodeCount;
    private int[][] edges;

    public DirectArrayGraph(int[][] edges) {
      this.nodeCount = edges.length;
      this.edges = edges;
    }

    public int getEdge(int fromNode, int toNode) {
      return edges[fromNode][toNode];
    }

    public int getNodeCount() {
      return nodeCount;
    }

    public void traversalDFS(int startNodeIndex) {
      recursiveTraversalDFS(startNodeIndex, new int[getNodeCount()]);
    }

    private void recursiveTraversalDFS(int startNodeIndex, int[] visit) {
      visit[startNodeIndex] = 1;
      returnRank.add(startNodeIndex);
      for (int i = 0; i < getNodeCount(); i++) {
        if (i != startNodeIndex) {
          if (getEdge(startNodeIndex, i) != 0 && visit[i] == 0) {
            recursiveTraversalDFS(i, visit);
          }
        }
      }
    }

  }

  public int solution(int n, int[][] results) {
    int answer = 0;
    int[][] edges = new int[n][n];
    List<Integer> rankList = new ArrayList<>();

    for (int[] result : results) {
      edges[result[0] - 1][result[1] - 1] = 1;
    }

    DirectArrayGraph graph = new DirectArrayGraph(edges);

    for (int i = 0; i < n; i++) {
      graph.traversalDFS(i);

      returnRank.forEach(System.out::println);
      System.out.println();

      returnRank.clear();
    }

    return answer;
  }

  public static void main(String[] args) {
    int n = 5;
    int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};

    Ranking ranking = new Ranking();

    System.out.println(ranking.solution(n, results));
  }

}
