package CodingTest.programers.Heap;

import java.util.*;

public class REREduplicateQueue {
        public int[] solution(String[] operations) {

            int[] answer = {};
            TreeMap<Integer, Integer> map = new TreeMap<>();


            for (String operation : operations) {
                StringTokenizer stn = new StringTokenizer(operation, " ");

                String s = stn.nextToken();
                Integer number = Integer.parseInt(stn.nextToken());

                if (s.equals("I")) {
                    map.put(number, map.getOrDefault(number, 0) + 1);
                } else if (s.equals("D"))
                {

                    if (map.isEmpty()) {
                        continue;
                    }
                    if (number > 0) {
                        if (map.get(map.lastKey()) == 1) {
                            map.remove(map.lastKey());
                        } else {

                            map.put(map.lastKey(), map.get(map.lastKey()) - 1);
                        }
                    } else {
                        if (map.get(map.firstKey()) == 1) {
                            map.remove(map.firstKey());
                        } else {

                            map.put(map.firstKey(), map.get(map.firstKey() - 1));
                        }
                    }
                }




            }


            if (map.isEmpty()) {
                return new int[]{0, 0};
            }

            return new int[]{map.firstKey(), map.lastKey()};
        }
}
