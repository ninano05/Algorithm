import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<int[]> q = new ArrayDeque<>();
        
        for(int i=0; i<priorities.length;i++) {
            q.offer(new int[]{priorities[i], i});
        }
        
        int count = 0;
        
        while(!q.isEmpty()) {
            // 현재 내가 꺼내오는 프로세스
            int[] cur = q.poll();
            
            boolean highProcess = false;
            // 큐 내부 우선 순위 검사
            for(int[] p : q) {
                if(p[0] > cur[0]) { // 큰 놈 있음
                    highProcess = true;
                    break;
                }
            }
            
            // 큰 놈 있었음
            if(highProcess) {
                q.offer(cur); // 그럼 현재 요소 다시 넣어주기
            } else { // 큰 놈 없었음
                answer ++;
                if(cur[1] == location) // 근데 이게 내가 찾고자 하는 거임
                    break;
            }
            
            
        }
        
        return answer;
    }
}