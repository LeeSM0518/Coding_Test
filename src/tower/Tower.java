package tower;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Tower {
    static public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];

        Stack<StackNode> stack = new Stack<>();

        int i = 0;
        while (true) {
            if (i == heights.length) {
                break;
            }
            else if (stack.isEmpty()) {
                StackNode stackNode = new StackNode(heights[i], i+1);
                stack.push(stackNode);
                answer[i++] = 0;
            } else {
                StackNode pop = stack.pop();
                if (pop.value > heights[i]) {
                    stack.push(pop);
                    StackNode stackNode = new StackNode(heights[i], i+1);
                    stack.push(stackNode);
                    answer[i++] = pop.position;
                }
            }
        }

        return answer;
    }

    public static class StackNode {
        int value;
        int position;

        StackNode(int value, int position) {
            this.value = value;
            this.position = position;
        }
    }

    public static void main(String[] args) {
        int[] heights = {6, 9, 5, 7, 4};
        int[] answer = solution(heights);

        System.out.print("[ ");
        for (int i : answer) {
            System.out.print(i + ",");
        }
        System.out.println(" ]");
    }
}
