package week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class splitstudy {

    public static void main(String[] args) {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //1.직접 String "1","2","3" 배열 만들기

        //2.split을 이용하여 안녕하세요를 한글자씩 잘라 배열로 만들기
        String str = "안녕하세요";
        String[] strings = str.split("");
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }


        //3. 그 후에 한 글자씩 출력하기

    }
}
