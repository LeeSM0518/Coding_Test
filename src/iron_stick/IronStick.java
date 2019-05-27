package iron_stick;

public class IronStick {

    static public int solution(String arrangement) {
        int answer = 0;
        int stack = 0;

        for (int i = 0; i < arrangement.length(); i++) {
            if (arrangement.charAt(i) == ')' && arrangement.charAt(i - 1) == '(') {
                stack--;
                answer += stack;
            } else if (arrangement.charAt(i) == ')') {
                stack--;
                answer++;
            } else if (arrangement.charAt(i) == '(') {
                stack++;
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
