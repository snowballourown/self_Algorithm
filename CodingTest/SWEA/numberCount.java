package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class numberCount {
    public static void main(String[] args) throws IOException {

//
//        어느 고등학교에서 실시한 1000명의 수학 성적을 토대로 통계 자료를 만들려고 한다.
//
//        이때, 이 학교에서는 최빈수를 이용하여 학생들의 평균 수준을 짐작하는데, 여기서 최빈수는 특정 자료에서 가장 여러 번 나타나는 값을 의미한다.
//
//        다음과 같은 수 분포가 있으면,
//
//        10, 8, 7, 2, 2, 4, 8, 8, 8, 9, 5, 5, 3
//        최빈수는 8이 된다.
//        최빈수를 출력하는 프로그램을 작성하여라 (단, 최빈수가 여러 개 일 때에는 가장 큰 점수를 출력하라).


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        Integer TC = Integer.parseInt(br.readLine());



         for (int i = 0; i < TC; i++) {
            int serial = Integer.parseInt(br.readLine());
             int[] insert = new int[101];
             int [] number = new int [1000];


             StringTokenizer stn = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 1000; j++) {
                number[j] = Integer.parseInt(stn.nextToken());
            }


             for (Integer integer : number) {
                 insert[integer]++;
             }




             int maxCount = 0;
             int answer = 0;

             for (int score = 0; score <= 100; score++) {
                 if (maxCount <= insert[score]) {
                     maxCount = insert[score];
                     answer = score;
                 }
             }

             System.out.println("#" + serial + " " + answer);


        }
        



    }
}
