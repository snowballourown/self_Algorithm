package self_study.chapter5;

import java.io.*;

public class chapter5_22_partice {
    public static int[] A;
    public static int result;
    public static void main(String[] args) throws IOException {
        // 각자리가 어디에있느지 기억하는경우 -> 이걸 큐로 구현해서 뒤에서부터 입력
        // 일의 자리숫자를 정렬하는경우
        // 십의 자리숫자를 정렬하는경우
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        Radix_Sort(A, 5);

        for (int i = 0; i < N; i++) {
            bw.write(A[i] + "\n");
        }
        bw.flush();
        bw.close();

    }

    public static void Radix_Sort(int[] A, int max_size)
    {
        int[] output = new int[A.length];
        int jarisu = 1;
        int count = 0;
        // 여기서 max_size은 자리수를 뜻함
        while (count != max_size) {
            int[] bucket = new int[10]; // 원레있던값이 있으니까 다시 만들어버림
            for (int i = 0; i < A.length; i++) {
                bucket[(A[i]/ jarisu) %10]++;  //  해당 자리수에 +1 값을 해버림
            }
            for (int i = 1; i < 10; i++) { // 배열위치 넣는곳
                bucket[i] += bucket[i - 1]; // 누적해서 배열위치를 확인  이렇게 하는이유는 배열의 값을 짚어넣을때  겹치지 않기하기위해서
            }
            for (int i = A.length - 1; i >= 0; i--) {
                output[bucket[A[i] / jarisu % 10] - 1] = A[i]; // -1은 해당 배열 특설 때문에
                bucket[(A[i]/ jarisu) % 10 ]--; // 해당 자리수의 배열이 빠졌으니까
            }
            for (int i = 0; i < A.length; i++) {
                A[i] = output[i];  }
            jarisu = jarisu * 10; // 다음 자리수로 넘어가기위해서
            count++; //
        }
    }
}


