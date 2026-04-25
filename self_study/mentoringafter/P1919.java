package self_study.mentoringafter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1919 {
    public static void main(String[] args) throws IOException {
        // 각 배열들을 받고 아스키 코드에 맞게 저장
        // 배열 2개를 받아서 -를 하셈 나오는게 2개 각자나오거나 업생
        // 결과값이 0은 없으니까 안해도되고,
        // 1 같은 숫자들이나오면 한개밖에 안나온거니까 신경안써도 됨
        // 0은 ㄱㅊ

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String[] a = br.readLine().split("");
        String[] b = br.readLine().split("");

        int [][] num1 = new int[2][26];


        for (int i = 0; i < a.length; i++) {
            num1[0][a[i].charAt(0) - 'a']++;
        }
        for (int i = 0; i < b.length; i++) {
            num1[1][b[i].charAt(0) - 'a']++;
        }

        int cnt = 0 ;
            for (int j = 0; j < 26; j++) {
                cnt += Math.abs(num1[0][j] - num1[1][j]);
            }

        System.out.println(cnt);




    }
}
