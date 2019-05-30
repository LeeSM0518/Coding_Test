package number_of_124_country;

public class NumberOfCountry {

    public static String solution(int n) {
        StringBuilder answer = new StringBuilder();
        int result = n;


        while (result == 0) {
            int mod = result / 3;

            if (mod == 0) {
                answer.append(4);

            } else {
                answer.append(mod);
            }
        }

        answer.reverse();

        return answer.toString();
    }


    public static void main(String[] args) {
        System.out.println(solution(4));
    }
}
