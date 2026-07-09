package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Contact {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int length = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            graph = new ArrayList[101];

            for (int i = 1; i <= 100; i++) {
                graph[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < length / 2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                graph[from].add(to);
            }

            visited = new boolean[101];

            int answer = bfs(start);

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        System.out.print(sb);
    }

    static int bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();

        visited[start] = true;
        queue.offer(start);

        int answer = start;

        while (!queue.isEmpty()) {
            int size = queue.size();  // 현재 층 size 체크
            int maxNode = 0;  // 최대값 초기화

            for (int i = 0; i < size; i++) { // 현재층만큼 반복
                int now = queue.poll();
                maxNode = Math.max(maxNode, now); // 현재층에서 가장 큰녀석 추출

                for (int next : graph[now]) {
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next); // 추가하기
                    }
                }
            }

            answer = maxNode;
        }

        return answer;
    }
}