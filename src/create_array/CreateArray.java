package create_array;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreateArray {

  public int[] solution(long n) {
    return Stream.of(Stream.of(String.valueOf(n))
        .map(StringBuffer::new)
        .map(StringBuffer::reverse)
        .map(StringBuilder::new)
        .collect(Collectors.joining())
        .split(""))
        .mapToInt(Integer::valueOf)
        .toArray();
  }

  public static void main(String[] args) {
    int n = 12345;
    CreateArray createArray = new CreateArray();
    int[] answer = createArray.solution(n);

    for (int x : answer) System.out.println(x);
  }

}
