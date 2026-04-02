package self_study.mentoringafter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] num = new int[N];
        StringTokenizer stn = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(stn.nextToken());

        }
        int goal = Integer.parseInt(br.readLine());
        int cnt =0 ;
        for (int i : num) {
            if (goal == i) {
                cnt++;
            }
        }
        System.out.println(cnt);




    }
}
