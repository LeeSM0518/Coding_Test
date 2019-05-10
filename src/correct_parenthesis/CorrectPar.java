package correct_parenthesis;

public class CorrectPar {

    static boolean solution (String s) {
        int stack = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack += 1;
            else if (s.charAt(i) == ')') stack -= 1;

            if (stack < 0) return false;
        }

        if (stack == 0) return true;
        else return false;
    }

    public static void main(String[] args) {
        String s = ")()(";

        System.out.println(solution(s));
    }
}
