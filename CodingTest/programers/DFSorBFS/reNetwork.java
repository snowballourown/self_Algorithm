package CodingTest.programers.DFSorBFS;

import java.util.ArrayList;

public class reNetwork {

    static boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;

        //배열 을 서로 연결하고  연결안되어있으면
        // for문 으로 visited node면 DFS 돌리는 과정 visited 들어갈떄마다 count 하면 네트워크 작동할듯 굳이 DFS까지 안가더라도

        ArrayList<Integer>[] arrayList = new ArrayList[n+1];

        visited = new boolean[computers.length];

        for (int i = 0; i < computers.length; i++) {
            arrayList[i] = new ArrayList<>();
        }

        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[0].length; j++) {
                if (computers[i][j] == 1) {
                    if (i == j) {
                        continue;
                    }
                    arrayList[i].add(j);
                }
            }
        }


        for (int i = 0; i < computers.length; i++) {
            if (!visited[i]) {
                DFS(i, arrayList);
                answer++;
            }
        }






        return answer;
    }

    private static void DFS(int i, ArrayList<Integer>[] arrayList) {
        visited[i] = true;

        for (int a : arrayList[i]) {
            if (!visited[a]) {
                DFS(a, arrayList);
            }
        }
    }


}
