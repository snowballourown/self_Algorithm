package CodingTest.programers.StackQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class refunctionDevelop {

    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        ArrayList<Integer> result = new ArrayList<>(); //result로 받아서 넘기는것
        Queue<Integer> queue = new LinkedList<>();


        for (int i = 0; i < progresses.length; i++) {
            double diff = 100 - progresses[i];
            double cost;
            cost = diff / speeds[i];
            int cost_1 =(int) diff / speeds[i];
            if (cost != cost_1) {
                cost_1++;
            }


            queue.add(cost_1); // 계산한 비용들 체크


        }// 비용을 여기다 넣어버리고

        int count = 1;
        int max = 0 ;
        int path = 0;
        while (!queue.isEmpty()) {
           int  i = queue.poll();
            path++;
            if (max < i) {
                if (path != 1) { // 처음꺼는 이렇게 제거
                    result.add(count);
                }
                max = i;
                count = 1;
                continue;
            }
            count++;
        }


            result.add(count); // 마지막남은애들 후처리까지




        return result.stream().mapToInt(i -> i).toArray();
    }

}
