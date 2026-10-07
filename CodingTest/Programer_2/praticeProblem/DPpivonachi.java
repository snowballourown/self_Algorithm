package CodingTest.Programer_2.praticeProblem;

public class DPpivonachi {

    public int solution(int n) {
        int answer = 0;


        int[] number = new int[n+1];


        number[0] = 0;
        number[1] = 1;


        for (int i = 2; i <= n; i++) {
            number[i] = (number[i-2] + number[i - 1]) % 1234567;
        }









        return number[n];
    }

}
