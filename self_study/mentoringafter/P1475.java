package self_study.mentoringafter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class P1475 {
     // 6,9은 호환사용가능
    // 예쁜 방번호를 원함
    // 1,2,3,4,5,6,7,8,9,0 -> 한번씩 사용가능
    // 6,9은 둘중하나가 2번사용할려할때 9가있으면 9를 사용하도록 해야겠다
    // 방번호 받고나서 번호 숫자만큼 카운트를 하고 가장 높은 숫자가 뭔지 카운트해
    // 그값이랑 6,9를 더해서 /2하면 필요한max2 가나오니까 그걸로 나오는값을 count 세도되겠따
     public static void main(String[] args) throws IOException {


         int[] A = new int[10];


         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


         String B = br.readLine();

         for (int i = 0; i < B.length(); i++) {
             A[B.charAt(i) - '0']++;
         }


         int max = 0;

         A[6] = (A[9] + A[6] + 1) / 2;
         A[9] = A[6];

         for (int i = 0; i < 10; i++) {
             if (max < A[i]) {
                 max = A[i];
             }
         }


         System.out.println(max);








     }










}
