package kth_number;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class KthNumber {
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        // 정렬되지 않은 배열을 저장할 리스트
        List<Integer> commandList = new ArrayList<Integer>();
        // 정렬된 배열을 저장할 리스트
        List<Integer> sortedList;

        int commandsHeadIndex;
        int commandsTailIndex;
        int commandsCount;

        for (int i = 0; i < commands.length; i++) {
            commandsHeadIndex = commands[i][0] - 1;
            commandsTailIndex = commands[i][1] - 1;
            commandsCount = commands[i][2] - 1;

            // 가져올 요소들을 리스트에 저장
            for (int j = commandsHeadIndex; j <= commandsTailIndex; j++) {
                commandList.add(array[j]);
            }

            // 가져온 요소들을 스트림을 사용해서 정렬시킨다.
            sortedList = commandList.stream()
                    .sorted(Comparator.naturalOrder())
                    .collect(Collectors.toList());

            // 지정된 인덱스의 값을 저장
            answer[i] = sortedList.get(commandsCount);
            // 정렬되지 않은 리스트 비우기
            commandList.clear();
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {
                {2, 5, 3},
                {4, 4, 1},
                {1, 7, 3}
        };

        int[] answer = solution(array, commands);

        for(int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + ",");
        }
    }
}
