package CodingTest.StackQueue;

import java.util.LinkedList;
import java.util.Queue;

public class BrigeTruck {


    public int solution(int bridge_length, int weight, int[] truck_weights) {


        Queue<Integer> bridge = new LinkedList<>();

        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }
        int time = 0;
        int i= 0;
        int sum = 0;

        while (!bridge.isEmpty()) {

            time++;
            sum -= bridge.poll();
            if (i < truck_weights.length) {

              if (sum + truck_weights[i] <= weight) {

                sum += truck_weights[i];
                bridge.add(truck_weights[i]);
                i++;

            } else {
                bridge.add(0);
                }
            }
        }


        return time;
    }


}
