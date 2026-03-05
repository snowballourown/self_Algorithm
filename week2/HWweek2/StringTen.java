package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringTen
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        String [] st_split = st.split("");
        for (int i = 1; i <= st_split.length; i++) {
            System.out.print(st_split[i-1]);
            if((i % 10) == 0) System.out.print("\n");
        }
    }
}
