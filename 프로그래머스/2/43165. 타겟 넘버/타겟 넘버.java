import java.util.*;

class Solution {
    
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        
        // 깊이 넘기기 
        dfs(numbers, target, 0, 0);
        
        return answer;
    }
    
    public void dfs(int[] numbers, int target, int depth, int res) {
        // 중간에 확인하면 안됨
        // 모든 경우 확인하면 return
        if(depth == numbers.length) {
            // target 도달하면 저장
            if(res == target) {
                answer ++;
            }
            return;
        }
        
        // 이번 수 더하는 경우
        dfs(numbers, target, depth+1, res+numbers[depth]); // 다음 순서에 전달
        
        // 이번 수 빼는 경우
        dfs(numbers, target, depth+1, res-numbers[depth]); // 다음 순서에 전달
    }
}