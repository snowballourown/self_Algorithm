package self_study.chapter5;

import com.sun.jdi.Value;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class greedyAlogrithsm_P11047 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine(), " ");


        int N = Integer.parseInt(stn.nextToken());
        int goal = Integer.parseInt(stn.nextToken());
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(A);
        int count = 0;
        for (int i = N-1; i >= 0; i--) {
            int Q = goal / A[i];
            if (Q != 0) {
                count += Q;
                goal -= Q * A[i];
            }
        }
        System.out.println(count);

    }
}
