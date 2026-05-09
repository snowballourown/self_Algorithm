package CodingTest.Hash;

import java.util.HashMap;

public class clothes {


        public int solution(String[][] clothes) {

            // 종류별 개수 저장
            HashMap<String, Integer> map = new HashMap<>();

            for (String[] cloth : clothes) {
                String type = cloth[1];
                map.put(type, map.getOrDefault(type, 0) + 1);
            }

            int answer = 1;

            // (개수 + 1)씩 곱하기
            for (int count : map.values()) { // +1을 아예안입기임 굳이따로따로 계싼 하지마셈
                answer *= (count + 1);
            }

            // 아무것도 안 입는 경우 제외
            return answer - 1;
        }









}
