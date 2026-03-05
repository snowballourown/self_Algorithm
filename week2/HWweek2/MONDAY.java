package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MONDAY {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String MonthAndDay = br.readLine();
        StringTokenizer str = new StringTokenizer(MonthAndDay, " ");

        Integer month = Integer.parseInt(str.nextToken());
        Integer day = Integer.parseInt(str.nextToken());

        Integer[] Month_day = {0, 31, 28, 31, 30, 31, 30,
                                31, 31, 30, 31, 30, 31};

        String [] strings = {"SUN","MON","TUE","WED","THU","FRI","SAT"};

        Integer totalDay= 0;

        for (int i = 0; i < month; i++)
        {
            totalDay += Month_day[i];
        }
        String string = strings[(totalDay+ day) % 7];
        System.out.println(string);
    }
}
