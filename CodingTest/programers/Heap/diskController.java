package CodingTest.programers.Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class diskController {

    class Node{
        int arrivalTime;
        int doingTime;
        int index;

        public Node(int index, int arrivalTime, int doingTime) {
            this.arrivalTime = arrivalTime;
            this.doingTime = doingTime;
            this.index = index;
        }


    }
    public int solution(int[][] jobs) {
        int answer = 0;

        /*

        * 가장 우선순위가 높은 작업을 대기 큐에서 꺼내서 하드디스크에 그 작업을 시킵니다.
        * 작업우선순위로 정렬를 들어올떄마다 해줘야함
        * but한 번실행한녀석은 중간에 안멈춤
        * 작업의 소요시간이 짧은 것,
        * 작업의 요청 시각이 빠른 것,
        * 작업의 번호가 작은 것
        *
        * */
        int sumTime =0;
        for (int i = 0; i < jobs.length; i++) {
            sumTime += jobs[i][1];
        } // index, 도착시간, 소요시간

        boolean [] visited = new boolean[jobs.length];
        ArrayList<Integer> result = new ArrayList<>();
        // 이렇게 가면 안되고 음
        int currentTime = 0;
        while (result.size() != jobs.length) { // 시점기준에서 비교하기위해서 이렇게 하는거임
             //리스트중에 가능진입가능한녀석있는지확인
            ArrayList<Node> arrayList1 = new ArrayList<>();
            Node startNode = null;
            for (int i = 0; i < jobs.length; i++) {
                if (currentTime >= jobs[i][0]) { // 현재도착한 애들중에 가능한녀석을 list에 삽입
                    if (visited[i]) continue;
                    arrayList1.add(new Node((i), jobs[i][0], jobs[i][1]));
                }

                // 낮은 녀석을 찾은다음 list 만약 2개이상있을수도있으니  비교 진행시간이 더 작은녀석을 찾아 먼저 실행
                // 만약 근데 진행시간이같다? 그럼 index순으로
            }
            if (arrayList1.size() == 0) { //해당하는 녀석이 없을경우
                currentTime++;
                continue;
            }

            if (arrayList1.size() >= 2) { // 시작할 노드 정하는 로직
                int min = Integer.MAX_VALUE;
                for (Node node : arrayList1) {
                    if (min > node.doingTime) { // 시작할

                        min = Math.min(min, node.doingTime);
                        startNode = node;
                    } else if (min == node.doingTime) { // 도착시간이 빠른것
                        if (startNode.arrivalTime > node.arrivalTime) {
                            startNode = node;
                        } else if (startNode.arrivalTime == node.arrivalTime) { // 인덱스가 더적은것
                            if (startNode.index > node.index) {
                                startNode = node;
                            }
                        }
                    }
                }
            } else {
                startNode = arrayList1.get(0);
            }



            currentTime += startNode.doingTime; // 현재타임
            visited[startNode.index] =true;
            result.add( currentTime- startNode.arrivalTime); // 도착시간 - (현재시간 + 작업한시간 = 끝난시간)

        }

        int sum =0;
        for (Integer integer : result) {
            sum += integer;
        }

         answer = sum / result.size();




        return answer;
    }
}
