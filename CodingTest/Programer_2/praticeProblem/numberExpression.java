package CodingTest.Programer_2.praticeProblem;

public class numberExpression {

    public int solution(int n) {
        int answer = 1;



        // index로 표시하면서



        int right = 2;
        int left = 1;
        while (right != left) {

            int sum = 0 ;

            for (int i = left; i <= right; i++) {
                sum += i;
            }

            if (n > sum) {
                right++;
            } else  {
                left++;
                if (n == sum) {
                    answer++;
                }
            }

        }














        return answer;
    }
}
