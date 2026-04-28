
package CodingTest;

class Kakaolevel_1_2025 {

    int gcd(int a, int b) {  // 두 수를 동시에 나눌 수 있는 가장 큰 수  //최대 공약수찾기
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    int lcm(int a, int b) { //두 주기가 다시 동시에 맞는 최소 시간 = 최소 공배수
        return a / gcd(a, b) * b;  //  : a / gcd =>   a의 공약수를 뺸 값을 구함   b(b의 서로소   * 최소공약수 )
    }


    int solution(int[][] signals) {
        int n = signals.length;

        int lcmVal = 1;
        for (int i = 0; i < n; i++) {
            int cycle = signals[i][0] + signals[i][1] + signals[i][2];
            lcmVal = lcm(lcmVal, cycle); // 계속 여기에 저장되면서 다음값을 받으면서 같은 최소공배수값들을 구함
        }

        for (int t = 1; t <= lcmVal; t++) { // 최소공배수값들을 구해서 그값만 딱하고 빠짐
            boolean allYellow = true;

            for (int i = 0; i < n; i++) {
                int G = signals[i][0];
                int Y = signals[i][1];
                int R = signals[i][2];

                int cycle = G + Y + R; // 해당 값의 사이클을 저장
                int time = (t - 1) % cycle + 1; //사이클 초기화 시켜주는과정


                if (!(time > G && time <= G + Y)) {
                    allYellow = false;
                    break;
                }

            }

            if (allYellow) return t;
        }

        return -1;

    }
}
    