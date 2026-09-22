package CodingTest.Programer_2.stack_queue;

public class rightgaeho {
    boolean solution(String s) {

        String[] a = new String[s.length()];
        int count = 0;
        boolean flag = true;
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else {
                if (count == 0) {
                    flag= false;
                    break;
                }
                count--;
            }
        }

        if (count != 0) {
            flag = false;
        }




        return flag;
    }


}
