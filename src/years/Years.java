package years;

import java.util.Calendar;

public class Years {

  enum Day {SUN, MON, TUE, WED, THU, FRI, SAT;}

  public String solution(int a, int b) {
    Day[] days = Day.values();

    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.YEAR, 2016);
    calendar.set(Calendar.MONTH, a - 1);
    calendar.set(Calendar.DATE, b);

    return String.valueOf(days[calendar.get(Calendar.DAY_OF_WEEK)-1]);
  }

  public static void main(String[] args) {
    int a = 5, b = 24;
    Years years = new Years();

    System.out.println(years.solution(a, b));
  }
}
