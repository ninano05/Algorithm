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
        
        // 1이 제일 큰 경우 2가 3이
        if(check1>check2 && check1>check3){
            list.add(1);
        } else if(check2>check1 && check2>check3) {
            list.add(2);
        } else if(check3>check1 && check3>check2) {
            list.add(3);
        } else if(check1 == check2 && check1 > check3) {
            list.add(1);
            list.add(2);
        } else if(check1 == check3 && check1 > check2) {
            list.add(1);
            list.add(3);
        } else if(check3 == check2 && check3 > check1) {
            list.add(2);
            list.add(3);
        } else if(check1 == check2 && check1 == check3) {
            list.add(1);
            list.add(2);
            list.add(3);
        }

        answer = list.stream().mapToInt(i -> i).toArray();
        
        return answer;
    }
}