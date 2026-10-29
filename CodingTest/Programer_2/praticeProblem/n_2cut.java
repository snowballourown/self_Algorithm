package CodingTest.Programer_2.praticeProblem;

import java.util.ArrayList;
import java.util.List;

public class n_2cut {
    public int[] solution(int n, long left, long right) {

        int[] answer;
        // n x n
        // left 번째 줄 , right번째쭐 까지  -> answer로 출력


        List<Long> list = new ArrayList<>();


        for (Long i = left; i <= right; i++) {
            if ((i % n) <= (i / n)) {
                list.add((i / n) + 1);
            } else {
                list.add((i % n) + 1);
            }

        }

        answer = list.stream()
                .mapToInt(Long::intValue)
                .toArray();

        return answer;

    }
}
