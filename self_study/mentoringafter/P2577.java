package self_study.mentoringafter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2577 {
    public static void main(String[] args) throws IOException {
// 숫자받고

        //배열 10개 선언한다음에
        //숫자 를 string 바꾸고 -> char로 바꿔서
        // charat써서 숫자 0번 아스키코드 빼면서 숫자 배열에 넣기 시작
        // 나머지 출력하면 끝


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int[] A = new int[3];
        int[] B = new int[10];
        for (int i = 0; i < 3; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        int sum =1;
        for (int i = 0; i < 3; i++) {
            sum = sum *A[i];
        }
        String number =  sum + "";

        for (int i = 0; i < number.length(); i++) {
            B[number.charAt(i) - 48]++;
        }


        for (int i : B) {
            System.out.println(i);
        }




    }
}
