package CodingTest.Programer_2.praticeProblem;


import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class orangeSelect {
    public int solution(int k, int[] tangerine) {
        int answer = 0;


        HashMap<Integer, Integer> map = new HashMap<>();

        for (int size : tangerine) {

            map.put(size, map.getOrDefault(size, 0) + 1);
        }


        Integer[] count = map.values().toArray(new Integer[0]);


        Arrays.sort(count, Collections.reverseOrder());

        for (Integer i : count) {
            answer++;
            k -= i;

            if (k <= 0) {
                break;
            }

        }


      return answer;


    }
}
