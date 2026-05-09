package CodingTest.Hash;

import java.util.*;

class bestAlbem_reply {


    class Song {
        int id;
        int play;

        public Song(int id, int play) {
            this.id = id;
            this.play = play;
        }
    }

    public int[] solution(String[] genres, int[] plays) {

//        속한 노래가 많이 재생된 장르를 먼저 수록합니다.
//장르 내에서 많이 재생된 노래를 먼저 수록합니다.
//장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.

        // map 으로 앨범의 총수를 계속 더해  -> 정렬을 할떄 큰녀석을 먼저 받아야하나니까

        // 정렬을 내림 차순으로 해야겠지? -> Song list선언하고 list들도 내림 차순으로 선언 그리고 동등시고유번호가 낮은순으로 배열되게 따로 설정해씅ㅁ
        // map 으로 song을 더해

        // 장르에 총 재생수를 파악하기위해 쓴거임
        Map<String, Integer> CountGenres = new HashMap<>();

        Map<String, List<Song>> SongGenres = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {

            CountGenres.put(genres[i], CountGenres.getOrDefault(genres[i], 0) + plays[i]);

            //song장르가  부재이면 해당장르를 추가하고 배열리스트를 만들어서 song을 만들어서 짚어넣ㅇ는거임
            // 만약 gener가있었다면 list를 새로 만들지 않고 그냥  새로운 song을 만들고 추가만 했을거임
            SongGenres.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new Song(i, plays[i]));
        }
        // 부록에 새로 넣어야겠지?

        // 리스트는 어케 해야되는지 모르겠음
        // 그냥 list를 먼저 만져보고 해보자

        List<String> songs = new ArrayList<>(CountGenres.keySet());
        songs.sort((a, b) -> CountGenres.get(b).compareTo(CountGenres.get(a)));
        // 내림차순으로해서 비교하면서  미친거지


        List<Integer> result = new ArrayList<>();


        for (String genre : genres) {

            List<Song> songs1 = SongGenres.get(genre);


            songs1.sort((a, b) -> {
                if (a.play == b.play) {
                    return a.id - b.id; // 더작은애를 내보내야하는데
                }
                return b.play - a.play;
            });


            for (int i = 0; i < 2 && i<songs1.size() ; i++) {
                result.add(songs1.get(i).id);
            }
        }


        return result.stream().mapToInt(i -> i).toArray();
        //
        //이제 2개씩꺼내야지

        //갯수가 하나있을수도있으니까 2개씩꺼내고
    }
}


    //














