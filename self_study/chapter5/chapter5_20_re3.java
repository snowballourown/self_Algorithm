package self_study.chapter5;

import java.io.*;

public class chapter5_20_re3 {

    static int [] tmp,A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        A = new int[N];
        tmp= new int[N];


    }


    public static void merget_sort(int s, int e) {
        if (e - s > 1) {
            return;
        }
        int m = s + (e - s) / 2;


        merget_sort(s, m);
        merget_sort(m + 1, e);

        int index1 = s;
        int index2 = m+1;
        int k = s;
        for (int i = s; i < e; i++) {
            tmp[i] = A[i];
        }

        while (index1 <= m && index2 <= e) {
            if (tmp[index1] > tmp[index2]) {
                index1++;
                k++;
            }
            else {
                index2++;
                k++;
            }

            while (index1 <= m) {
                A[k] = tmp[index1];
            k++; index1++;
            }
            while (index2 <= e) {
                A[k] = tmp[index2];
                k++;
                index2++;
            }



        }








    }
}
