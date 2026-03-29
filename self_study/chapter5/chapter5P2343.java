package self_study.chapter5;

import java.util.Scanner;

public class chapter5P2343 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N];


        int start =  0;
        int end =  0;

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt(); // 여기서 레슨 시간들을 다 받음
            if (start < A[i]) start = A[i];  // 가장 큰 수를 받은다음  처음 값으로 쓸려고함
            end = end + A[i]; //  모든 값들의 총합 구할려고하는것임
             }
/// / 값 설정함
        while (start <= end) {
            int middle = (start + end) / 2; // 중앙값을 구함
            int sum = 0 ;
            int count = 0;

            for (int i = 0; i < N; i++) {
                if (sum + A[i] > middle) { // 중앙값보다 커지면 더하는걸 멈추고 버킷을 새로추가
                    count++;
                    sum =0 ;
                }
                sum = sum + A[i]; //하나씩 더해가면서 중앙값을 넘는지 안넘는지 판단
            }
            if (sum != 0) {  // 나머지의 합이 middle 보다 작지만 버킷에 필요하기에 +1
                count ++;       }
            if (count > M) { // M 이라는건 원하는 갯 수 보다 더 count를 했다는거임
                start = middle +1;
            } //  원하는 갯수보다 count를 덜했다는 거임
            else end = middle -1; //  이과정이  절반을 나눈거에다가 -1 해주는거임 그래서  / 이진탐색처럼 되는거지
        }
        System.out.println(start);
    }
}
