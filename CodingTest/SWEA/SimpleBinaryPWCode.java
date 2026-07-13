package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SimpleBinaryPWCode {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < TC; i++) {
            // 이진 코드를 추출해야함
            StringTokenizer stn = new StringTokenizer(br.readLine(), " ");

            int N = Integer.parseInt(stn.nextToken()); //새로
            int M = Integer.parseInt(stn.nextToken());

            int[][] number = new int[N][M];

            int count= 0;
            for (int j = 0; j < N; j++) {
                String s = br.readLine();
                int sum =0;
                for (int k = 0; k < M; k++) {
                     number[j][k] = s.charAt(k) - '0';
                     sum += number[j][k];
                }
                if (sum > 0) { // 더이상 데이터 넣을 필요없음 여기서 그행 추출해서 받아서
                    count = j;
                } // 행찾음
            }

            int row = count;
            int colum = 0;
            // 코드들을 보면 마지막 숫자가 항상 1로 끝나 그럼 마지막 1를 기준으로 56개의 코드가있겠지 그걸를 뽑아내면 될듯함
            for (int j = M-1; j >= 0; j--) {// M 70부터야
                if (number[count][j] == 1) {
                    colum = j - 55 ;
                    break;
                }
            }
            int a = 0;
            int[] binaryNumber = new int[56];
            for (int j = colum; j <= colum+55; j++) { // 7자리 문자열을 2진수  1~ 56
                binaryNumber[a] = number[count][j];
                a++;
            }

            int[] TEN_number = new int[8];


            int[][] binaryNumber_D = new int[8][7];

            for (int j = 0; j < binaryNumber.length; j++) {
                binaryNumber_D[j/7][j%7] = binaryNumber[j];
            }

            int[] decodingNumber = new int[8];
            for (int j = 0; j < binaryNumber_D.length; j++) {
                String s = "";
                for (int k = 0; k < binaryNumber_D[0].length; k++) {
                    s += binaryNumber_D[j][k];
                }

                if (s.equals("0001101")) {
                    decodingNumber[j] = 0;
                }
                if (s.equals("0011001")) {
                    decodingNumber[j] = 1;
                }
                if (s.equals("0010011")) {
                    decodingNumber[j] = 2;
                }
                if (s.equals("0111101")) {
                    decodingNumber[j] = 3;
                }
                if (s.equals("0100011")) {
                    decodingNumber[j] = 4;
                }
                if (s.equals("0110001")) {
                    decodingNumber[j] = 5;
                }
                if (s.equals("0101111")) {
                    decodingNumber[j] = 6;
                }
                if (s.equals("0111011")) {
                    decodingNumber[j] = 7;
                }
                if (s.equals("0110111")) {
                    decodingNumber[j] = 8;
                }
                if (s.equals("0001011")) {
                    decodingNumber[j] = 9;
                }
            }
            // 그걸 추출해서 7개씩 나누고

            int sum_2= 0;
            int sum_1 = 0;
            for (int j = 0; j < decodingNumber.length; j++) {
                if (j % 2 == 0) { //짝수
                    sum_2 += decodingNumber[j];
                } else { // 홀수
                    sum_1 += decodingNumber[j];
                }
            }

            sum_2 = sum_2 * 3;
            int result_sum= 0;
            if ((sum_2 + sum_1) % 10 == 0) {
                for (int i1 : decodingNumber) {
                    result_sum += i1;
                }
                sb.append("#" + (i + 1) + " " + result_sum + "\n");
            } else {
                sb.append("#" + (i + 1) + " " + 0 + "\n");

            }





            // 그리고 나서 올바른 암호인지 판별
            // 그걸로 올바른 코드인지 판별
            //
            // 올바른 코드라면 ->  모든값을 합하면됨
        }
        System.out.println(sb);
    }
}
