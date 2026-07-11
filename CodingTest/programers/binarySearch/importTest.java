package CodingTest.programers.binarySearch;

import java.util.Arrays;
public class importTest {

    class Solution_2{

        public long solution(int n, int[] times) {


            Arrays.sort(times);

            long answer = 0;

            long left  = 1;

            long right = (long) times[times.length - 1] *n; // 느린심사위원이 다처리하는경우
            while (left <= right) {

                long mid = (left + right) / 2;

                long count =0;


                for (int time : times) {
                    count += mid / time;
                }


                if (count >= n) {
                    answer = mid;
                    right = mid-1;
                } else {
                    left = mid + 1;
                }

            }

            return answer;
            }





        }
    }
