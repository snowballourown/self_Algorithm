package CodingTest;

public class Kakaolevel_01_2025_retry {

        // AXB = 최대공약수 x 최소공배수
    int GCD(int a, int b) { // 최대 공약수
        while (b == 0) {
            int tmp =  a % b;
            a=b;
            b= tmp;
        }
        return a;
    }


    int lcm(int a, int b) {
        return a / GCD(a, b) * b;
    }

    int solution(int signals[][]) {


        int lcmInt = 1;
        for (int i = 0; i < signals.length; i++) {
            int cycle = signals[i][0] + signals[i][1] + signals[i][2];
            lcmInt = lcm(lcmInt, cycle);
        }

        for (int t = 1; t <= lcmInt; t++)
        {
            boolean allowedYellow = true;

            for (int i = 0; i < signals.length; i++) {
                int G = signals[i][0];
                int Y = signals[i][1];
                int R = signals[i][2];

                int cycle = G + Y + R;

                int time = (t-1) % cycle +1;

                if (!(G < time && time <= G + Y)) {
                    allowedYellow = false;
                    break;
                }
            }
            if (allowedYellow) return t;
        }


        return -1;

        //최소공배수를 구해서 얼마나 반복해야 되는지을 알수있음, 주기가 같아지는시기




    }
}
