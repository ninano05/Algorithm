import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = {};
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<prices.length-1;i++) {
            int count = 0;
            for(int j=i+1; j<prices.length;j++) {
                count ++;
                // 내가 더 크면 가격 떨어짐 -> 종료 및 다음 i 확인
                // 다음이 더 크면 가격 안 떨어짐 -> 다음 j 비교
                if(prices[i] > prices[j]) {
                    list.add(count);
                    break;
                }
                // 만약 끝까지 안떨어지면
                if(j == prices.length -1)
                    list.add(count);
            }
        }
        // 마지막 가격은 뒤에 가격이 없어서 떨어지지 않음
        list.add(0);
        
        answer = list.stream().mapToInt(i -> i).toArray();
        
        return answer;
    }
}