package self_study.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class chapter5_32 {
    static int [] A;
    static int [] B;
    static int depth;
    static int N;



    public static void main(String[] args) throws IOException {

        // 데이터를 받고

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer stn = new StringTokenizer(br.readLine(), " ");


        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(stn.nextToken());
        }

        Arrays.sort(A);




        // 찾아야 할 숫자 갯수
        int M = Integer.parseInt(br.readLine());
       B = new int[M];

        stn = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(stn.nextToken());
        }


        for (int i : B) {
            System.out.println(BooleanSearch(0, N - 1, i));
        }
    }

    // 정리점 A에 있는걸 정리하는게 맞지 왜냐?
    // ㅈ

    //이진 함수받고 원하는 값을 찾아주기 일단 정렬 된 배열을 받아야함 그리고 원하느 숫자 ㄱ있는지 알려주고 리턴해주면될듯


    private static int BooleanSearch(int start,int end, int number) {



            int m = (start + end) / 2;


            if (start <= end) {
                if (A[m] == number) {// 해당숫자보다 큰지? 작은지 확인 하고 어디로 넘길것인지 확인히는거지 같으면
                    return 1;
                } else if (A[m] < number) {
                    return BooleanSearch(m + 1, end, number);
                } else {
                   return BooleanSearch(start, m - 1, number);
                }
            }

        return 0;

    }
}
