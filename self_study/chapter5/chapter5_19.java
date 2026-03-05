package self_study.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class chapter5_19 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stn = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(stn.nextToken());
        int K = Integer.parseInt(stn.nextToken());

        stn = new StringTokenizer(br.readLine(), " ");
        Integer[] A = new Integer[N];

        for (int i = 0; i < N ; i++) {
            A[i] = Integer.parseInt(stn.nextToken());
        }
    }
    // pivot 위치랑 몇번째 인자를 내보내는것이 같으면  끝
    // k보다 pivot가 크면 start +1 , end
    // k보다 pivot가 작으면 pivot-1 , 하고  =>
    //


    public static void quickSort(int A[], int S, int E, int K) {

        if (S < E) {
            int pivot = Partition(A, S,E);

            if (pivot == K) {
                return;
            } else if (K < pivot) {
                quickSort(A, S, pivot - 1, K);
            } else {
                quickSort(A, pivot+1 , E, K);

            }
        }



    }


    public static int Partition(int[] A, int start, int end) {

        if (start + 1 == end) {
            if (A[start] > A[end])
                swap(A, start, end);
            return end;
        }

        int pivot = A[start];
        int M  = (start+ end) / 2;
        int num = A[pivot];
        int i = start+1, j = end;
        swap(A, start, M);


        while (i <= j) {
            while (i <= end && A[pivot] > A[i]) {
             i++;
            }
            while (j >= start + 1&& A[pivot] < A[j]) {
                j--;
            }
            if (i <= j) {
                swap(A, i, j);
            }
        }
        A[start] =  A[j];
        A[j] = num; // start 자리에 비교 대상이있음
        return j;

    }








    public static void swap(int A[], int a, int b)
    {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;

    }

}
