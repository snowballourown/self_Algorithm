package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class numberSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int i = Integer.parseInt(br.readLine());
        // 여기서 받고
        Integer sum = 0 ;

        String[] string = new String[i]; // 배열의크기 설정되고

        String k  =br.readLine();

        string = k.split("");
        for (String integer : string) {
            Integer h = Integer.parseInt(integer);
            sum = sum + h;}

        sb.append(sum);
        System.out.println(sum);



    }
}
