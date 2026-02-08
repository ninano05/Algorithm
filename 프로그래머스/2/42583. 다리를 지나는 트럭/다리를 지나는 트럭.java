import java.util.*;
import java.io.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0; // 걸리는 시간
        
        Queue<int[]> bridge = new ArrayDeque<>(); // 다리 큐
        
        int truckIdx = 1; // 올라갈 트럭 인덱스
        int curWeight = 0; // 현재 다리 무게
        int bridgeCount = 0; //처음 다리에 올라가고 트럭의 카운트
        
        // 초기에 다리에 하나 올리고 시작
        bridge.offer(new int[]{truck_weights[0],1});
        answer ++;
        curWeight = truck_weights[0];
        
        // 다리가 empty가 될 때까지 반복
        while(!bridge.isEmpty()) {
            // 시간 흐르기
            answer +=1;
            
            // 다리 위 트럭 앞으로 한 칸
            for(int i=0; i<bridge.size(); i++) {
                int[] cur = bridge.poll();
                cur[1] ++;
                bridge.offer(cur);
            }
            
            // 내려갈 트럭은 제거
            if(bridge.peek()[1] == bridge_length + 1) {
                curWeight = curWeight - bridge.poll()[0]; // 제거하면서 무게 빼기
            }
            
            // 올라갈 트럭 올리기
            if(truckIdx < truck_weights.length && 
               curWeight+truck_weights[truckIdx] <= weight && 
               bridge.size() <= bridge_length) {
                
                bridge.offer(new int[]{truck_weights[truckIdx],1}); //트럭 올리기
                curWeight += truck_weights[truckIdx]; // 현재 무게에 트럭 더하기
                truckIdx ++; //트럭 인덱스 넘기기
            }
        }

        
        return answer;
    }
    
}