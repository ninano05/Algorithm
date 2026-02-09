import java.util.*;
import java.io.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        List<String> list = new ArrayList<>();
        
        // 숫자를 문자로
        for(int n : numbers) {
            list.add(String.valueOf(n));
        }
        // 사전식 정렬(+ 앞 뒤 숫자를 이어 붙였을 때 크기 비교)
        Collections.sort(list, new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                return (a+b).compareTo(b+a);
            }   
        });
        
        // 맨 뒤 문자부터 합치기
        for(int i=list.size();i>0;i--) {
            answer = answer + list.get(i-1);
        }
        if(answer.charAt(0) == '0') answer="0";
        
        
        return answer;
    }
}