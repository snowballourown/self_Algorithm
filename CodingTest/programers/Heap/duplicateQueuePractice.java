package CodingTest.programers.Heap;

import java.util.StringTokenizer;
import java.util.TreeMap;

public class duplicateQueuePractice {

    public int[] solution(String[] operations) {
        int[] answer = {};
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        for (String operation : operations) {

            StringTokenizer stn = new StringTokenizer(operation, " ");
            String command = stn.nextToken();
            Integer integer = Integer.parseInt(stn.nextToken());

            if (command.equals("I")) {
                //삽입
                treeMap.put(integer, treeMap.getOrDefault(integer, 0) + 1);

            } else if (command.equals("D")) {
                //최대값 최솟값 삭제

                if (treeMap.isEmpty()) {
                    continue;
                }

                if (integer < 0) {
                    // 최소값삭제
                    if (treeMap.get(treeMap.firstKey()) == 1) {
                        treeMap.remove(treeMap.firstKey());
                    } else {
                        treeMap.put(treeMap.firstKey(), treeMap.get(treeMap.firstKey()) - 1);
                    }
                } else {
                    // 최대값삭제
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

        return new int[]{treeMap.lastKey(), treeMap.firstKey()};

    }

}
