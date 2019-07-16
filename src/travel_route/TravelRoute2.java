package travel_route;

import java.util.TreeMap;
import java.util.TreeSet;

public class TravelRoute2 {

  class Route implements Comparable<Route>{
    String start;
    String destination;

    Route(String start, String destination) {
      this.start = start;
      this.destination = destination;
    }

    @Override
    public int compareTo(Route o) {
      if (destination.compareTo(o.destination) < 0) return -1;
      else return 1;
    }
  }

  public String[] solution(String[][] tickets) {
    String[] answer = new String[tickets.length + 1];
    TreeSet<Route> routeSet = new TreeSet<>();

    for (String[] ticket : tickets) {
      routeSet.add(new Route(ticket[0], ticket[1]));
    }

//    Route route = routeSet.ceiling();

    return answer;
  }

  public static void main(String[] args) {
    String[][] tickets = {
        {"ICN", "JFK"},
        {"HND", "IAD"},
        {"JFK", "HND"}
    };

    TravelRoute2 travelRoute2 = new TravelRoute2();

    travelRoute2.solution(tickets);

  }

}
