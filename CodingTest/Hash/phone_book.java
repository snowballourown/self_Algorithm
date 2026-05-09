package CodingTest.Hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class phone_book {

    //HashMap + subString를 활용해서 푼것
    public boolean solution(String[] phone_book) {
        boolean answer = true;


        // 하나의 번호가 다른 번호의 접두어인지를 확인하는거이기에
        // 다른 번호끼리의 접두어가 같은지는 확인 x

        Map<String, Integer> map = new HashMap<>();
        for (String s : phone_book) {
            map.put(s, 0); //
        }
        for (String phone : phone_book) {
            for (int i = 1; i < phone.length(); i++) {
                String prefix = phone.substring(0, i); // SubString으로배열로쪼개서 가능
                if (map.containsKey(prefix)) {
                    return false;
                }
            }
        }
        return true;
    }



    //정렬 + startWith() 활용
    public boolean solution_2(String[] phone_book) {
        boolean answer = true;

//시간복잡도 n log n

        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i+1].startsWith(phone_book[i])) { // 정렬하면 접두어같은녀석이 옆에 붙음
                // 이함수가 뭐냐면 이녀석으로 시작하는지 여부를 확인하는것 즉 접두어인지 확인할수있는것
                return false;
            }
        }
        return true;
    }
}
