package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MillionRich {

    public static void main(String[] args) throws IOException {
        int w =1;

        StringBuilder sb = new StringBuilder();
//        다음과 같은 조건 하에서 사재기를 하여 최대한의 이득을 얻도록 도와주자.
//
//        1. 원재는 연속된 N일 동안의 물건의 매매가를 예측하여 알고 있다.
//        2. 당국의 감시망에 걸리지 않기 위해 하루에 최대 1만큼 구입할 수 있다.
//        3. 판매는 얼마든지 할 수 있다.
//         예를 들어 3일 동안의 매매가가 1, 2, 3 이라면 처음 두 날에 원료를 구매하여 마지막 날에 팔면 3의 이익을 얻을 수 있다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int i = 0; i < TC; i++) {
            int BuyOp = Integer.parseInt(br.readLine()); // 살 수 있는날

            StringTokenizer stn = new StringTokenizer(br.readLine(), " ");
            Integer[] price = new Integer[BuyOp];

            int Max = 0;

            for (int j = 0; j < price.length; j++) {
                price[j] = Integer.parseInt(stn.nextToken());
                if (Max < price[j]) {
                    Max = price[j];
                }
            }

            // 가장 큰값이 나올때까지 물건을 산다
            // 물건이 가장 큰날이 오면 그때 다팔아버린다
            // 가장 큰날이 지나면 그다음 큰날이 올때까지 물건을 하나씩 산다

            long sum = (long) 0L;
            for (int j = 0; j < price.length; j++) {
                if (Max == price[j]) {
                    Max = 0;
                    for (int k = j + 1; k < price.length; k++) {
                        if (Max < price[k]) {
                            Max = price[k];
                        }
                    }
                } else {
                    sum+= Max - price[j]; // 이득 저장
                }

            }




            sb.append("#" + w + " " + sum + "\n");
            w++;
        }

        System.out.println(sb);








    }


}
