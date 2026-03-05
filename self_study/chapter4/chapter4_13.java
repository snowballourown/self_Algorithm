package self_study.chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class chapter4_13 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= number; i++) {
            queue.add(i);
        }

        int count = 0;
        while (queue.size() > 1 ) {
             count++;
            if (count % 2== 1)
            {  queue.poll(); }
            else
            {
                queue.add( queue.poll());

            }
        }


        System.out.println(queue.poll());

    }
}
