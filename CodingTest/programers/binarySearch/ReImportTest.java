package CodingTest.programers.binarySearch;

import java.util.Arrays;

public class ReImportTest {
    public long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times);

        Long left = (long)times[0];
        Long right = (long)times[times.length - 1] * n;
        Long mid = (left + right) / 2;

        while (left <= right) {

            mid = (left + right) / 2;
            long count = 0;

            for (int time : times) { // 각자 time들이 들어갈수있는 양을 체크 하는거임
                count += mid / time;
            }

            if (count >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid +1;
            }





        }










        return answer;
    }
}
