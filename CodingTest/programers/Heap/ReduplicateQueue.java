package CodingTest.programers.Heap;

import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class ReduplicateQueue {
    public int[] solution(String[] operations) {

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();


        for (String operation : operations) {
            StringTokenizer stn = new StringTokenizer(operation, " ");

            String s = stn.nextToken();

            int number = Integer.parseInt(stn.nextToken());

            if (s.equals("I")) {
                treeMap.put(number, treeMap.getOrDefault(number, 0) + 1);
            } else if (s.equals("D")){
                if (treeMap.isEmpty()) {
                    continue;
                }
                if (number < 0) {

                    if (treeMap.get(treeMap.firstKey()) == 1) {
                        treeMap.remove(treeMap.firstKey());
                    } else {
                        treeMap.put(treeMap.firstKey(), treeMap.get(treeMap.firstKey()) - 1);
                    }
                } else {
                    if (treeMap.get(treeMap.lastKey()) == 1) {
                        treeMap.remove(treeMap.lastKey());
                    } else {
                        treeMap.put(treeMap.lastKey(), treeMap.get(treeMap.lastKey()) - 1);
                    }
                }
            }

        }

        if (treeMap.isEmpty()) {
            return new int[]{0, 0};
        }


        return new int[]{treeMap.firstKey(), treeMap.lastKey()};
    }
}
