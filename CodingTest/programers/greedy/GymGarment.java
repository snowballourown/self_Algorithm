package CodingTest.programers.greedy;

import java.util.ArrayList;

public class GymGarment {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] clothes = new int[n + 2];

        for (int i = 0; i <= n; i++) {
            clothes[i] =1;
        }           // 0 - n 1로 초기화시킴

        for (int i : lost) { // 옷없는 애들 짜름
            clothes[i]--; // clothes
        }

        for (int i : reserve) { // 여유분이있는 애들을 더하기
            clothes[i]++;
        }

        for (int i = 1; i <= n; i++) { // 옷들을 모두 확인하기
            if (clothes[i] == 0) {  // 옷이 아예없는 애들
                if (clothes[i - 1] == 2) { // 옆자리 확인
                    clothes[i - 1]--;
                    clothes[i]++;
                } else if (clothes[i + 1] == 2) { // 옆자리확인
                    clothes[i + 1]--;
                    clothes[i]++;
                }
            }
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if (clothes[i] >= 1) {
                answer++;
            }
        }

        return answer;
    }
}