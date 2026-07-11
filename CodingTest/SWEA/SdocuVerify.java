package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SdocuVerify {


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());
        int[][] number = new int[10][10]; // 9X9
        for (int i = 0; i < TC; i++) {
            for (int j = 1; j <=9 ; j++) {
                StringTokenizer stn = new StringTokenizer(br.readLine(), " ");
                for (int k = 1; k <= 9; k++) {
                    number[j][k] = Integer.parseInt(stn.nextToken());
                }
            }


            //가로행 조사

            if (NumberVerify_H(number) && NumberVerify_W(number) && NumberVerify_3X3(number)) {
                sb.append("#" + (i + 1) +" " + 1 + "\n");
            } else {
                sb.append("#" + (i + 1) + " "+ 0 + "\n");
            }
            //새로행 조사
            // 3x3 칸 씩 조사
        }

        System.out.println(sb);

    }

    private static boolean NumberVerify_W(int[][] number) {
        for (int j = 1; j <= 9; j++) {
            boolean[] visited = new boolean[10];
            for (int k = 1; k <= 9; k++) {
                if (!visited[number[j][k]]) { // 가로축 조사
                    visited[number[j][k]] = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean NumberVerify_H(int[][] number) {
        for (int j = 1; j <= 9; j++) {
            boolean[] visited = new boolean[10];
            for (int k = 1; k <= 9; k++) {
                if (!visited[number[k][j]]) { // 새로축 조사
                    visited[number[k][j]] = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean NumberVerify_3X3(int[][] number) {
        int y =1;
        for (int z = 1; z <=3 ; z++) {
            int x =1;

            for (int i = 1; i <= 3; i++) {

                    boolean[] visited = new boolean[10];

                    for (int j = y; j <= y+2 ; j++) {
                        for (int k = x; k <= x+2; k++) {  // x-> 1~
                            if (!visited[number[j][k]]) {
                                visited[number[j][k]] = true;
                            } else {
                                return false;
                            }
                        }
                    }
                    x = x+ 3;
            }
            y = y+3;

        }
        return true;
    }
}
