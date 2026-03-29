package self_study.mentoringafter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P10808 {
    public static void main(String[] args) throws IOException {


        Scanner scanner = new Scanner(System.in);


        int array[] = new int[26];


        String word = scanner.nextLine();

        for (int i = 0; i < word.length(); i++) {
            array[word.charAt(i) - 97]++; //소문자 A의 아스키코드 97임
        }

        for (int i : array) {
            System.out.print(i + " ");

        }

    }
}
