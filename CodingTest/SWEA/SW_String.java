package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_String {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            int tc = Integer.parseInt(br.readLine());
            int answer = 0;

            String cmp = br.readLine(); //찾을 문자열

            String l = br.readLine(); // 문자열  문자





            // 길이 만큼 검색하면 되잖아?

            for (int j = 0; j < l.length() - cmp.length() +1 ; j++)
            {
                String s = ""; //초기화
                for (int k = j; k < cmp.length()+j; k++) {
                    // 비교하는거
                    s += l.charAt(k); // 비교할 문자 받기
                }

                if (cmp.contains(s))
                {
                    answer++    ;
                }
            }

            sb.append("#"+ (tc) + " "+ answer + "\n");

        }


        System.out.println(sb);
    }



}
