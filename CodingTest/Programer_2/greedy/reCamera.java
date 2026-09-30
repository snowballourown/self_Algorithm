package CodingTest.Programer_2.greedy;

import java.util.Arrays;


public class reCamera {
    public int solution(int[][] routes) {



        // 정렬을 안하게되면 그냥

        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

        int end  = -30001; // 맨마지막 숫자를 기억해서
        int count  = 0;
        for (int[] route : routes) { // 여기서 특이한점은  end를 카메라위치로 둔다는거?

            if (route[0] > end) {
                count++;
                end = route[1];
            }

        }


        return count;
    }
}
