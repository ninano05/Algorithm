import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int maxmon = nums.length/2; // 최대 가지게 되는 포켓몬
        
        // 포켓몬 종류별 개수 해시 정리
        HashMap<Integer, Integer> pocketmon = new HashMap<>();
        for(int n : nums) {
            pocketmon.put(n, pocketmon.getOrDefault(n, 0) + 1);
        }
        
        // 포켓몬 골라내기
        // 최대 종류수가 최대 포켓몬 보다 작은 경우 => 최대 종류 수
        if(pocketmon.keySet().size() <= maxmon) {
            answer = pocketmon.keySet().size();
        } else{ // 최대 종류수가 최대 포켓몬 보다 큰 경우 => 최대 포켓몬 수
            answer = maxmon;
        }
        
        return answer;
    }
}