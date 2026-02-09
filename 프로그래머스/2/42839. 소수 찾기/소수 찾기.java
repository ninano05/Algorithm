import java.util.*;
import java.io.*;

class Solution {
    HashSet<Integer> numberSet = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        
        
        // 1. 모든 숫자 조합 만들기 (재귀 함수 호출)
        recursive("", numbers);

        // 2. 소수 개수 세기
        for (int num : numberSet) {
            if (isPrime(num)) answer++;
        }
        
        return answer;
    }
    // 모든 숫자 조합 만들기
    public void recursive(String comb, String numbers) {
        // 현재 조합된 숫자가 있으면 Set에 추가 (011 -> 11로 자동 변환)
        if (!comb.equals("")) {
            numberSet.add(Integer.parseInt(comb));
        }

        // 남은 숫자들 중 하나를 선택해 조합을 이어감
        for (int i = 0; i < numbers.length(); i++) {
            recursive(comb + numbers.charAt(i), 
                      numbers.substring(0, i) + numbers.substring(i + 1));
        }
    }
    
    // 소수 판독
    public boolean isPrime(int n) {
        if(n < 2) return false;
        if(n == 2) return true;
        for(int i=2;i*i<=n;i++) {
            if(n%i==0) return false;
        }
        return true;
    }
}