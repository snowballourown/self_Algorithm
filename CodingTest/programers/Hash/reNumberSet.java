package CodingTest.programers.Hash;

import java.util.HashMap;

public class reNumberSet {

    public boolean solution(String[] phone_book) {
        boolean answer = true;

//
//        for (int i = 0; i < phone_book.length; i++) { // 전화번호 길이  * 전화번호 길이
//
//            int length= phone_book[i].length();  // 해당단어 길이
//
//
//            for (int j = 0; j < phone_book.length; j++) { // 전화번호 길이
//                if (phone_book[j].length() < length) { // 해당 단어보다 작으면 존재하지않을테니 무시
//                    continue;
//                }
//                if (i == j) continue;
//                if (phone_book[j].substring(0,  length).equals(phone_book[i])) {
//                    return false;
//                }
//            }
//
//        }


        HashMap<String, Integer> map = new HashMap<>();
        for (String s : phone_book) { // 전화번호 갯수
            map.put(s, 0);
        }

        for (String phone : phone_book) { // 전호번호 갯수
            for (int i = 1; i < phone.length(); i++) {
                String prefix = phone.substring(0, i); // 마지막숫자는 검사안함  0, i-1전까지 처리  => 이걸로 동일 숫자 제거
                if (map.containsKey(prefix)) {
                    return false;
                }
            }


        }






        return answer;
    }
}
