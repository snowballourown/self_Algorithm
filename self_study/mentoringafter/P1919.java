package self_study.mentoringafter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1919 {
    public static void main(String[] args) throws IOException {

        
        // 두문자열 비교해서 서로 하나씩 제거하면서 문자열들을 비교해야겠다
        // 2초 -> 이중 for문 까지는 가능
        // 배열을  2개 다 받고
        // 겹치는거 스펠링만 체크하면되는거아니야>? 갯수나?
        // 나머지는 다제거해도되고?
        // 그 제거한 갯수를 출력하는거고
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] A = br.readLine().split("");
        String[] B = br.readLine().split("");

        int num[][] = new int[2][26];


        for (String s : A) {
            num[0][s.charAt(0) - 'a']++;
        }


        for (String s : B) {
            num[1][s.charAt(0) - 'a']++;
        }

int cnt = 0;


        for (int i = 0; i < 26; i++) {
            cnt += Math.abs(num[0][i] - num[1][i]);
        }


        System.out.println(cnt);

    }
}
