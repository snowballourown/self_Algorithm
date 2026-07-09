package CodingTest.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class dalPeming {
    public static void main(String[] args) throws IOException {


        //  배열에 저장을 해야할것같음
        // if로 해야될것같은

        // if x == 1 && y == 1일때  x = 4   도달하기전까지    -> x가움직임 오른쪽
        // if x == 4 && y == 1일때  y = 4   도달하기전까지    -> y 움직임 아래쪽
        // if x == 4 && y == 4일떄  x = 1   도달하기전까지    > x가움직임 왼쪽
        // if x == 1 && y == 4일때  y = 2   도달하기전까지  -> y 움직임  위쪽

        // if x == 1 && y == 2일때  x = 3에 도달하기 전까지   > x가움직임 오른쪽
        // if x == 3 && y == 2일때  y = 3에 도달하기전까지  -> y 움직임 아래쪽
        // if x == 3 && y == 3일때  x = 2에 도달하기전까지  -> x가움직임 왼쪽


        //while문으로 하고 기준은 배열에들어갈숫자가 nxn 에도달하면 그만하는걸로하고

        // i가 증가하는 방향이랑
        // i가 감소하는 방향을 나눠야할것같음

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < TC; j++) {


            int n = Integer.parseInt(br.readLine());
            int current_x = 1;
            int current_y = 1;
            int end_x =n;
            int end_y =n;

            int count =0;
            int[][] number = new int[n+1][n+1];
            while (true) {
                end_y= n - current_y +1;
                end_x = n - current_x + 1;

                // 오른쪽
                for (int i = current_x; i <= end_x; i++) {
                    count++;
                    number[current_y][i] = count; }
                if (count == n*n) {
                    break;
                }

                // 아래쪽
                for (int i = current_y+1; i <= end_y; i++) {

                    count++;
                    number[i][end_x] = count;
                }
                if (count == n*n) {
                    break;}

                // 왼쪽
                for (int i = end_x-1; i >= current_x; i--) {
                    count++;

                    number[end_y][i] = count;    }
                if (count == n*n) {
                    break;
                }


                // 위쪽으로
                for (int i = end_y-1; i >= current_y+1; i--) {
                    count++;

                    number[i][current_x] = count; }
                if (count == n*n) {
                    break;
                }

                current_y++;
                current_x++;

            }
            sb.append("#" + (j+1));
            for (int[] ints : number) {
                for (int anInt : ints) {
                    if (anInt ==0) continue;
                    sb.append(anInt + " " );
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);






        }











    }

