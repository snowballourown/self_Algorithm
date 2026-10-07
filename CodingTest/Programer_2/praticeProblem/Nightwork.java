package CodingTest.Programer_2.praticeProblem;

import java.lang.reflect.Array;
import java.util.*;

public class Nightwork {
    public long solution(int n, int[] works) {
//        long answer = 0;
//
//        // 단순히 생각하면 큰 작업들 부터 뺴고 비교하고 빼고 비교하고 하면되잖아 그럼 큰수 제곱을 막을수있겠지
//
//
//        for (int i = 0; i < n; i++) { --------------------------------->  n
//            Arrays.sort(works);----------------------------------------> m  n*mlogm =>
//            if (works[works.length - 1] == 0) {
//                break;
//            }
//            works[works.length - 1]--;
//
//        }
//    int sum = 0;
//        for (int work : works) {
//            sum += work*work;
//        }
//
//
//
//
//        return sum;
        // 우선 queue를 활용하여 (m+n)logm 을 활용할것


        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());


        for (int work : works) {
            queue.add(work);
        }

        for (int i = 0; i < n; i++) {
            int max = queue.poll() - 1;
            queue.add(max);
        }

        long sum = 0;
        for (Integer i : queue) {
            sum += (long)i * i;
        }

        return sum;





    }
}
