package travel_route;

import java.util.*;

public class TravelRoute4 {

  int answerSize;
  List<Stack<String>> routeList = new ArrayList<>();
  Stack<String> routeStack = new Stack<>();
  HashMap<Integer, String> intPlaceMap = new HashMap<>();
  HashMap<String, Integer> stringPlaceMap = new HashMap<>();

  class Graph {
    int nodeCount;
    int[][] edges;

    Graph(int nodeCount) {
      this.nodeCount = nodeCount;
      edges = new int[nodeCount][nodeCount];
    }

    void addEdge(int fromNode, int toNode) {
      edges[fromNode][toNode]++;
    }

    void dfs(int startNodeIndex) {
      int i;
      for (i = 0; i < nodeCount; i++) {
        if (i != startNodeIndex) {
          if (edges[startNodeIndex][i] > 0) {
            edges[startNodeIndex][i]--;
            routeStack.add(intPlaceMap.get(i));
            if (routeStack.size() == answerSize - 1) {
              routeList.add((Stack<String>) routeStack.clone());
            }
            dfs(i);
            edges[startNodeIndex][i]++;
            if (routeStack.size() != 0) {
              routeStack.pop();
            }
          }
        }
      }
    }
  }

  public String[] solution(String[][] tickets) {
    TreeSet<String> placeSet = new TreeSet<>();
    answerSize = tickets.length + 1;

    for (String[] ticket : tickets) {
      placeSet.add(ticket[0]);
      placeSet.add(ticket[1]);
    }

    for (int i = 0; !placeSet.isEmpty(); i++) {
      String place = placeSet.pollFirst();
      intPlaceMap.put(i, place);
      stringPlaceMap.put(place, i);
    }

    Graph graph = new Graph(intPlaceMap.size());

    for (String[] ticket : tickets) {
      graph.addEdge(stringPlaceMap.get(ticket[0]), stringPlaceMap.get(ticket[1]));
    }

    graph.dfs(stringPlaceMap.get("ICN"));

    int index = 0;
    String[] answer = new String[routeList.get(0).size() + 1];
    answer[index++] = "ICN";

    for (String str : routeList.get(0)) {
      answer[index++] = str;
    }

    return answer;
  }

  public static void main(String[] args) {
    String[][] tickets = {
        {"ICN", "SFO"},
        {"ICN", "ATL"},
        {"SFO", "ATL"},
        {"ATL", "ICN"},
        {"ATL", "SFO"},
    };

    TravelRoute4 travelRoute4 = new TravelRoute4();

    travelRoute4.solution(tickets);

  }
}
