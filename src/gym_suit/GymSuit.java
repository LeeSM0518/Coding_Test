package gym_suit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GymSuit {

  static final int NULL = -1;

  public int solution(int n, int[] lost, int[] reserve) {
    int answer = n - lost.length;
    List<Integer> lostStudents = Arrays.stream(lost).boxed().collect(Collectors.toList());
    List<Integer> reserveStudents = Arrays.stream(reserve).boxed().collect(Collectors.toList());

    for (Integer lostStudent : lost) {
      if (lostStudents.contains(lostStudent) && reserveStudents.contains(lostStudent)) {
        lostStudents.remove(lostStudent);
        reserveStudents.remove(lostStudent);
        answer++;
      }
    }

    List<Integer> cloneLostStudents = new ArrayList<>(lostStudents);

    for (Integer lostStudent : cloneLostStudents) {
      Integer reserveStudent = reserveStudents.stream()
          .filter(student -> (student.equals(lostStudent - 1) || student.equals(lostStudent + 1)))
          .findFirst().orElse(NULL);
      if (!reserveStudent.equals(NULL)) {
        lostStudents.remove(lostStudent);
        reserveStudents.remove(reserveStudent);
        answer++;
      }
      if (reserveStudents.size() == 0 || lostStudents.size() == 0) break;
    }

    return answer;
  }

  public static void main(String[] args) {
    int n = 10;
    int[] lost = {2, 3, 4, 5};
    int[] reserve = {1, 2, 3, 4};

    GymSuit gymSuit = new GymSuit();

    System.out.println(gymSuit.solution(n, lost, reserve));
  }

}
