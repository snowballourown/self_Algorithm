package CodingTest.DFSorBFS;

import java.util.LinkedList;
import java.util.Queue;

public class wordChangeretry {
    //한번에 word 바꿈 그러면 워드가 하나씩 바꾸는데
    //워드리스트에 있어야함
    //BFS로 바꿔야함  최적의 루틴으로 가야하기에

    class Solution {
        public int solution(String begin, String target, String[] words) {
            int answer = 0;

            boolean exisited = false;
            for (String word : words) {
                if (target.equals(word)) {
                    exisited = true;
                    break;}
            }
            if (!exisited) return 0;

            boolean visited[] = new boolean[words.length];
            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(begin, 0));


            while (!queue.isEmpty()) {
                Node current = queue.poll();
                if (current.word.equals(target)) {
                    return current.step;
                }
                for (int i = 0; i < words.length; i++) {
                    if (!visited[i]&&diffOne(current.word, words[i])) {
                        visited[i] = true;
                        queue.add(new Node(words[i], current.step + 1));
                    }
                }
            }

            return 0;

        }


        boolean diffOne(String a, String b) {
            int count =0;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    count++;
                }
            }

            return count == 1;
        }


        class Node {
            String word;
            int step;

            public Node(String word, int step) {
                this.word = word;
                this.step = step;
            }
        }



    }





}
