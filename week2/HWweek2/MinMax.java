package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MinMax {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        // count 숫자 받고
        Integer count = Integer.parseInt(br.readLine());
        // max mix 구할 숫자 넣어 놓고
        String number_string = br.readLine();

        StringTokenizer str = new StringTokenizer(number_string, " ");

        int number;
        for (int i = 0; i < count; i++)
        {
            number = Integer.parseInt(str.nextToken());
            if (number > max) {
                max = number;
            }
            if (number < min) {
                min = number;
            }

        }
        sb.append(min + " " + max);

        System.out.println(sb);
    }
}
