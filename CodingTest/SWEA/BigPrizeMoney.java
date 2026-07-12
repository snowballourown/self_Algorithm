package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BigPrizeMoney {
    static  String []s ;
    public static void main(String[] args) throws IOException {


        // 숫자 가 있고 바꿀수있는데 이게 최대가되게 나와야함
        // for문 한번으로 끝내야함


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String total = "";
        String max;

        int n = Integer.parseInt(br.readLine());

        StringTokenizer stn;
        for (int i = 0; i < n; i++) {

            stn = new StringTokenizer(br.readLine(), " ");

            String number = stn.nextToken(); // 숫자배열

            int count = Integer.parseInt(stn.nextToken()); // 교환 횟수
            // 현배열을 max로 해놓고
            // 가장큰수를 찾아서
            // 바꿔가면서 큰수가 되는지비교하고 그숫자로 하면될듯 for 문으로
            max = number;
             s =  number.split("");
            // s리스트에 순서를 바꾸는거임
            // swap에서 (0,1) 바꿔서 리스,트로 내뱉는 클래스 필요함

            for (int j = 0; j < count; j++) { //차라리 substring으로 만들어서 구하면 어떨까?

                for (int k = j+1; k < number.length(); k++) { // number개수만큼
                    swap(j,k);
                    for (String string : s) {
                        total += string;
                    }
                    if (Integer.parseInt(max) < Integer.parseInt(total)) {
                        max = total;
                    } // 기억해줄수가없음 numer를 바꾸고 나서
                    s= number.split("");
                    total = "";


                }

                number = max;



            }
            System.out.println(max);
        }

    }

    static void swap(int i, int j) {


        String tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;

    }







}

