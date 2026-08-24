package CodingTest.programers.Hash;

import java.util.HashMap;
import java.util.Map;

public class reClothes {
    public int solution(String[][] clothes) {

        Map<String, Integer> map = new HashMap<>();

        for (String[] clothe : clothes) {
            String s = clothe[1];
            map.put(s, map.getOrDefault(s, 0) + 1);

        }

            int answer =1;
        for (Integer value : map.values()) {
            answer *= (value + 1);
        }


        return answer -1 ;// 아무것도 없는경우
    }
}
