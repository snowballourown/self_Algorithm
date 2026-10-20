package CodingTest.Programer_2.praticeProblem;

import java.util.HashMap;
import java.util.Map;

public class discountEventV1_window {

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;


        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }


        // 처음 10 셋팅
        for (int i = 0; i < 10; i++) {
            if (map.containsKey(discount[i])) {
                map.put(discount[i], map.get(discount[i]) - 1);
            }
        }


        for (int left = 0, right = 10;
             right <= discount.length; left++,right++) {


            if (isZero(map)) {
                answer++;
            }


            if (map.containsKey(discount[left])) {
                map.put(discount[left], map.get(discount[left]) + 1);
            }

            if (right < discount.length && map.containsKey(discount[right])) {
                map.put(discount[right], map.get(discount[right]) -1);
            }






            
        }






        return answer;
    }



    private boolean isZero(Map<String, Integer> map) {

        for (Integer value : map.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }











}
