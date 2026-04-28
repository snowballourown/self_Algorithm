package CodingTest.DFSorBFS;

import java.util.ArrayList;

public class DFS_network {


     static  boolean visited[];
    static ArrayList<Integer>[] arrayLists;
    static int count = 0;
    public static int solution(int n, int[][] computers) {

        arrayLists = new ArrayList[n];
        visited = new boolean [n];
    //n은 컴퓨터의 개수
    for (int i = 0; i < n; i++)
    {
        arrayLists[i] = new ArrayList<>();
    }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (computers[i][j] == 1) {
                    arrayLists[i].add(j);
                    arrayLists[j].add(i);
                }
            }
        }

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {
                count++;
                DFS(i);
            }
        }
    
    return count;
}


    static void DFS(int i)
    {
        if (visited[i] ) {
            return;
        }
        visited[i] = true;
        for ( int j : arrayLists[i]) {
            if (!visited[j])
            {
                DFS(j);
            }
        }



    }


    public static void main(String[] args) {

       int computer[][] = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 1, 1}
        };


        System.out.println( solution(3, computer));


    }

}

