package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MiLo {

    static int [][] number;
    static boolean[][] visited;

    public static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder  sb = new StringBuilder();
        int TC = 10;
        for (int i = 0; i < TC; i++) {
            answer=0;
            int Escape_Try =Integer.parseInt(br.readLine());
            number = new int[16][16];
            visited = new boolean[16][16];

            int start_y =0 ;
            int start_x =0 ;
            for (int j = 0; j < 16; j++) {
                String s = br.readLine();
                for (int k = 0; k < 16; k++) {  // 데이터 삽입
                    number[j][k] = s.charAt(k) - '0';
                    if (number[j][k] == 2)  // 출발 지점 찾음
                    {
                        start_x = k;
                        start_y = j;
                    }
                }

                //BFS로 찾는게 낫겠지? 최소 비용이런건아닌데 미로찾기니까 모든 경우의수가아닌 가능 여부에서만 확인하면되는거면
                // DFS도 나쁘지않겠는뎨?

                //DFS로 풀어야겠다


            }

            DFS(start_y, start_x);


            sb.append("#" + (i + 1) + " " + answer+ "\n");
        }

        System.out.println(sb);

    }


    static public void DFS(int y, int x) {

        if(visited[y][x])  return;

        visited[y][x] = true;
        if (number[y][x] == 3) {
            answer = 1;

            return;
        }


        if (number[y - 1][x] == 0 || number[y - 1][x] == 3) {
            DFS(y - 1, x);
        }
        if (number[y][x - 1] == 0 || number[y][x - 1] == 3) {
            DFS(y, x - 1);
        }
        if (number[y + 1][x] == 0 || number[y + 1][x] == 3) {
            DFS(y + 1, x);
        }
        if (number[y][x + 1] == 0 || number[y][x + 1] == 3) {
            DFS(y, x + 1);
        }




    }








}
