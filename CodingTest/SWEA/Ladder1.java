package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ladder1 {

    static  int [][] number;
    static  int depth;
    static  int answer;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC =  10;
        for (int i = 0; i < TC; i++) {
            ArrayList<Integer> arrayList = new ArrayList<>(); //초반에 들어온 녀석들을 기록하는용
            number = new int[100][100];
            depth = 0;
            Integer a = Integer.parseInt(br.readLine());

            for (int j = 0; j < 100; j++) {
                StringTokenizer stn = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < 100; k++) {
                    number[j][k] = Integer.parseInt(stn.nextToken());
                }
            }
            for (int j = 0; j < 100; j++) { // 시작위치 찾아놓기
                if (number[0][j] == 1) {
                    arrayList.add(j);
                }
            }


            for (Integer integer : arrayList) {
                if (DFS(integer, 0)) {
                    sb.append("#" + a + " " + integer +"\n");
                }

            }

            // 시작이 1이니까 리스트에 시작위치넣어놓을것
            // DFS하면서 아래로 타고 내려가는거임
            // 1. 내려가다가 오른쪽이나 왼쪽에 길이있으면 그쪽으로 가서 아래로 이동하게
            // 2. 맨아래도착하면 return하게
            // 3. 2를 발견하면 도착한것
            // BFS를 쓰지않고 DFS를 선택한이유
            // 최단거리를 구하는경우도아니고 한쪽길을 통해서 이길이 맞는지 아닌지만 빠르게 판단하는거기에 BFS를 쓰지않고
            //DFS로 빠르게 확인하는게 더나을거라 판단

        }


        System.out.println(sb);

    }


    public static boolean  DFS(int i, int depth) { // i= x 좌표  depth = y좌표

        if (depth == 99 && number[depth][i] != 2) { //  밑에 도착했는데  2도아니야 그럼 빠꾸입니다요
            return false;
        }
        if (number[depth][i] == 2) {
            return true;
        }



        if ( i < 99&& number[depth][i + 1] == 1 ) // 오른쪽
            {
                while (i < 99 && number[depth][i + 1] == 1 ) {
                    i++;
                }
               return DFS(i, depth + 1);
            }



        if (  i>0 &&number[depth][i - 1] == 1 )// 왼쪽으롷
        {
            while ( i> 0 && number[depth][i - 1] == 1) { // i가 1이면 접근하다가 0이 되고나서 한번더 비교를 하는데
                // 그러다고 index 0을 넣어주고 시작해서 101로한다?


                // 다시 비교하다가 터지는거네
                i--;
                if (i == 0) {
                    break;
                }
            }
            return DFS(i, depth + 1);
        }


        return  DFS(i,depth+1);

        //내려가는경우
    }
    //좌우로 내려가는경우


}








