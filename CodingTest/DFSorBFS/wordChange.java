package CodingTest.DFSorBFS;

import java.util.LinkedList;
import java.util.Queue;

public class wordChange {
    //한번에 word 바꿈 그러면 워드가 하나씩 바꾸는데
    //워드리스트에 있어야함
    //BFS로 바꿔야함  최적의 루틴으로 가야하기에

    class Solution {

        public int solution(String begin, String target, String[] words) {
            // target이 없으면 불가능
            boolean exists = false;
            for (String w : words)   // target 존재여부 확인
            {
                if (w.equals(target))
                {
                    exists = true;
                    break;
                }
            }

            if (!exists) return 0;
            Queue<Node> queue = new LinkedList<>();
            boolean[] visited = new boolean[words.length];
            queue.add(new Node(begin, 0));

            while (!queue.isEmpty()) {
                Node current = queue.poll();

                if (current.word.equals(target)) { // 단어가 같은지확인하고 step을 아마 교환횟수인것
                    return current.step;
                }

                for (int i = 0; i < words.length; i++) {
                    if (!visited[i] && diffOne(current.word, words[i])) { //방문한거 추적해서 그다음 또한번비교하면되네 미쳤다잇
                        visited[i] = true;
                        queue.add(new Node(words[i], current.step + 1));
                    }
                }
            }

            return 0;
        }

        // 한 글자 차이인지 확인
        private boolean diffOne(String a, String b) {
            int count = 0;

            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    count++;
                }
            }

            return count == 1;
        }

        // BFS용 클래스
        class Node {
            String word;
            int step;

            Node(String word, int step) {
                this.word = word;
                this.step = step;
            }
        }
    }
}
