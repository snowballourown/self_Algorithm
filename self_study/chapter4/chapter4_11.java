package self_study.chapter4;

import java.io.*;
import java.util.Stack;

public class chapter4_11 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());


        Stack<Integer> stack = new Stack<>();
        int A[] = new int[n];

        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }


        int num = 1;
        for (int i = 0; i < n; i++) {
            if (A[i] >= num) {
                while (A[i] >= num) {
                    stack.push(num++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            }
            else {
               int s = stack.pop();
                if (s > A[i]) {
                    System.out.println("NO"); // ex) 큰숫자 스택에서 5를 빼지않는한 수열 3
                    // 5를빼는순간 순열은 망가지고 출력 불가능이 됨
                    return;
                }

                sb.append("-\n");


            }
        }


        System.out.println(sb);

    }
}
