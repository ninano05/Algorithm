import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        
        // 1번 12345 => 5번
        // 2번 21232425 => 8번
        // 3번 3311224455 => 10번
        
        int[] s1 = {1,2,3,4,5};
        int[] s2 = {2,1,2,3,2,4,2,5};
        int[] s3 = {3,3,1,1,2,2,4,4,5,5};
        
        int check1 = 0;
        int check2 = 0;
        int check3 = 0;
        
        for(int i=0;i<answers.length;i++) {
            if(answers[i] == s1[i%5]) {
                check1 ++;
            }
            if(answers[i] == s2[i%8]) {
                check2 ++;
            }
            if(answers[i] == s3[i%10]) {
                check3 ++;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        
        if(check1>check2) {
            if(check2 > check3) result.add(1);
            
        }
        
        List<Integer> list = new ArrayList<>();
        
        // 최대 점수 구하기
        int maxScore = Math.max(check1, Math.max(check2, check3));
        // 같은 점수일 경우만 배열에 포함
        if(check1 == maxScore) list.add(1);
        if(check2 == maxScore) list.add(2);
        if(check3 == maxScore) list.add(3);

        answer = list.stream().mapToInt(i -> i).toArray();
        
        return answer;
    }
}