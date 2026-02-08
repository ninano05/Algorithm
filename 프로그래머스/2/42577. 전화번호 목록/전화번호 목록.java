import java.util.*;
import java.io.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        // 빈 해시
        HashMap<String, Integer> phone = new HashMap<>();
        
        // 전화번호로 채우기
        for(String num : phone_book) {
            phone.put(num, 1);
        }
        
        // 번호의 모든 접두어 검사하기
        for(String num : phone_book) {
            for(int i=1;i<num.length();i++) {
                String perfix = num.substring(0, i);
                if(phone.containsKey(perfix)) {
                    answer = false;
                    break;
                }
            }
            if(answer == false) break;
        }
        
        return answer;
    }
}