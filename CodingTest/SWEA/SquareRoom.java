package CodingTest.SWEA;

import java.io.*;
import java.util.*;

public class SquareRoom {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int total = N * N;

            int[] row = new int[total + 1];
            int[] col = new int[total + 1];

            for (int r = 0; r < N; r++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int c = 0; c < N; c++) {
                    int value = Integer.parseInt(st.nextToken());

                    row[value] = r;
                    col[value] = c;
                }
            }

            int answerRoom = 1;
            int answerLength = 1;

            int start = 1;
            int length = 1;

            for (int num = 1; num < total; num++) {
                int distance = Math.abs(row[num] - row[num + 1])
                        + Math.abs(col[num] - col[num + 1]);  // 배열의 위치가 1차이 밖에 안난다면 붙어있다는것임

                if (distance == 1) {
                    length++;
                } else {
                    if (length > answerLength) { //기존의 답보다 크다면 기록
                        answerLength = length;
                        answerRoom = start;
                    }

                    start = num + 1; // 초기화하여 다음값받을준비
                    length = 1;
                }
            }

            if (length > answerLength) { // 만약에 중간에 계속 length로만 기록되다가 나올수도잇으니까  기록하는거하나 두고 시작
                answerLength = length;
                answerRoom = start;
            }

            sb.append("#")
                    .append(tc)
                    .append(" ")
                    .append(answerRoom)
                    .append(" ")
                    .append(answerLength)
                    .append("\n");
        }

        System.out.print(sb);
    }
}