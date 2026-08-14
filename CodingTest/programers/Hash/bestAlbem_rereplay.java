package CodingTest.programers.Hash;

import java.util.*;

public class bestAlbem_rereplay {

    class Song{
        int index;
        int play;

        public Song(int index, int play) {
            this.index = index;
            this.play = play;
        }
    }



    public int[] solution(String[] genres, int[] plays)
    {

        Map<String, Integer> CountGenre = new HashMap<>(); //장르 별나누기
        Map<String, List<Song>> GenreList = new HashMap<>(); //장르별 리스트

        for (int i = 0; i < genres.length; i++) {
            CountGenre.put(genres[i], CountGenre.getOrDefault(genres[i], 0) + plays[i]);
            GenreList.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new Song(i, plays[i]));

        }

        List<String> sortedList = new ArrayList<>(CountGenre.keySet());
        sortedList.sort((g1, g2) ->  CountGenre.get(g2).compareTo(CountGenre.get(g1)));

        List<Integer> result = new ArrayList<>();


        for (String s : sortedList) {

            List<Song> songs = GenreList.get(s);

            songs.sort((a, b) -> {
                if (a.play == b.play) {
                    return a.index - b.index;
                }

                return b.play - a.play;
            });


            for (int i = 0; i < songs.size() && i < 2; i++) {
                result.add(songs.get(i).index);
            }
            
            
            
            
            
            
            
        }


        return result.stream().mapToInt(i -> i).toArray();
        }








    }






