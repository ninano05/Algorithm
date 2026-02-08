import java.util.*;
import java.io.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = new int[arr.length];
        
        // 초기 숫자 0번은 집어넣기
        answer[0] = arr[0];
        int answerIdx = 1;
        
        // 이전 숫자랑 다르면 꺼내서 저장 아니면 넘어가기
        for(int i=1;i<arr.length;i++) {
            // 이전 숫자랑 다를 때
            if(arr[i] != arr[i-1]) {
                answer[answerIdx] = (arr[i]);
                answerIdx += 1;
            }
            // 이전 숫자랑 다를 때
            // 그냥 넘어가세요
        }
        
        answer = Arrays.copyOf(answer, answerIdx);

        return answer;
    }
}