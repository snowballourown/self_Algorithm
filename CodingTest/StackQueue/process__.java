package CodingTest.StackQueue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class process__ {


    class Node
    {
        int index;
        int priority;

        public Node(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }

    public int solution(int[] priorities, int location)
    {
        int answer = 0;
        //실행대기 큐(Queue)에서 대기중인 프로세스 하나를 꺼냅니다 .
        //큐에 대기중인 프로세스 중 우선순위가 더높은 프로세스가 있다면 방금 꺼낸 프로세스를 다시 큐에 넣습니다.
        //만약 그런 프로세스가 없다면 방금 꺼낸 프로세스를 실행합니다.
        //한번 실행한 프로세스는 다시 큐에 넣지 않고 그대로 종료됩니다.


        //hash map으로 index를 부여해서 우선순위를 부여함
        // 그리고 queue에 다 넣어버려
        // 하나씩 꺼내
        // 1. 이녀석이 queue에 남아있는 애들중에 가장 큰가?
        // 2. 아니면 뒤로 다시 넣음
        // 3. 가장 큰녀석이 맞음 -> 내보냄 but -> location = index 이면 종료하고 count++했던거 내보냄


        Queue<Node> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Node(i, priorities[i]));
        }

        //최대값을 꺼내는용으로 하나의 함수를 생성하자
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.priority >= Max(queue)) {
                count++;
                if (node.index == location) {
                    return count;
                }
            }
            else { // 우선순위갖다면 먼저 들어온애들이 나가게하는게 맞겠지 그럼 등로?
                queue.add(node);
            }
        }

        return answer;
    }


    int Max(Queue<Node> arrayList) {
        int max = 0;
        for (Node node : arrayList) {
            if (max < node.priority) {
                max = node.priority;
            }
        }

        return max;
    }
}
