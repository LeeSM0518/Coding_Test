package travel_route;

import java.util.ArrayList;
import java.util.List;

public class TravelRoute {

  class Route {
    public String start;
    public String destination;

    public Route(String start, String destination) {
      this.start = start;
      this.destination = destination;
    }
  }

  public int partition(List<Route> list, int left, int right) {
    Route pivot, temp;
    int low, high;

    low = left;
    high = right + 1;
    pivot = list.get(left);

    do {
      do {
        low++;
      } while (low <= right && list.get(low).destination
          .compareTo(pivot.destination) < 0);

      do {
        high--;
      } while (high >= left && list.get(high).destination
          .compareTo(pivot.destination) > 0);

      if (low < high) {
        temp = list.get(low);
        list.set(low, list.get(high));
        list.set(high, temp);
      }
    } while (low < high);

    temp = list.get(left);
    list.set(left, list.get(high));
    list.set(high, temp);

    return high;
  }

  public void sort(List<Route> list, int left, int right) {
    if (left < right) {
      int q = partition(list, left, right);

      sort(list, left, q - 1);
      sort(list, q + 1, right);
    }
  }

  public String[] solution(String[][] tickets) {
    String[] answer = new String[tickets.length + 1];
    List<Route> routeList = new ArrayList<>();
    List<String> answerList = new ArrayList<>();
    Route currentRoute = null;

    for (String[] ticket : tickets) {
      Route route = new Route(ticket[0], ticket[1]);
      routeList.add(route);
    }

    sort(routeList, 0, routeList.size() - 1);

    for (Route route : routeList) {
      if (route.start.equals("ICN")) {
        currentRoute = route;
        routeList.remove(currentRoute);
        answerList.add(currentRoute.start);
        break;
      }
    }

    while (!routeList.isEmpty()) {
      if (routeList.size() == 1) {
        answerList.add(routeList.get(0).start);
        answerList.add(routeList.get(0).destination);
        routeList.clear();
      } else {
        for (Route route : routeList) {
          if (route.start.equals(currentRoute.destination)) {
            currentRoute = route;
            routeList.remove(currentRoute);
            answerList.add(currentRoute.start);
            break;
          }
        }
      }
    }

    for (int i = 0; i < answerList.size(); i++) {
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

    TravelRoute travelRoute = new TravelRoute();

    String[] answer = travelRoute.solution(tickets);

    for (String route : answer) {
      System.out.println(route);
    }
  }

}
