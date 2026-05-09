package CodingTest.Hash;

import java.util.HashMap;
import java.util.Map;

public class Phonechemon {

        public int solution(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1); //get값이 없으면 그냥 +1로 반환해달라
            }


            if (map.keySet().size() >= (nums.length / 2) ) { // 뽑는 개수

                return (nums.length / 2) ;
            } else {
                return map.keySet().size() ; // 보유한 종류 개수
            }


        }
}
