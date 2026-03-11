import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] scoville, int K) {
        // 스코빌 정렬 => 최소 힙으로 형태 변환
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0; i<scoville.length; i++) {
            minHeap.add(scoville[i]);
        }
        int mixFood = 0;
        int answer = 0; 
        // 아래 과정을 반복해서 최소값이 K보다 크거나 같으면 종료
            // 최소값 꺼내고, 두번째 최솟값 꺼내고
            // 다시 스코빌 정렬에 넣기
            // 예외 케이스1 = 요소가 하나가 됐을 경우 k 보다 작은 경우
        while(minHeap.peek() < K) {
            if(minHeap.size() == 1) {
                answer = -1;
                break;
            }
            mixFood = minHeap.poll()+(minHeap.poll()*2);
            minHeap.add(mixFood);
            answer ++;
            }
        return answer;
    }
}