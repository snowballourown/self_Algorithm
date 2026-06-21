package CodingTest.completedsearch;

import java.util.ArrayList;

public class rerenetworkTwo {


    ArrayList<Integer>[] arrayLists;
    boolean visited[];

    public int solution(int n, int[][] wires) {
        int answer = -1;
        // tree 형태로 되어있고 node를 2개로 쪼갤건데
        // 쪼갠노드가 최소값이어야 함


        for (int i = 1; i <= n + 1; i++) {
            arrayLists[i] = new ArrayList<>();
        }



        for (int i = 0; i < wires.length; i++) {
            int s = wires[i][0];
            int e = wires[i][1];

            arrayLists[s].add(e);
            arrayLists[e].add(s);
        }


        for (int[] wire : wires) { // wire가 끊는다는의미임
            int a = wire[0];
            int b = wire[0];

            visited = new boolean[n + 1];


            int w = dfs(a, a, b);
            int other = n - w;

            answer = Math.min(answer, other - w);

        }



        return answer;
    }


    int dfs(int current, int a, int b) {

        visited[current] = true;

        int count = 1;


        for (int next  : arrayLists[current]) {
            if ((a == current && next == b) || (b == current || a == next)) {
                continue;
            }
            if (!visited[next]) {
                count +=dfs(next, a,  b);
            }

        }


        return count;

    }

}
