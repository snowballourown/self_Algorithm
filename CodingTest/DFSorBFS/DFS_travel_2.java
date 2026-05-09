package CodingTest.DFSorBFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DFS_travel_2 {

    static boolean visited[]; // 방문하는 곳
    static List<String> answerPath = new ArrayList<>();


    public String[] solution(String[][] tickets) {

        visited = new boolean[tickets.length];

        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));

        List<String> path = new ArrayList<>();
        path.add("INC");
        dfs("INC", tickets, path);


        return answerPath.toArray(new String[0]);
    }


    boolean dfs(String current, String tickets[][], List<String> path) {
        if (path.size() == tickets.length +1 ) {
           answerPath = new ArrayList<>(path);
            return true;
        }


        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(current))
            {
                visited[i] = true;
                path.add(tickets[i][0]);

                if (dfs(tickets[i][1], tickets, path)) {
                    return true;
                }

                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }

        return false;

    }
}
