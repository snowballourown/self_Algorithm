package CodingTest.completedsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class KthNumber {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

//        array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
//        1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
//        2에서 나온 배열의 3번째 숫자는 5입니다.
        int count = 0;


        for (int[] command : commands) {
            int i = command[0];
            int j = command[1];
            int k = command[2];

            ArrayList<Integer> arrayList = new ArrayList<>();

            for (int l = i - 1; l < j; l++) {
                arrayList.add(array[l]);
            }


            Collections.sort(arrayList);

            answer[count] = arrayList.get(k-1);
            count++;


        }



        return answer;
    }


    class Solution {
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];

            for (int idx = 0; idx < commands.length; idx++) {
                int i = commands[idx][0];
                int j = commands[idx][1];
                int k = commands[idx][2];

                int[] temp = Arrays.copyOfRange(array, i - 1, j);

                Arrays.sort(temp);

                answer[idx] = temp[k - 1];
            }

            return answer;
        }
    }
}