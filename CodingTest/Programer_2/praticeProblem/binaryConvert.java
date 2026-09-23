package CodingTest.Programer_2.praticeProblem;

public class binaryConvert {
    public int[] solution(String s) {
        int count = 0;
        int sumZero = 0;

        while (!s.equals("1")) {
            int numberOne = 0;
            int numberZero = 0;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    numberOne++;
                } else {
                    numberZero++;
                }
            }

            sumZero += numberZero;
            s = Integer.toBinaryString(numberOne);
            count++;
        }

        return new int[]{count, sumZero};
    }
}
