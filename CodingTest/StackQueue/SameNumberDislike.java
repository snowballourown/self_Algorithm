package CodingTest.StackQueue;

import java.util.ArrayList;

public class SameNumberDislike {
    public int[] solution(int[] arr) {

        // 배열을 받을때 연속적인 숫자가 들어오면 하나만 들어오게하고 나머지는 못들어오게한다


        ArrayList<Integer> list = new ArrayList<>();

        // 첫 원소 넣기
        list.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {

            // 바로 이전 값과 다르면 추가
            if (arr[i] != arr[i - 1]) {
                list.add(arr[i]);
            }
        }

        // ArrayList -> int[]
        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;


    }
}
