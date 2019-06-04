package iron_stick;

import java.util.Stack;

public class IronStick2 {

    static public int solution(String arrangement) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < arrangement.length(); i++) {
            if (arrangement.charAt(i) == ')' && arrangement.charAt(i-1) == '(') {
                stack.pop();
                answer += stack.size();
            } else if (arrangement.charAt(i) == ')') {
                stack.pop();
                answer++;
            } else if (arrangement.charAt(i) == '(') {
                stack.push('(');
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String arrangement = "()(((()())(())()))(())";

        int answer = solution(arrangement);

        System.out.println(answer);
    }
}
