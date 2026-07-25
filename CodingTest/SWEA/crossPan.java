package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class crossPan {


    static int [][] num;
    static Set<String> list ;


     public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringBuilder sb = new StringBuilder();
        // DFS로 가야할듯

        int TC = Integer.parseInt(br.readLine());


        for (int i = 0; i < TC; i++) {

             num = new int[4][4];
            list = new HashSet<>();
            for (int j = 0; j < 4; j++) {
                StringTokenizer stn = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < 4; k++) {
                    num[j][k] = Integer.parseInt(stn.nextToken());
                }
            }


            //DFS로 가야할듯 조합으로  7자리로 한다니까  동서남북으로 움직인다고 함


            for (int x = 0; x < 4; x++) { // 시작이 임의니까 모든곳에서 시작점이 될수도있다는거임
                for (int y = 0; y < 4; y++) {
                    DFS(x, y, 1,   "");

                }
            }


            sb.append("#" + (i+1) +" "+list.size() + "\n");

        }

         System.out.println(sb);


    }


    static void DFS(int x, int y, int depth, String a) {

        if (x < 0 || y < 0 || x >3 || y >3  ) { // 범위 밖으로 나가며안되까
            return;
        }

        a += num[x][y];

        if (depth == 7) { //  다왔다는거니까
            //이미 비밀번호에있는건지 확인 있으면 pass
                list.add(a);
                return;
        }


        // 4가지 방향으로 DFS 가면됨 추가하면서

        DFS(x+1, y, depth+1,a );
        DFS(x, y+1, depth+1,a );
        DFS(x-1, y, depth+1,a );
        DFS(x, y-1, depth+1,a );



    }
}
