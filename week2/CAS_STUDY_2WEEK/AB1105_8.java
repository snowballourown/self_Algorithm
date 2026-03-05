package week1;

import java.io.BufferedReader;
import java.io.*;
import java.util.StringTokenizer;

public class AB1105_8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // 빠른 출력용

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수 입력

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            sb.append("Case #").append(i).append(": ")
                    .append(A).append(" + ").append(B).append(" = ").append(A + B).append("\n");
        }

        System.out.print(sb); // 한 번에 출력
    }
}
