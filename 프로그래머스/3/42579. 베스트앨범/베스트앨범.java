import java.util.*;
import java.io.*;

class Solution {
    // 노래 객체
    static class Music {
        int id, play;
        Music(int id, int play) {
            this.id = id;
            this.play = play;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        // 장르 별 재생횟수 해시
        HashMap<String, Integer> genrePlaySum = new HashMap<>();
        // 장르 별 곡 목록
        HashMap<String, List<Music>> genreSongList = new HashMap<>();
        for(int i=0;i<plays.length;i++) {
            genrePlaySum.put(genres[i], genrePlaySum.getOrDefault(genres[i], 0) + plays[i]);
            
            if(!genreSongList.containsKey(genres[i])) { // 새로운 장르라면
                genreSongList.put(genres[i], new ArrayList<>()); // 장르 추가
            }
            genreSongList.get(genres[i]).add(new Music(i, plays[i])); // 장르 있으면 음악 정보 삽입 
        }
        
        // 장르 내림차순 정렬
        List<String> sortedGenres = new ArrayList<>(genrePlaySum.keySet());
        sortedGenres.sort((a,b) -> genrePlaySum.get(b) - genrePlaySum.get(a)); // -결과가 양수면 자리바꿈, 즉 b가 더 크면 자리 바꾸기 때문에 내림차순
        
        // 최종 결과 저장할 리스트
        List<Integer> resultList = new ArrayList<>();
        
        // 정렬된 장르별 상위 2곡 가져오기
        for(String genre : sortedGenres) {
            List<Music> musics = genreSongList.get(genre); // 장르에 해당하는 노래
            
            musics.sort((a, b) -> b.play - a.play); // 노래를 내림차순 정렬
            
            // 상위 두곡 넣어주기, 한곡만 있으면 한곡만
            resultList.add(musics.get(0).id);
            if (musics.size() > 1) resultList.add(musics.get(1).id);
        }
        
        answer = resultList.stream().mapToInt(i -> i).toArray();
        
        return answer;
    }
}