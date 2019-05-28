package representation_of_numbers;

public class RepresentNumber {

    static int solution(int n) {
        int answer = 1;
        int sum;
        for(int i=0; i<(n/2)+1; i++) {
            sum = 0;
            for(int j=i+1; j<=(n/2)+1; j++) {
                sum += j;
                if(sum == n) {
                    answer++;
                    break;
                } else if (sum >= n) {
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 15;

        System.out.println(solution(n));
    }

}
