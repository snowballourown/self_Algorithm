package CodingTest.programers.Heap;

import java.util.*;


public class duplicateQueue {
    public int[] solution(String[] operations) {
        int[] answer = {};


        TreeMap<Integer, Integer> treeMap = new TreeMap<>();


        for (String operation : operations) {
            StringTokenizer stn = new StringTokenizer(operation, " ");

            String command = stn.nextToken();
            int integer = java.lang.Integer.parseInt(stn.nextToken());

            if (command.equals("I")) {
                treeMap.put(integer, treeMap.getOrDefault(integer, 0) + 1);
            }else if (command.equals("D")) {
                if (treeMap.isEmpty()) {
                    continue;
                }

                int key;
                if (integer == 1) {
                    key = treeMap.lastKey();   // 최댓값
                } else {
                    key = treeMap.firstKey();  // 최솟값
                }


                if (treeMap.get(key) == 1) {
                    treeMap.remove(key);
                } else {
                    treeMap.put(key, treeMap.get(key) - 1);
                }




            }

        }

        if (treeMap.isEmpty()) {
            return new int[]{0, 0};
        }



        return new int[]{treeMap.lastKey(), treeMap.firstKey()};
    }
}
