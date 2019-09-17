package stock_price;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StockPrice {

  public int[] solution(int[] prices) {
    int[] answer = new int[prices.length];
    Queue<Integer> queue = new LinkedList<>();

    for (int price : prices) queue.add(price);

    for (int i = 0; i < answer.length; i++) {
      int price = queue.poll();
      int time = 0;
      for (int value : queue) {
        time++;
        if (price > value) break;
      }
      answer[i] = time;
    }

    return answer;
  }

  public static void main(String[] args) {
    int[] prices = {1, 2, 3, 2, 3};
    StockPrice stockPrice = new StockPrice();
    int[] answer = stockPrice.solution(prices);

    for (int x : answer) System.out.println(x);
  }

}
