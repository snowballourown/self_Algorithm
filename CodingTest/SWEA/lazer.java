package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class lazer {

    static class Work {
        int due;
        int during;

        public Work( int during,int due) {
            this.due = due;
            this.during = during;
        }
    }




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            int N = Integer.parseInt(br.readLine());

            Work[] works = new Work[N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int during = Integer.parseInt(st.nextToken());
                int due = Integer.parseInt(st.nextToken());

                works[i] = new Work(during, due);
            }


            Arrays.sort(works, (a, b) -> b.due - a.due);

            int time = Integer.MAX_VALUE;

            for (Work work : works) {
                time = Math.min(time, work.due);  // work의 due가
                time -= work.during; // 사용할수있는  day 체크
            }

            sb.append(time).append("\n");



        }


        System.out.println(sb);

    }
}

