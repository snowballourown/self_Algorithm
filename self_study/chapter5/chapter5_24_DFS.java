package self_study.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class chapter5_24_DFS {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);

    }

    static void DFS(int number, int jarisu) {

        if (jarisu == N) {
            if (is_Primes(number)) {
                System.out.println(number);
            }
            return;
        }

        for (int i = 1; i < 10; i++) {
            if (i % 2 == 0) {
                continue;
            }
            if (is_Primes(number * 10 + i)) {
                DFS(number * 10 + i, jarisu + 1);
            }
        }

    }

    static boolean is_Primes(int s) {
        for (int i = 2; i < 10; i++) {
            if (s % i == 0)
                return false;
        }
        return true;

    }

}