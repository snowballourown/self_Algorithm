package CodingTest.programers.graph;

import self_study.chapter5.DFS2;

import java.util.ArrayList;
import java.util.Arrays;

public class distanceNode {

    // max depth를 찾으면됨
    // 방문여부를 확인하는용

    int max;
    boolean []visited;
    ArrayList<Integer>[] arrayLists;
    int [] distance;



    public int solution(int n, int[][] edge) {
        int answer = 0;

        //depth로 edge 길이 파악하면 될거같고

        visited = new boolean[n+1];
        distance = new int[n+1];

        // node 마다 각자 vertex값 주고  +  1에서 기준이니까 거리를 매김


        visited[1] = true;

        max=0;
        arrayLists = new ArrayList[n+1];

        for (int i = 1; i < n+1; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge.length; i++) {
            int s = edge[i][0];
            int e = edge[i][1];
            arrayLists[s].add(e);
            arrayLists[e].add(s); // 연결작업
        }

        DFS(1, 0);


        for (int i : distance) {
            if (max == i) {
                answer++;
            }
        }

        return answer;
    }


    void DFS(int i, int depth) {

        for (int j : arrayLists[i]) {
            if (!visited[j]) {//방문하지 않았을 경우
                visited[j] = true;
                DFS(j, depth+1);
            }
        }


        distance[i] = depth;
        if (max < depth) {
            max = depth;
        }


    }

}
