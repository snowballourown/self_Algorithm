package CodingTest.DFSorBFS;

import java.util.*;

class Solution {

    static boolean[] visited;
    static List<String> answerList = new ArrayList<>();

    public String[] solution(String[][] tickets) {

        visited = new boolean[tickets.length];

        // 도착지 기준 정렬 (사전순)
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));

        List<String> path = new ArrayList<>();
        path.add("ICN");

        dfs("ICN",path ,   tickets);

        return answerList.toArray(new String[0]);
    }

    public boolean dfs(String current, List<String> path, String[][] tickets) {

        // 모든 티켓 사용 완료
        if (path.size() == tickets.length + 1) {
            answerList = new ArrayList<>(path);
            return true; // 🔥 여기 중요 (첫 번째 정답에서 종료)
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(current)) {

                visited[i] = true;
                path.add(tickets[i][1]);

                if (dfs(tickets[i][1],path  , tickets)) {
                    return true;
                }

                // 백트래킹
                visited[i] = false;
                path.remove(path.size() - 1);
            }
        }

        return false;
    }
}
