package CodingTest.Programer_2.praticeProblem;

import java.util.ArrayDeque;
import java.util.Deque;

public class spinString {
    public int solution(String s) {
        int answer = 0;


        for (int i = 0; i < s.length(); i++) {
            Deque<Character> stack = new ArrayDeque<>();
            boolean valid = true;


            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);


                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) { // 닫는 녀석이 나왔는데 열린녀석이 없다? 그거는 오류임
                        valid = false;
                        break;
                    }

                    char open = stack.pop();

                    if ((c == ')' && open != '(') ||  // 해당하지않는 녀석이 왔다면 이배열은 오류
                            (c == ']' && open != '[') ||
                            (c == '}' && open != '{')
                    ) {
                        valid = false;
                        break;
                    }



                }

            }


            if (valid && stack.isEmpty()) {

            answer++;
            }
            s = s.substring(1) + s.charAt(0);
            
        }







        return answer;
    }

}
