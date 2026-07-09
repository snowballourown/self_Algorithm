package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class MaxPrizePratice {

    static char [] s;
    static int op;
    static int max = 0;
    static Set<String> visited;
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

         visited = new HashSet<>();

        StringTokenizer stn;

        for (int i = 0; i < TC; i++) {
            stn = new StringTokenizer(br.readLine(), " ");

            s = stn.nextToken().toCharArray();
            op = Integer.parseInt(stn.nextToken());

        }

    }


    void dfs(int depth) {
        String number = new String(s);

        if (visited.contains(number)) {
            return;
        }  ///

        visited.add(depth + " " + number);

        if (depth == op) {
            max = Math.max(max, Integer.parseInt(number));
        return;
        }

        for (int i = 0; i < s.length; i++) {
            for (int j = i + 1; j < s.length; j++) {
                swap(i, j);
                dfs(depth+1);
                swap(i, j);
            }
        }


    }


    void swap(int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;

    }



}
