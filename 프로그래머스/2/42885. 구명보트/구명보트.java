import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int boat = 0;
        
        // 최대 2명까지 태울 수 있음
        // 제일 무게 많이 나가는 사람 먼저 태우고
        // 그 다음 제일 적게 나가는 사람 태우기
        
        Arrays.sort(people);
        Deque<Integer> weights = new ArrayDeque<>();
        
        for(int i=0; i<people.length; i++) {
            weights.offerLast(people[i]);
        }
        
      
        
        
        while(!weights.isEmpty()) {
            // 무게 꺼내보기
            int sum = weights.peekLast() + weights.peekFirst(); 
            if(sum <= limit) {
                weights.pollLast();
                weights.pollFirst();
                boat++;
            }
            else {
                weights.pollLast();
                boat++;
            }
            
        }
        
        
        return boat;
    }
}