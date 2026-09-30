package CodingTest.Programer_2.greedy;

import java.util.Arrays;

public class camera {
    public int solution(int[][] routes) {
/*
*
*[[-20,-15], [-14,-5], [-18,-13], [-5,-3]]	2
*
* */


        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

        int end = -30001;
    int count = 0;

        for (int[] route : routes) {

            if (route[0] > end) {
            count++;
                end = route[1];
            }
        }




        return count;
    }
}
