package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GAME369 {
    public static void main(String[] args) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());


        for (int i = 1; i <= n; i++) {

            String s = i + "";

            char[] array = s.toCharArray();
            //string 으로 쪼갠다음에 3,6,9 나오는 것에서 또 몇번 쳐야하는지까지 찾아야겠네?

            if (s.contains("3") || s.contains("6") || s.contains("9")) {
                // 여기서 3, 6,9 가 몇개나오는지 를 찾아야겠구만?

                for (char c : array) {
                    if (c == '3' || c == '6' || c== '9') {
                        System.out.print("-");
                    }
                }


            } else {
                System.out.print(s);
            }







            System.out.print(" ");





        }


    }

}
