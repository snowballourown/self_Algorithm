package self_study.mentoringafter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P3273 {

    public static void main(String[] args) throws IOException {
        //배열을 저장해
        // 그배열을 정렬하고 나서
        // two point이용해서  n번이 이동하면서 세개하는게 목표


        // start , end를 구현해서 end보다 start가 크면 종료 되게 하는거임
        // start가 앞으로가는경우는 합이 목표값보다 작거나 같을경우
        // end가 뒤로오는경우는 합이 목표값보다 클경우
        // 작거나 같을 경우에 count를 넣는거지

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        int[] num = new int[N];

        StringTokenizer stn = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(stn.nextToken());
        }

        int goal = Integer.parseInt(br.readLine());


        int start = 0;
        int end = N - 1;

        Arrays.sort(num);
        int count =0;
        while (start < end) {
            int sum = num[start] + num[end];

            if (sum > goal) {
                end--;
            }
            else {
                start++;
                if (sum == goal) {
                    count++;
                }
            }
        }


        System.out.println(count);

    }
}
