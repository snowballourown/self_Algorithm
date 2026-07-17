package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class SW_Problem_basic_palindrome {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = 10;
        String[][] strings = new String[8][8];
        for (int i = 0; i < TC; i++) {

            int window = Integer.parseInt(br.readLine()); // 찾을 문자열 크기

            for (int j = 0; j < strings.length; j++) {
                strings[j] = br.readLine().split("");
            }
            // 비교할 문자열을 찾아야하기에 가로축과 새로축을 이동하는 window를 만들어야겠다
            // 가로축 이동할때 window 크기는 알려줌
            String[] tmp_stringarray = new String[window]; // 원본
            String[] tmp1_stringarray = new String[window];  // 반전


            int count= 0;
            for (int z = 0; z < 8 ; z++) {
                    for (int j = 0; j < 8 - window +1; j++) {//window크기로 행을 조사할수있는 횟수
                        int u = 0;
                        for (int k = j; k < j + window; k++) {
                            tmp_stringarray[u] = strings[z][k];
                        u++;
                        }
                        tmp1_stringarray = reverse_string(tmp_stringarray);
                        if (Arrays.equals(tmp_stringarray,tmp1_stringarray)) {
                            count++;
                        }

                    }
            }
            for (int z = 0; z < 8 ; z++) {
                    for (int j = 0; j < 8  - window+1; j++) {//window크기로 행을 조사할수있는 횟수
                        int u = 0;
                        for (int k = j; k < j + window; k++) {
                            tmp_stringarray[u] = strings[k][z];
                            u++;
                        }
                        tmp1_stringarray = reverse_string(tmp_stringarray);
                        if (Arrays.equals(tmp_stringarray,tmp1_stringarray)) {
                            count++;
                        }

                    }
            }


            // 문자를 거꿀로 돌라고  비교하는 로직을 만들어야겠구만


            sb.append("#" + (i + 1) + " " + count + " \n");



        }
        System.out.println(sb);

    }

    public static String [] reverse_string(String[] strings) {

        String[] strings_tmp = new String[strings.length];


        for (int i = 0; i < strings.length; i++) {
            strings_tmp[strings_tmp.length - i - 1] = strings[i];
        }

        return strings_tmp;

    }

}
