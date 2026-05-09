package CodingTest.Hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class bestAlbem_rereplay {

//    속한 노래가 많이 재생된 장르를 먼저 수록합니다.
//    장르 내에서 많이 재생된 노래를 먼저 수록합니다.  => 재생수로 정렬도해야함
//    장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다. =>  id로 정렬해야함  => 정렬해야되는게 2개다?
    class  Song{
        int id ;
    int play;

    public Song(int id, int play)
    {
        this.id = id;
        this.play = play;
    }

}



    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        Map<String, Integer> CountAlbem = new HashMap<>();
        Map<String, List<Song>> genresAlbem = new HashMap<>();

        //map으로 해당 앨범의 총 재생수를 check하기 위해 기록함
        for (int i = 0; i < genres.length; i++) {
            CountAlbem.put(genres[i], CountAlbem.getOrDefault(genres[i], 0) + plays[i]);

            genresAlbem.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new Song(i, plays[i]));
        }


        List<String> s =  new ArrayList<>(CountAlbem.keySet());

        s.sort((a, b) -> CountAlbem.get(b).compareTo(CountAlbem.get(a))); // 내림차순으로 설정했음
        // 장르별 총 재생수를 이렇게설정

        List<Integer> result = new ArrayList<>();

        for (String string : s) {
            List<Song> songs = genresAlbem.get(string);

            songs.sort( (a,b) -> {
                if (a.play == b.play) {
                    return a.id - b.id;
                }
                return b.play - a.play;
            });


            //result
            for (int i = 0; i < 2 &&  songs.size()< i; i++) {
                result.add(songs.get(i).id);
            }


        }

        return result.stream().mapToInt(i -> i).toArray();
    }





}
