package CodingTest.programers.graph;

import java.util.*;

public class reDistanceNode {

    ArrayList<Integer>[] lists;
    boolean[] visited;
    int count[];


    public int solution(int n, int[][] edge) {
        int answer = 0;

        visited = new boolean[n+1];
        lists = new ArrayList[n+1];
        for (int i = 0; i < n + 1; i++) {
            lists[i] = new ArrayList<>();  // 리스트마다 배열을 선언함
        }

        count = new int[n+1];

        // NODE연결하고
        // visited도 방문하고 true로만 표현하고 끝내기

        // n  6	[[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]	 return 3

        for (int i = 0; i < edge.length; i++) {
            int s = edge[i][0];
            int e = edge[i][1];
            lists[s].add(e);
            lists[e].add(s);
        }

        BFS(1);

        int max =0;

        for (int i : count) {
            if (max < i) {
                max = i;
            }
        }

        for (int i : count) {
            if (max == i) {
                answer++;
            }
        }

        return answer;
    }



    void BFS(int i)
    {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        visited[i] = true;

        while (!queue.isEmpty()) {
                // 일단 queue에서 index를 뽑아
            //  index로 리스트에있는 녀석을 꺼내서
            // queue에 짚어넣어 그리고 녀석들을 중첩 카운트하면되겠다
            int index = queue.poll();
            for (int a : lists[index]) {
                if (!visited[a]) {
                    visited[a] = true;
                    count[a] = count[index] + 1;
                                            queue.add(a);
                }
            }
        }
    }






}
