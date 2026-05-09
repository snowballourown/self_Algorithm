package CodingTest.StackQueue;

import java.util.LinkedList;
import java.util.Queue;

public class BrigeTruck {


    public int solution(int bridge_length, int weight, int[] truck_weights) {        // 트럭여러대가 강을 가로지르는 일차선 다리르 정해진 순으로 건너려합니다.
        Queue<Integer> bridge = new LinkedList<>();

        // 다리 길이만큼 0 넣기
        // 처음에는 다리 위에 아무 트럭도 없다는 뜻
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }

        int time = 0; // 총 시간
        int sum = 0;  // 현재 다리 위 트럭 무게 합
        int i = 0;    // 다음에 들어올 트럭 index

            // bridge가 빌 때까지 반복
            // 마지막 트럭까지 완전히 빠져나갈 때 종료
        while (!bridge.isEmpty()) {

            time++; // 1초 증가

            // 다리 맨 앞 트럭 제거
            // 다리 한 칸 이동했다고 생각하면 됨
            // 빠져나간 트럭 무게도 총합에서 제거
            sum -= bridge.poll();

            // 아직 대기 트럭이 남아있다면
            if (i < truck_weights.length) {

                // 다음 트럭 올려도 무게 제한 안 넘는지 확인
                if (sum + truck_weights[i] <= weight) {

                    // 다리에 트럭 올림
                    bridge.add(truck_weights[i]);
                    // 현재 다리 무게 증가
                    sum += truck_weights[i];
                    // 다음 트럭으로 이동
                    i++;
                } else {

                    // 무게 초과라 못 올라감
                    // 대신 빈칸(0) 넣어서 시간만 흐르게 함
                    bridge.add(0);
                }
            }
        }

        return time;
    }


}
