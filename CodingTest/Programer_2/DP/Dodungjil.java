package CodingTest.Programer_2.DP;

public class Dodungjil{
    public int solution(int[] money) {
        int answer = 0;
        int  n = money.length;

        return Math.max(rub(money, 0, n - 2), rub(money, 1, n - 1));
    }

    private int rub(int[] money, int start, int end) {

        int pre1 = 0 ;
        int pre2 = 0 ;

        for (int i = start; i <= end; i++) {

            int current = Math.max(pre1, pre2 + money[i]);
            pre2 = pre1;
            pre1 = current;


        }


        return pre1;
    }
}


