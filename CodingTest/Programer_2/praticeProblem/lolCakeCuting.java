package CodingTest.Programer_2.praticeProblem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class lolCakeCuting {
    public int solution(int[] topping) {
        int answer = 0;


        Set<Integer> left = new HashSet<>();

        Map<Integer, Integer> right = new HashMap<>();


        for (int i : topping) {
            right.put(i, right.getOrDefault(i, 0) + 1);
        }


        for (int i = 0; i < topping.length - 1; i++) {

            int type = topping[i];

            // 토핑 하나를 오른쪽에서 왼쪽으로 옮기기
            left.add(type);

            int remaining = right.get(type) - 1;



            if (remaining == 0) {
                right.remove(type);
            } else {
                right.put(type, remaining);
            }

            if (left.size() == right.size()) {
                answer++;
            }




        }
        


        return answer;

    }
}
