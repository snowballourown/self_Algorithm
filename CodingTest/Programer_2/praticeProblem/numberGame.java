package CodingTest.Programer_2.praticeProblem;

import java.util.Arrays;

public class numberGame {

    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int wins = 0;

        for (int b : B) {
            // 아직 이기지 못한 A의 가장 작은 수와 비교
            if (b > A[wins]) {
                wins++;
            }

        }

        return wins;
    }

}
