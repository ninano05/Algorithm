import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        // map으로 귤마다 개수 저장해두기
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0)+1);
        }
        
        // 리스트로 각 개수만 옮겨 담기
        int[] typeNum = new int[map.size()];
        int index = 0;
        for(int n : map.keySet()) {
            typeNum[index] = map.get(n);
            index++;
        }
        
        // 리스트 오름차순 정렬
        Arrays.sort(typeNum);
        
        // 큰 귤부터 택하기(배열 역순)
        int cur = 0; // 현재 선택할 수 있는 귤 개수
        for(int i=typeNum.length-1; i>=0; i--) {
            cur += typeNum[i];
            answer++;
            // K개 골랐는지 확인
            if(cur >= k) break;
        }
        
        return answer;
    }
}