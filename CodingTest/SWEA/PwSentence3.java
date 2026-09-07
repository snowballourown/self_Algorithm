package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class PwSentence3 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int TC = 10;

        for (int i = 0; i < TC; i++) {


            int N = Integer.parseInt(br.readLine());
            int[] PW = new int[N];
            StringTokenizer stn = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {                  //  N ( 2000 ≤ N ≤ 4000 의 정수)
                PW[j] = Integer.parseInt(stn.nextToken());
            }
            String[] command = new String[N];






        }




    }
}
