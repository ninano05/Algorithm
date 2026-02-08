import java.util.*;
import java.io.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> map = new HashMap<>();
        
        // 참가자 이름 별 수
        for(String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        
        // 참가자 이름 별 수에서 완주자 수 빼기
        for(String c: completion) {
            map.put(c, map.get(c)-1); 
        }
        
        // 남아있는 명단 출력
        for(String key: map.keySet()) {
            if(map.get(key) > 0) {
                answer = key;
            }
        }
        
        return answer;
    }
}