package CodingTest.programers.Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.StructuredTaskScope;


public class ReTravelPath {
    static  boolean visited[];
    static ArrayList<String> arrayList = new ArrayList<>();


    public String[] solution(String[][] tickets) {

        visited = new boolean[tickets.length];
        // DFS로 해야될듯 그리고 만약 같은 선택지가있다면
        // 스펠링이 더 빠른 녀석으로 하는걸로

        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        List<String> path = new ArrayList<>();
        path.add("ICN");

        dfs("ICN", path, tickets);


        return arrayList.toArray(new String[0]);
    }


    public boolean dfs(String current, List<String> path, String[][] tickets) {
        // 모든 티켓 사용 완료
        if (path.size() == tickets.length + 1) {
            arrayList = new ArrayList<>(path);
            return true;
            // 🔥 여기 중요 (첫 번째 정답에서 종료)
        }

        // 인천을 가장 맨앞에 두고 뒤에를 후순위두는 거였던거같은데 정렬방식


        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(current)) {

                visited[i] = true;
                path.add(tickets[i][1]);


                if (dfs(tickets[i][1], path, tickets)) {
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
