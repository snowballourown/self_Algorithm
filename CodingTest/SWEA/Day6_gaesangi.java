package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Day6_gaesangi {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<String> stack_number = new Stack<>();
        Stack<String> var = new Stack<>();


        int TC =10;
        for (int i = 0; i < TC; i++) {

            int size = Integer.parseInt(br.readLine());
            String[] chars = new String[size];


            String s = br.readLine(); //

            for (int j = 0; j < size; j++) {
                chars[j] = s.charAt(j)+"";
            }

            for (String a : chars) { //
                if (a.equals("(")) {
                    var.push(a);
                } else if (a.equals("*")) {
                    var.push("*");
                } else if (a.equals("+")) {
                    while (!var.empty() && var.peek().equals("*")) {
                        var.pop();
                        int w1 = Integer.parseInt(stack_number.pop());
                        int w2 = Integer.parseInt(stack_number.pop());
                        stack_number.push(String.valueOf(w1 * w2));
                    }
                    var.push("+");
                } else if (a.equals(")")) {
                    while (!var.peek().equals("(")) {
                        String op = var.pop();
                        int w1 = Integer.parseInt(stack_number.pop());
                        int w2 = Integer.parseInt(stack_number.pop());

                        if (op.equals("+")) {
                            stack_number.push(String.valueOf(w1 + w2));
                        } else {
                            stack_number.push(String.valueOf(w1 * w2));
                        }
                    }
                    var.pop(); // "(" 제거
                } else {
                    stack_number.push(a); // 진짜 숫자만 여기로 옴
                }



            }


            int answer = Integer.parseInt(stack_number.pop());


            sb.append("#" + (i + 1) + " " + answer + "\n");




        }

        System.out.println(sb);

    }
}
