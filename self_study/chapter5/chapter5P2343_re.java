package self_study.chapter5;

import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class chapter5P2343_re {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(stn.nextToken()); // 레슨수
        int M = Integer.parseInt(stn.nextToken());// 블루레이 개수

        int[] A = new int[N];

        stn = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(stn.nextToken());
        }

        //
        int start = 0;
        int end = 0;
        for (int i = 0; i < N; i++) {
            if (start < A[i]) {
                start = A[i];
            }
            end = end + A[i];
        }

      while (start <= end) {
            int middle = (start + end) / 2;
            int sum = 0 ;
            int count = 0;

            for (int i = 0; i < N; i++) {
                if (sum + A[i]> middle) { // middle sum
                    count++;
                    sum  = 0;
                }
                sum = sum  + A[i]; //  다 더해주고 s
            }


          if (sum != 0) {
              count++;      }
          if (count > M) {
              start = middle + 1;}
          else end = middle - 1;
      }
        System.out.println(start);
    }
}
