package self_study.chapter5;

import java.io.*;

import static java.lang.System.*;

public class chapter5_20_repractice {
    static int[] A,tmp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));

        int N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        tmp = new int[N+1];

        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(br.readLine());}
    }


    private static void merget_sort(int s, int e) {
        if (e - s > 1) {
            return;
        }
//
//        merget_sort(s, mid);
//        merget_sort(mid + 1, e);

        int mid = s +(e-s)/2;
        int index1 = s;
        int index2 = mid + 1;
        int  k = s;

        for (int i = s; i <= e; i++) { //
            tmp[i] = A[i];
        }


        while (index1 <= mid && index2 <= e)
        {
            if (tmp[index1] > tmp[index2]) {
                A[k] = tmp[index2];
                index2++;
                k++;
            } else {
                A[k] = tmp[index1];
                index1++;
                k++;
            }

        }


        while (index1 <= mid) {
            A[k++] = tmp[index1++];
        }
        while (index2 <= e) {
            A[k++] = tmp[index2++];
        }




    }





}
