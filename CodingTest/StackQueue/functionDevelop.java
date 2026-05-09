package CodingTest.StackQueue;

import java.util.*;

public class functionDevelop {

    public int[] solution(int[] progresses, int[] speeds) {

        int[] days = new int[progresses.length];

        // 완료일까지 계산
        for (int i = 0; i < progresses.length; i++) {

            int remain = 100 - progresses[i]; // 진행했던거 뺴주고
            days[i] = remain / speeds[i];// 필요한 일수 계산
            if (remain % speeds[i] != 0)
            {
                days[i]++; // 잔여 일수 계산하는거임
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        int current = days[0]; // 필요일수 넣어놓음
        int count = 1;

        // 배포 묶기
        for (int i = 1; i < days.length; i++) {

            if (days[i] <= current) { // 현재보다 day가 작다면 count ++  바로 내보낼꺼니까
                count++;
            } else {
                result.add(count);  // 아니라면 지금 있는 거 count 꺼내고 남은 녀석을 count로 해놓을거니까
                current = days[i];  // 다음 녀석을 현재로 꺼내놓은거임
                count = 1;          // 다시 처음부터 count
                                    // 초기값 다시 설정
            }
        }
        // 새그룹이 시작됐는데 넣어주는애가 없어 or 새그룹을 시작안했는데도  넣어줄녀석이 없어
        result.add(count);

        return result.stream().mapToInt(i -> i).toArray();
    }
}