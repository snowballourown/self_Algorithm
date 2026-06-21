package CodingTest.programers.Heap;


import java.util.*;

public class the_spice {
    public int solution(int[] scoville, int K) {
        // 정리하자면
        // 이진트리중에서는 heap라는 이있는데
        // 여기서 최대힙 최소힙 2가지가있어
        // 넣을떄마다 자동으로 최대힙 최소힙이되는거야

        PriorityQueue<Integer> pq = new PriorityQueue<>();// 자료구조가 heap 최소힙인거임

        for (Integer integer : scoville) {
            pq.add(integer); // 정렬상태를 유지함
        }


        int count = 0;
        while (pq.size() >= 2 && pq.peek() < K) { // 가장 작은값이 k보다 작으면서 pq사이즈가 2개이상이여야함
            int first = pq.poll();
            int second = pq.poll();

            int mix = first + second*2;
            pq.add(mix);

            count++;
        }

        if (pq.peek() < K) {
            return -1;
        }


        return count;



    }
}
