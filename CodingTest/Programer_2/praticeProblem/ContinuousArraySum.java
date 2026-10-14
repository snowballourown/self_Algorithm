package CodingTest.Programer_2.praticeProblem;

import java.util.HashSet;
import java.util.Set;

public class ContinuousArraySum {

    public int solution(int[] elements) {
        int answer = 0;



        //set으로 관리하고
        // 지금 구하는게 서로다른 합의 경우의수
        // 원으로 생각하고
        int sum =0;
        Set<Integer> set = new HashSet<>();




        for (int j = 1; j <= elements.length; j++) { // 크기를 정하는 녀석
            for (int k = 0; k < elements.length; k++) { // 이동하는녀석

                 sum = 0;
                for (int i = k; i < k+j; i++) {
                    sum += elements[i % elements.length];
                }
                set.add(sum);
            }
        }





        return set.size();
    }

}
