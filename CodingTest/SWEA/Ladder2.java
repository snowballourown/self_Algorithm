package CodingTest.SWEA;

import self_study.chapter5.DFS2;

import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.nio.charset.IllegalCharsetNameException;
import java.util.StringTokenizer;

public class Ladder2 {

    static int answer;
    static int[][] ladder;
    static int min;



    public static void main(String[] args) throws IOException {

        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        // 최단거리로 바닥에 먼저 도착하는경우
        //DFS 로해도될듯 그리고 path로 기록하면될듯 min을 우선

        for (int i = 0; i < 10; i++) {
            int tr = Integer.parseInt(br.readLine());
             min = Integer.MAX_VALUE;
             answer = 0;
             ladder = new int[100][100];

            for (int j = 0; j < 100; j++) {
                StringTokenizer stn = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < 100; k++) {
                ladder[j][k] = Integer.parseInt(stn.nextToken());
                }
            }


            for (int j = 0; j < 100; j++) {
                if (ladder[0][j] == 1) {
                    DFS(j,0,0,j);
                }
            }

            sb.append("#" + (tr)).append(" " + answer + "\n");

        }
        // 일단 첫번째로 출발 하는 녀석들을 잡아야할듯

        System.out.println(sb);







    }




    static void DFS(int x,int y,int path,int startX) {

        if (y == 99 ) {
            if (min >= path) {
                min = path;
                answer = startX;
            }
            return;
        }



        if ( x+1 < 100 && ladder[y][x+1] == 1) {
            while (x + 1 < 100 && ladder[y][x+1] == 1) {
                x++;
                path++;
            }
        } else if ( x -1 >= 0 && ladder[y][x-1] == 1) {
            while (x- 1 >= 0 && ladder[y][x-1] == 1) {
                x--;
                path++;
            }
        }
        DFS(x, y+1, path+1,  startX);
    }



}
