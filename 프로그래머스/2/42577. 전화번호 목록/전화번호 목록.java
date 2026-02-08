import java.util.*;
import java.io.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        // 사전식 정렬
        Arrays.sort(phone_book);
       
        // 앞의 문자가 뒤의 문자의 접두어인지 비교
        for(int i=1;i<phone_book.length;i++) {
            if(phone_book[i].startsWith(phone_book[i-1])){
                answer = false;
                break;
            }
        }
        
        return answer;
    }
}