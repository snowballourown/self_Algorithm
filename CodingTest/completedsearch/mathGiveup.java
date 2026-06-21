package CodingTest.completedsearch;

import java.util.ArrayList;

public class mathGiveup {

    // 찍는 방식을 파악해야
    // 답이랑 비교했을 떄 몇개 맞았는지 알수있음


    // -> 각자의 방식으로 정답이 맞는지를 확인
    // -> 자신의 정답개수파악용
    // -> 자신의 index

    class Node {
    int index;
    int result;
    int [] MyAnswer;
        public Node(int index, int [] myAnswer) {
            this.index = index;
            this.MyAnswer = myAnswer;
        }
    }

    public int[] solution(int[] answers) {
        int[] answer = {};

        Node node_1 = new Node(1, new int[]{1, 2, 3, 4, 5});
        Node node_2 = new Node(2, new int[]{2, 1, 2, 3, 2, 4, 2, 5});
        Node node_3 = new Node(3, new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5});




        int i_1 = 0; // 배열 for같은 존재
        int i_2 = 0;
        int i_3 = 0;
        int count = 0;
        while (true) {
            if (i_1 == node_1.MyAnswer.length - 1) { //배열이 무족할수도있을것같아서 따로 index를 반복하게했음
                i_1 = 0;
            }
            if (i_2 == node_2.MyAnswer.length - 1) {
                i_2 =0;
            }
            if (i_3 == node_3.MyAnswer.length - 1) {
                i_3 =0;
            }
            // 정답 비교 몇개 맞았는지 비교세우기
            if (node_1.MyAnswer[i_1] == answers[count]) {
                node_1.result++;
            }
            if (node_2.MyAnswer[i_2] == answers[count]) {
                node_2.result++;

            }
            if (node_3.MyAnswer[i_3] == answers[count]) {
                node_3.result++;
            }
            count ++; //전체 answer 갯수만큼 더하기

            i_1++;
            i_2++;
            i_3++;
            if (count == answers.length) {
                break;
            }
        }

        ArrayList<Node> arrayList = new ArrayList<>();
        arrayList.add(node_1);
        arrayList.add(node_2);
        arrayList.add(node_3);


        arrayList.sort((a, b) ->
                a.result - b.result );

        ArrayList<Integer> integers = new ArrayList<>();
        int max = 0;

        for (Node node : arrayList) {
            if (max <= node.result) {
                max = node.result;
            }
        }

        for (Node node : arrayList) {
            if (max == node.result) {
                integers.add(node.index);
            }
        }

    return integers.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

}
