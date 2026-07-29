import java.util.*;
import java.io.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        // 캐시 사이즈가 0인 경우 -> 모두 캐시 미스
        if(cacheSize == 0) {
            answer = cities.length * 5;
        } else {
            Map<String, Boolean> lruCache = new LinkedHashMap<>(cacheSize, 0.75f, true);
            
            // 도시 순회하며 캐시에서 값 찾기
            for(String city : cities) {
                city = city.toLowerCase();
                
                // cache hit
                if(lruCache.containsKey(city)){
                    answer += 1;
                    lruCache.get(city); // 호출하면 맨 뒤로 다시 순서 조정됨(최신화)
                } 
                // cache miss
                else {
                    answer += 5; // 실행 시간 추가하기
                    
                    // 캐시 꽉 찼으면 하나 비우기
                    if(lruCache.size() == cacheSize) {
                        // 가장 앞에 있는 옛날 요소 제거
                        String oldCity = lruCache.keySet().iterator().next();
                        lruCache.remove(oldCity);
                    }
                    
                    // cache에 이번 도시 넣기
                        lruCache.put(city, true);
                }
                
            }
            
        }
        
        return answer;
    }
}