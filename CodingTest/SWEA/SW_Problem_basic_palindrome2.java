package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW_Problem_basic_palindrome2 {

    static int answer;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();



        for (int i = 0; i < 10; i++) {
            Integer tc= Integer.parseInt(br.readLine());



            char[][] c = new char[100][100]; // 100x100
            for (int j = 0; j < 100; j++)
            {
                String s = br.readLine();

                for (int k = 0; k < 100; k++)
                {
                    c[j][k] = s.charAt(k);
                }
            }
            // 가로검사
             answer = 0;


            for (int len = 100; len >= 1; len--) {
                if (getAnswer(c, len)) {
                    answer = len;
                    break;
                }
            }
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }


        System.out.println(sb);
    }


    private static boolean getAnswer(char[][] c, int length) {
        // 가로 검사
        for (int row = 0; row < 100; row++) {
            for (int start = 0; start <= 100 - length; start++) {
                boolean ok = true;

                for (int k = 0; k < length / 2; k++) {
                    if (c[row][start + k] != c[row][start + length - 1 - k]) {
                        ok = false;
                        break;
                    }
                }

                if (ok) return true;
            }
        }

        // 세로 검사
        for (int col = 0; col < 100; col++) {
            for (int start = 0; start <= 100 - length; start++) {
                boolean ok = true;

                for (int k = 0; k < length / 2; k++) {
                    if (c[start + k][col] != c[start + length - 1 - k][col]) {
                        ok = false;
                        break;
                    }
                }

                if (ok) return true;
            }
        }

        return false;
    }

}

