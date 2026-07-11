package CodingTest.programers.greedy;

public class JoyStick {
        public int solution(String name) {
            int answer = 0;
            int move = name.length()-1;
            int len = name.length();

            for (int i = 0; i <= name.length(); i++) { // 여기서 이미 A지점도 계산을 한다는거지

                int right = name.charAt(i) - 'A';
                int left = 'Z' - name.charAt(i) + 1;

                answer += Math.min(right, left);

                int next = i + 1;

                while (next < len && name.charAt(next) == 'A') {  //연속된 구간을 찾는거임
                    next++;
                }

                int goRightThenLeft = i *2 + len - next;  // 오른쪽으로 쭉 갔다가 다시와서 왼쪽으로 가는경우의수 0 -> i -> 0 -> next
                int goLeftThenRight = (len - next) * 2 + i; //  0-> next -> 0 -> i 로가야하는데

                // 연속된 A구간들중 가장 큰 구간만 뛰어넘음
                // 모든 A를 뛰어 넘는게아님



                move = Math.min(move, Math.min(goRightThenLeft, goLeftThenRight));
            }

            return answer + move;
        }
}
