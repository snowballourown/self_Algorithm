package CodingTest.Programer_2.DP;

public class jumpAndDash {
    public int solution(int n) {
        int ans = 0;



        //
        // 5 = 1 + 순간이동 +순간이동 +



        // 6 = 1+ 순간이동 + 1 + 순간이동
        while (n !go= 0) {
            if (n % 2 == 0) { //
                n = n/2;

            } else if (n % 2 == 1) {
                n = (n -1  / 2);
                ans++;
            }
        }

        return ans;
    }
}
