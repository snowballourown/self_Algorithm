//package week8;
//
//import java.io.*;
//import java.util.Arrays;
//
//public class findnumber {
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int n = Integer.parseInt(br.readLine());
//        String list[] = br.readLine().split(" ");
//        int A[] = new int[n];
//        for(int i=0;i<n;i++){
//            A[i] = Integer.parseInt(list[i]);
//
//        }
//        int m = Integer.parseInt(br.readLine());
//
//        list = br.readLine().split(" ");
//        int B[] = new int[m];
//        for(int i =0;i<m;i++){
//            B[i] = Integer.parseInt(list[i]);
//
//        }
//
//        Arrays.sort(A);
//
//        //A : 1 2 3 4 5
//        //B : 3 5 7 9 1 10
//        //A랑 M값이랑 이진탐색 하자!
//        //0번 인덱스
//        //길이 -1 인덱스
//        // 중간값 인덱스 = (길이 - 1) /2
//        //이진탐색 반복문(
//
//
//
//
//
//
//        int x = 0;
//        int y = n-1;
//        int mid = (x+y)/2;
//
//
//        for(int b : B){
//            System.out.println(b);
//            while(x<y){
//                if(A[mid] == b){
//                    System.out.println(1);
//                    break;
//                } else if(A[mid] < b){
//                    x = mid;
//                    mid = (x+y)/2;
//
//                } else {
//                    y = mid;
//                    mid = (x+y)/2;
//                    System.out.println(b);
//                }
//            }
//            if(x<y){
//                System.out.println(0);
//            }
//        }
//
//
//    }
//}
