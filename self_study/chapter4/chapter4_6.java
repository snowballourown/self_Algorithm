package self_study.chapter4;

import java.io.*;

public class chapter4_6{
    public static void main(String[] args) throws IOException {

         // 일단 최종합이 될건지
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int num[] = new int[n];
        int count = 1;  // 자기자신의 합의 경우의수
        int startpoint=0;
        int endpoint =1;
        int sum = 3;


        for (int i = 0; i < n; i++) {
             num[i] = i+1;
        }

        while (startpoint < endpoint) {
            //sum의 합이 목표치 보다 작을경우 endpoint를 업

            if (sum < n) {
                endpoint++;
                sum += num[endpoint];
            } else if (sum >= n) {
                if (sum == n) {
                    count++;
                }
                sum -= num[startpoint];
                startpoint++;
            }
            //sum의 합이 목표치 보다 클경우 startpoint를 업
            //sum의 합이 목표치랑 같을경우 startpoint를 업 -> count++하고

        }


        bw.write(String.valueOf(count));
        bw.flush();
    }
}
