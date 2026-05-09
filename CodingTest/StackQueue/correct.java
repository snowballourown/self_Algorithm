package CodingTest.StackQueue;

import java.util.Stack;

public class correct {
    boolean solution(String s) {

        boolean answer = true;
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cnt +=1;
            } else if (s.charAt(i) == ')') {
                cnt -= 1;
            }

            if (cnt < 0) {
                break;
            }
        }


        if (cnt != 0) {
            answer = false;
        }

        return answer;
    }
}
