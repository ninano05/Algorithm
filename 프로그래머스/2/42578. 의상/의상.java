import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        // 종류로 개수 해시 만들기
        HashMap<String, Integer> map = new HashMap<>();
        for(String[] c : clothes) {
            map.put(c[1], map.getOrDefault(c[1], 0) + 1);
        }
        
        // 선택지는 n+1개임 -> a착용, b착용, 미착용
        // 즉 모두를 곱하고 전부 안쓰는 경우인 1을 빼면 됨
        for(int n : map.values()) {
            answer = answer * (n+1);
        }
        answer = answer -1;
        
        return answer;
        
    }
}