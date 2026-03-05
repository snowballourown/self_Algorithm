package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_Ggic_Gi {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int s = Integer.parseInt(br.readLine());

        for (int i = 1; i <= s ; i++) {
            sb.append(i + "\n");
        }
        System.out.println(sb);

    }
}
