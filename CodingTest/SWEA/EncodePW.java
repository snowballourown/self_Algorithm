package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EncodePW {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {

            int PW_Length = Integer.parseInt(br.readLine());
            String[] strings = new String[100];
            StringTokenizer stn = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < PW_Length; j++) {
                strings[j] = stn.nextToken();
            }


            int commandPw = Integer.parseInt(br.readLine());
            stn = new StringTokenizer(br.readLine(), " ");
            int length = PW_Length;
            for (int j = 0; j < commandPw; j++) { // 명령어 받기
                String cm = stn.nextToken();
                int start = Integer.parseInt(stn.nextToken());
                int count = Integer.parseInt(stn.nextToken());
                String[] stringInsert = new String[count];
                for (int k = 0; k < count; k++) {
                    stringInsert[k] = stn.nextToken();
                }
                // 바로 실행

                // 명령어를 적용한 string 구조를 만든다음
                for (int k = length - 1; k >= start; k--) {
                    strings[k + count] = strings[k];
                }

// 새 값 넣기
                for (int k = 0; k < count; k++) {
                    strings[start + k] = stringInsert[k];
                }

                length += count;



                // string 배열 10개 짜리 만들어서 10개만 받아서  그 배열로 초기화

            }
            String[] newString = new String[100];
            for (int k = 0; k < 10; k++) {
                newString[k] = strings[k];
            }

            strings = newString;
            sb.append("#"+ (i+1)).append(" ");
            for (String string : strings) {
                if (string == null) continue;
                sb.append(string +" ");

            }
            sb.append("\n");


        }
        System.out.println(sb);
    }
}
