import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<n; i++) {
            // 가격이 떨어진 순간
            while(!stack.isEmpty() && 
                  prices[stack.peek()] > prices[i]) {
                int idx = stack.pop();
                answer[idx] = i-idx;
            }
            // i 넣어주기(i는 무조건 넣음 어차피 다음 차례에서 판단할 거기 때문)
            stack.push(i);
        }
        
        // for문으로 가격이 떨어진 순간은 체크 완료했는데, 만약 가격이 끝까지 안 떨어졌다면
        while(!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = n-1-idx;
        }
        
        return answer;
    }
}