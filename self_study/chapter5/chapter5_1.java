package self_study.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class chapter5_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];

        num[0] = 0;
        for (int i = 0; i < n; i++) {  num[i] = Integer.parseInt(br.readLine());}

        for (int j = 0; j < n-1; j++) {
            for (int i = 0; i < n-j-1; i++) {
                if (num[i] > num[i+1])
                {   int temp = num[i];
                    num[i] = num[i+1];
                    num[i+1] = temp; }
            }
        }



        for (int i = 0; i < n; i++) {
            System.out.println(num[i]);

        }
    }
}
