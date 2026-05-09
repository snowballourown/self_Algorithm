package CodingTest.Hash;

import java.util.*;

public class bestAlbem {

    // 속한노래들의 합이 높은것을 먼저 수록
    // 속한노래들중에 많이 재생된 노래먼저 수록
    // 만약 같은 재생횟수 가진다면 고유번호가 낮은 노래를 먼저 수록함


    // 노래별 장르를 나타내는 문자열 배열 genres
    // 노래별 재생 횟수를 나타내는 정수배열 plays
    // 베스트 앨범에 들어갈 노래의 순서대로 return 하도록 solution


    // 장르별 2곡식


    //hashmap을 선언한후에 String, 정수 리스트로 변환
    // 각 앨범에 맞게 넣어버림 그리고 총합을구해서  먼저수록할 장르를 구함
    // 그다음 장르를 2곡넣음
    // 이떄 재생횟수가 같을때 고유번호가 낮은애를 먼저 넣음
    static class Song {
        int id;
        int play;

        public Song(int id, int play) {
            this.id = id;
            this.play = play;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        // 1. 장르별 총 재생 횟수 (장르 정렬용)
        Map<String, Integer> genrePlayCount = new HashMap<>();
        // 2. 장르별 곡 리스트 (곡 정렬 및 추출용)
        Map<String, List<Song>> genreSongs = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            genrePlayCount.put(genres[i], genrePlayCount.getOrDefault(genres[i], 0) + plays[i]);

            // 아까 질문하셨던 부분! 리스트가 없으면 새로 만들고 곡 정보를 넣습니다.
            genreSongs.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new Song(i, plays[i]));
        }

        // 3. 총 재생 횟수 기준 장르 정렬 (내림차순)
        List<String> sortedGenres = new ArrayList<>(genrePlayCount.keySet());
        sortedGenres.sort((g1, g2) -> genrePlayCount.get(g2).compareTo(genrePlayCount.get(g1)));
            // 이걸로배열 잡은거임 대박임 ㄹㅇ 유래카 급




        List<Integer> result = new ArrayList<>();

        // 4. 정렬된 장르 순서대로 순회하며 곡 추출ㄸ
        for (String genre : sortedGenres) {
            List<Song> songs = genreSongs.get(genre);

            // 장르 내 곡 정렬: 재생수 내림차순 -> 같으면 고유번호 오름차순
            songs.sort((s1, s2) -> {
                if (s1.play == s2.play) return s1.id - s2.id;
                return s2.play - s1.play;
            });

            // 최대 2개까지만 결과 리스트에 담기
            for (int i = 0; i < songs.size() && i < 2; i++) {
                result.add(songs.get(i).id);
            }
        }

        // List를 배열로 변환하여 반환
        return result.stream().mapToInt(i -> i).toArray();
    }
}











