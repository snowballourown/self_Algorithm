package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class factorial {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(br.readLine());
        int sum = 0;

        for (int i = 1; i <= a; i++) {
            sum +=i;
        }

        sb.append(sum);
        System.out.println(sum);
    }
}
