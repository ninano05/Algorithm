import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int[progresses.length]; // 모든 작업이 최대 길이임
        
        int answerIdx = 0;
        int preMax = 0; // 앞에서 가장 오래걸리는 작업 일수
        int completeWork = 1; // 완료된 일의 수 
        int[] restProgresses = new int[progresses.length];
        
        // 작업 남은 일 수 저장
        for(int i = 0; i<progresses.length; i++) {
            restProgresses[i] = getWorkDays(progresses[i], speeds[i]);
        }
        
        preMax = restProgresses[0];
        // 남은 일 수를 바탕으로 회차별 완료되는 작업 계산
        for(int i=1;i<restProgresses.length;i++) {
            // 뒤에 있는 작업이 앞의 최대 작업보다 같거나 더 작은 경우
            if(restProgresses[i] <= preMax) {
                completeWork+=1;
            }
            // 뒤에 있는 작업이 더 큰 경우
            else{
                answer[answerIdx] = completeWork;
                answerIdx += 1;
                completeWork = 1;
                preMax = restProgresses[i];
            }
        }
        // 마지막 값 저장하기
        answer[answerIdx] = completeWork;
        answerIdx += 1;
        
        answer = Arrays.copyOf(answer, answerIdx);
        
        return answer;
    }
    
    // 작업 남은 일 수 구하는 함수
    public int getWorkDays(int progress, int speed) {
        int rest = 100-progress;
        if(rest%speed != 0)
            return (rest/speed) + 1;
        else return rest/speed;
    }
}