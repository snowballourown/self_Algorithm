package CodingTest.Programer_2.praticeProblem;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class reComeBackHome {

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = {};


        int [] distance = new int[n + 1];


        ArrayList<Integer>[] arrayLists = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        Arrays.fill(distance, -1);

        for (int i = 0; i < roads.length; i++) { //list로 연결
            arrayLists[roads[i][0]].add(roads[i][1]);
            arrayLists[roads[i][1]].add(roads[i][0]);
        }


        distance[destination] = 0;

        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(destination);


        while (!queue.isEmpty()) {

            int current = queue.poll();



            for (int next : arrayLists[current]) {
                if (distance[next] != -1) { // 한번이라도 초기화한곳은 패스
                    continue;       // 이걸로 방문된곳 인지아닌지 확인도같이함
                }


                distance[next] = distance[current] +1;
                queue.add(next);
            }
        }


        int[] result = new int[sources.length];


        for (int i = 0; i < result.length; i++) {
            result[i] = distance[sources[i]];
        }


        return  result;





    }
}
