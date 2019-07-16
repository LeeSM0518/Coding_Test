package travel_route;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class TravelRoute3 {

  class Route implements Comparable<Route>{
    String start;
    TreeSet<Destination> destinationSet;

    Route(String start, String destination) {
      this.start = start;
      destinationSet = new TreeSet<>();
      destinationSet.add(new Destination(destination));
    }

    @Override
    public int compareTo(Route o) {
      if (start.equals(o.start)) return 0;
      else if (start.compareTo(o.start) < 0) return -1;
      else return 1;
    }
  }

  class Destination implements Comparable<Destination>{
    String place;

    Destination(String place) {
      this.place = place;
    }

    @Override
    public int compareTo(Destination o) {
      if (place.compareTo(o.place) < 0) return -1;
      else return 1;
    }
  }

  public String[] solution(String[][] tickets) {
    List<String> answerList = new ArrayList<>();

    TreeSet<Route> routeSet = new TreeSet<>();

    for (String[] ticket : tickets) {
      Route route = new Route(ticket[0], ticket[1]);
      if (!routeSet.contains(route)) {
        routeSet.add(route);
      } else {
        Route beforeRoute = routeSet.ceiling(route);
        beforeRoute.destinationSet.add(new Destination(ticket[1]));
      }
    }

    Destination destination = null;
    Route route;

    while (!routeSet.isEmpty()) {
      if (answerList.size() == 0) {
        answerList.add("ICN");
        route = routeSet.ceiling(new Route("ICN", "XXX"));
      } else {
        route = routeSet.ceiling(new Route(destination.place, "XXX"));
      }
      destination = route.destinationSet.pollFirst();
      answerList.add(destination.place);
      if (route.destinationSet.size() == 0) routeSet.remove(route);
    }

    String[] answer = new String[answerList.size()];

    for (int i = 0; i < answer.length; i++) {
      answer[i] = answerList.get(i);
    }

    return answer;
  }

  public static void main(String[] args) {
    String[][] tickets = {
        {"ICN", "JFK"},
        {"HND", "IAD"},
        {"JFK", "HND"}
    };

    TravelRoute3 travelRoute3 = new TravelRoute3();

    travelRoute3.solution(tickets);

  }

}