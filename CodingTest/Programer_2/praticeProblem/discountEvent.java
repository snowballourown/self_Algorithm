package CodingTest.Programer_2.praticeProblem;

import java.util.HashMap;

public class discountEvent {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        HashMap<String, Integer> map = new HashMap<>();



        // want 원하는 상품
        // number 원하는 상품의 갯수
        // discount 마트에서 한가지 상품을 할인하는데 한개씩 밖에 못쌈



        // for문을 discount에서 10개 빼면 조사횟수하면되겠네 전체 조사할떄


        for (int i = 0; i < discount.length - 10; i++) {
            for (int j = 0; i < want.length; i++) {
                map.put(want[j], number[j]);
            }

            // 연속되는지도 확인 해야지
            // 원하는 해당하는 상품이 없으면 0으로 리턴
            int count =0;
            for (int j = i; j < i + 10; j++) {
                if (map.containsKey(discount[j])|| map.get(discount[j]) > 0) {
                    map.put(discount[j], map.get(discount[j]) - 1);
                } else { // 더이상 없는데 접근하거니까 다음으로 패스
                    break;
                }
                count++;

            }
            if (count == 10) {
                answer++;
            }


        }

        return  answer;






        //이게 결국 연속된 숫자로 계속나와야한다는거지

        //for문으로 discount돌리면서 중간에 원하지않는 상품등 그런게 나오면 0처리하셈




    }
}
