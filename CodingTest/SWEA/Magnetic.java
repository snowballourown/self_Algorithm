package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Magnetic {
    /*
    *
    * 좌표 중심 사고”에서 “상태 중심 사고”로 넘어가는 지점
    *   이런
    * 1. 무엇을 1개로 셀까?
      2. 전체를 저장해야 할까?
      3. 이전 상태 중 무엇만 기억하면 될까?
      4. 실제 시뮬레이션이 필요할까?
      5. 한 방향으로 스캔하면 끝나나?
    *
    *
    *  비슷한 문제
        괄호 문제
        쇠막대기
        문자열 폭발 일부 유형
        빗물 고이기 기초
        연속 구간 세기
        방향 바뀌는 횟수 세기
    *
    *
    *
    * */







    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = 10;

        for (int tc = 1; tc <= TC; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] board = new int[N][N];

            for (int row = 0; row < N; row++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int col = 0; col < N; col++) {
                    board[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = 0;

            for (int col = 0; col < N; col++) {
                boolean hasN = false;

                for (int row = 0; row < N; row++) {
                    if (board[row][col] == 1) {
                        hasN = true;
                    } else if (board[row][col] == 2) {
                        if (hasN) {
                            answer++;
                            hasN = false;
                        }
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(answer).append('\n');
        }

        System.out.print(sb);
    }
}