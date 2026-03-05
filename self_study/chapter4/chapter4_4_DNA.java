package self_study.chapter4;

import com.sun.jdi.Value;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class chapter4_4_DNA {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine(), " ");

        int DNAStringLength = Integer.parseInt(stn.nextToken());
        int PartStringLength = Integer.parseInt(stn.nextToken());

        char[] DNAchar = {'A', 'C', 'G', 'T'};

        // DNA 문자열의 길이,
        // 부분 문자열의 길이
        int [] count = new int[4]; //4이면 조건이 만족한 상태 현재 조건상태
        int bibuncase = 0; //비밀 번호가 만족하는상태
        char[] DNAString = br.readLine().toCharArray();
        char[] PartString = new char[PartStringLength];

        int satifiiedcount = 0;

        stn = new StringTokenizer(br.readLine(), " ");
        int[] condition = new int[4];
        for (int i = 0; i < 4; i++) {
           condition[i] =  Integer.parseInt(stn.nextToken());
        }


        for (int i = 0; i < 4; i++) {
            if (condition[i] == 0) {
                satifiiedcount++;
            }
        }
        //한번싹다 확인하는부분
        for (int i = 0; i < PartStringLength; i++) {
            switch (DNAString[i]) {
                case 'A':
                    count[0]++;
                    if (condition[0] == count[0]) {
                        satifiiedcount++;
                    }
                    break;
                case 'C':
                    count[1]++;
                    if (condition[1] == count[1]) {
                        satifiiedcount++;
                    }
                    break;
                case 'G':
                    count[2]++;
                    if (condition[2] == count[2]) {
                        satifiiedcount++;
                    }
                    break;
                case 'T':
                    count[3]++;
                    if (condition[3] == count[3]) {
                        satifiiedcount++;
                    }
            }
        }

        if (satifiiedcount == 4) {
            bibuncase++;
        }

        // window 움직이는 과정
        for (int i = 0; i <(DNAStringLength - PartStringLength) ; i++) {

            switch (DNAString[i]) {
                case 'A':
                    if (condition[0] == count[0]) {
                        satifiiedcount--;
                    }
                    count[0]--;

                    break;
                case 'C':
                    if (condition[1] == count[1]) {
                        satifiiedcount--;
                    }
                    count[1]--;

                    break;
                case 'G':
                    if (condition[2] == count[2]) {
                        satifiiedcount--;
                    }
                    count[2]--;

                    break;
                case 'T':
                    if (condition[3] == count[3]) {
                        satifiiedcount--;
                    }
                    count[3]--;
            }


            switch (DNAString[PartStringLength + i]) {
                case 'A':
                    count[0]++;
                    if (condition[0] == count[0]) {
                        satifiiedcount++;
                    }
                    break;
                case 'C':
                    count[1]++;
                    if (condition[1] == count[1]) {
                        satifiiedcount++;
                    }
                    break;
                case 'G':
                    count[2]++;
                    if (condition[2] == count[2]) {
                        satifiiedcount++;
                    }
                    break;
                case 'T':
                    count[3]++;
                    if (condition[3] == count[3]) {
                        satifiiedcount++;
                    }

            }
            if (satifiiedcount == 4) {
                bibuncase++;
            }


    }


        System.out.println(bibuncase);

   }
}

