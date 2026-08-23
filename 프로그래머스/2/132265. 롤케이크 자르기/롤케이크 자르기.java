import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Set<Integer> left = new HashSet<>();
        Map<Integer, Integer> right = new HashMap<>();
        
        // 초기 set와 map 채우기
        // 왼쪽 set 채우기
        left.add(topping[0]);

        // 오른쪽 map 채우기
        for(int j=1; j<topping.length; j++) {
            right.put(topping[j], right.getOrDefault(topping[j], 0)+1);
        }
        
        // 여기서도 한번 확인해야 함
        if(right.size() == left.size()) {
            answer ++;
        }
        
        // 반복문 돌면서 하나씩 왼쪽으로 옮기기
        for(int i=1; i<topping.length; i++) {
            int curTopping = topping[i];
            // 왼쪽 추가
            left.add(curTopping);
            
            // 오른쪽에서 빼기 - 해당하는 값 빼기
            right.put(curTopping, right.get(curTopping)-1);
            // 뺀 다음 0이 되면 아예 제거하기
            if(right.get(curTopping) == 0) {
                right.remove(curTopping);
            }
            
            // 크기 비교하기
            if(right.size() == left.size()) {
                answer ++;
            }
            
        }
        
        return answer;
    }
    
}