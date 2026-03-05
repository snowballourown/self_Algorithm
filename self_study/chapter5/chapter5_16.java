package self_study.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class chapter5_16 {
    public static void main(String[] args) throws IOException {

        // 일단 데이터를 받고 나서
        // 데이터받을떄 데이터 받은순서데로 index값 을 입력해
        // 데이터를 새로운 기준으로 정렬하고나서 다시 정렬 움직인만큼을 구해 가장많이 움직인 녀석 구헤버리면
        // 정렬된 직후 의 횟수를 구할수있음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        mData[] A = new mData[N];
        for (int i = 0; i < N; i++) {
            A[i].value = Integer.parseInt(br.readLine());
            A[i].index = i+1;
        }
        Arrays.sort(A);
        int max = 0;

        for (int i = 1; i <= N; i++) {
            if ((A[i].index - i) > max) { //여기서 i은 현재위치를 알려주는녀석이고 index
                max = A[i].index - i;
            }
        }
        System.out.println(max+1);











    }


    public class mData implements Comparable<mData> {
        int index;
        int value;


        @Override
        public int compareTo(mData o) {
            return this.value - o.value;
        }


    }
}






