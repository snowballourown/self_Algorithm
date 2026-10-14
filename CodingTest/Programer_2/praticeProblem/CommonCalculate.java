package CodingTest.Programer_2.praticeProblem;

public class CommonCalculate {

    public int solution(int[] arr) {

        int number = arr[0];
        for (int i = 1; i < arr.length; i++) {
            number = gcd(number, arr[i]);
        }

        return number;
    }


    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }


    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

}
