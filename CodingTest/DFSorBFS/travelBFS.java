package CodingTest.DFSorBFS;
import java.util.*;


class travelBFS{

    class Solution {
        boolean[] visited;
        ArrayList<String> answer = new ArrayList<>();
        public String[] solution(String[][] tickets) {

            visited = new boolean[tickets.length];
            // 1. 도착지를 기준으로 알파벳 오름차순 정렬
            // 정렬을 미리 해두면 제일 처음 찾은 유효한 경로가 무조건 정답이 됩니다.
            Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));

            // 2. 경로를 저장할 리스트를 만들고 출발지 "ICN"을 넣고 DFS 시작
            ArrayList<String> route = new ArrayList<>();
            route.add("ICN");
            dfs("ICN", tickets, route);

            // 3. 완성된 리스트를 String 배열로 변환하여 반환
            return answer.toArray(new String[0]);
        }

        private boolean dfs(String current, String[][] tickets, ArrayList<String> route) {
            // 모든 티켓을 다 사용했다면(방문한 공항 수 = 티켓 수 + 1)
            if (route.size() == tickets.length + 1)
            {
                answer = new ArrayList<>(route); // 정답 기록
                return true;                     // 정답을 찾았다는 신호를 반환!
            }

            for (int i = 0; i < tickets.length; i++) {
                // 아직 사용하지 않은 티켓 중, 출발지가 현재 공항과 일치하는 티켓을 찾음
                if (!visited[i] && tickets[i][0].equals(current)) //방문하지않고 티켓의 처음부분과 현재 값이 같다?면
                {
                    // 티켓 사용 처리 및 경로 추가
                    visited[i] = true;
                    route.add(tickets[i][1]); // 다음 꺼를 추가하고


                    // 다음 공항으로 이동 (재귀 호출)
                    // 만약 깊이 들어갔는데 true가 돌아왔다면, 정답을 찾은 것이므로
                    // 더 이상 다른 경로를 탐색하지 않고 바로 빠져나옵니다.
                    if (dfs(tickets[i][1], tickets, route)) {
                        return true;
                    }


                    // 이 길로 갔더니 티켓을 다 못 썼다면, 방금 쓴 티켓을 취소하고 경로에서 제거

                    visited[i] = false;
                    route.remove(route.size() - 1);
                }
            }
            // 이 경로로는 모든 티켓을 사용할 수 없음
            return false;
        }
    }
}