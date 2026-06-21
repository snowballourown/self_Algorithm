package CodingTest.completedsearch;

import java.util.ArrayList;
import java.util.Arrays;

public class renetworkTwo {
    // DFS + 2개씩 자른다는느낌

    ArrayList<Integer>[] arrayLists;
    boolean[] visited;

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        arrayLists = new ArrayList[n + 1];


        for (int i = 1; i <= n; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < wires.length; i++) {
            int s = wires[i][0];
            int e = wires[i][1];
            arrayLists[s].add(e);
            arrayLists[e].add(s);
        }


        for (int[] wire : wires) {

            visited = new boolean[n+1];

            int a = wire[0];
            int b = wire[1];


            int count = dfs(a, a, b);

            int other =  n - count;
            answer = Math.min(answer, Math.abs(other - count));

        }


        return answer;
    }


    int dfs(int current, int a, int b) {

        visited[current] = true;

        int count = 1;
        for (int next : arrayLists[current]) {
            if ((current == a && next == b) || (current == b) && (next == a)) {
                // 첫번쨰는 현재랑 a 이거 다음 b가 뜰경우  똑같으니까  pass하자는얘기
                // 두번쨰는 현재가 b 일경우  a랑이미 한번 나눴으니까 또나누지 말자는 애기 그래서
                continue;
            }


            if (!visited[next]) {
                count += dfs(next, a, b);
            }
        }


        return  count;




    }
}
