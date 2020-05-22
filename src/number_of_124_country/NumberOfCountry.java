package number_of_124_country;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class NumberOfCountry {

    public static String solution(int n) {
        List<Integer> answerList = new LinkedList<>();
        int answer = n;

        while (answer != 0) {
            answerList.add(0, answer % 3);
            answer /= 3;
        }

        System.out.println(answerList);

        return answerList.stream()
            .map(i -> {
                if (i == 0) return 4;
                else return i;
            })
            .map(String::valueOf)
            .collect(Collectors.joining());
    }


    public static void main(String[] args) {
        for (int i = 1; i <= 13; i++) {
            System.out.println(i + ": " + solution(i));
        }
    }
}
