package self_study.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class chapter5_20 {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(bufferedReader.readLine());
        int[] num = new int[n];


        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(bufferedReader.readLine());
        }

        // n/2 배열 중아

        int top = n-1;
        int low = 0;
     // 재귀로 가야됨\
    }

    public static void sort(int[] A, int B[], int low, int top) {
        if (low >= top) return;// 혼자 있는 경우
        int mid = low + (top - low) / 2;// 탑이랑 low의 사이의 간격을 /2 한거임

        sort(A,B,low, mid);
        sort(A, B,mid + 1, top);
        //탑을 기준으로 배열을 선언 해 그리고 넣어
        int i = low;
        int count  =low;
        int j = mid+1;
        while (i <= j && j<= top)
        {
            if (A[i] >= A[j]) {
                B[count] = A[j];
                count++;
                j++;
            } else
            {
                B[count] = A[i];
                count++;
                i++;
            }
        }
        while (i <= mid) B[count++] = A[i++];
        while (j <= top) B[count++] = A[j++];
        // ⭐ 4. 중요!! 정렬된 결과를 원본 배열 A에 다시 복사
        // 이 과정이 없으면 다음 재귀에서 정렬 안 된 값을 참조하게 됨
        for (int k = low; k <= top; k++) {
            A[k] = B[k];
        }
    }





 public static void swap(int[] A, int a, int b) {
        int tem = A[a];
        A[a] = A[b];
        A[b] = tem;
    }
}

