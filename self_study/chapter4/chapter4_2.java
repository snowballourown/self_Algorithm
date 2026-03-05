package self_study.chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class chapter4_2 {
    public static void main(String[] args) throws IOException {

        // 입력 받을 숫자 입력
        // 갯수만큼 숫자입력

        // 최고 점수 찾음
        // 최고 점수로 모두 다나눠버림
        // 수자들만큼 나눔 평균구하고 출력

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer s = Integer.parseInt(br.readLine());

        double[] nums = new double[s];


        StringTokenizer stn = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < s; i++) {
            nums[i] = Integer.parseInt(stn.nextToken());
        }
        double max = 0;
        for (int j = 0; j < s; j++) {
            if (max <= nums[j]) {
                max = nums[j];
            }
        }

        for (int i = 0; i < s; i++) {
            nums[i] = (nums[i] / max) * 100;
        }

        double sum = 0;
        for (double num : nums) {
            sum += num;
        }

        System.out.println( sum / s);




    }
}
