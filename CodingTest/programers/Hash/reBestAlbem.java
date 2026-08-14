package CodingTest.programers.Hash;

import java.util.*;

public class reBestAlbem {


    static class Song {

        int index;
        int play;

        public Song(int index, int play) {
            this.index = index;
            this.play = play;
        }
    }


    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        // 1. 장르별 총 재생 횟수 (장르 정렬용)
        Map<String, Integer> genrePlayCount = new HashMap<>();
        // 2. 장르별 곡 리스트 (곡 정렬 및 추출용)
        Map<String, List<bestAlbem.Song>> genreSongs = new HashMap<>();


        for (int i = 0; i < genres.length; i++) {

            genrePlayCount.put(genres[i], genrePlayCount.getOrDefault(genres[i], 0) + plays[i]);

            // 아까 질문하셨던 부분! 리스트가 없으면 새로 만들고 곡 정보를 넣습니다.
            genreSongs.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new bestAlbem.Song(i, plays[i]));
        }

        // 3. 총 재생 횟수 기준 장르 정렬 (내림차순)
        List<String> sortedGenres = new ArrayList<>(genrePlayCount.keySet());
        sortedGenres.sort((g1, g2) -> genrePlayCount.get(g2).compareTo(genrePlayCount.get(g1)));
        // 이걸로배열 잡은거임 대박임 ㄹㅇ 유래카 급






        return answer;
    }
}
