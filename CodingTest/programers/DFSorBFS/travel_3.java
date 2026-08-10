package CodingTest.programers.DFSorBFS;

import java.util.Arrays;


class travel_3 {
        static boolean[] visited;
        static String[] answer;

        public String[] solution(String[][] tickets) {
            Arrays.sort(tickets, (a, b) -> {
                if (a[0].equals(b[0])) { // 출발지가 같으면 도착지로 비교하겠다는뜻임
                    return a[1].compareTo(b[1]);
                }
                return a[0].compareTo(b[0]);
            });

            visited = new boolean[tickets.length];
            answer = new String[tickets.length + 1];

            answer[0] = "ICN";
            dfs(tickets, "ICN", 1);

            return answer;
        }

        static boolean dfs(String[][] tickets, String location, int depth) {
            if (depth == tickets.length + 1) {
                return true;
            }

            for (int i = 0; i < tickets.length; i++) {
                if (!visited[i] && tickets[i][0].equals(location)) {
                    visited[i] = true; // 티켓썻다는것 표시
                    answer[depth] = tickets[i][1]; // 도착지 표시

                    if (dfs(tickets, tickets[i][1], depth + 1)) {
                        return true;
                    }

                    visited[i] = false;
                }
            }

            return false;
        }
    }
