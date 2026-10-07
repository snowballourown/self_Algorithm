package CodingTest.Programer_2.praticeProblem;
class Solution {
    public int solution(String s) {

        char[] stack = new char[s.length()];

        int top = -1;


        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (top >= 0 && stack[top] == c) {
                top--;
            } else {
                stack[++top] = c;
            }



        }


        return top == -1 ? 1 : 0;





    }

}
