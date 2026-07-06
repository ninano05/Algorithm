import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        // 전체 칸 개수
        int total = brown + yellow;
        
        // 전체 약수 구하기
        // 작은 쪽 약수만 저장(세로)
        ArrayList<Integer> list = new ArrayList<>(); 
        
        // 약수 구하기
        for(int i=1; i*i<=total; i++) {
            // 나누어 떨어지면 약수
            if(total%i == 0) {
                list.add(i);
            }
        }
        
        // 노란색과 개수가 동일하면 정답
        for(int col : list) { // 항상 세로임
            if(col < 3) continue; // 노란색이 가운데여야 하기에
            
            int row = total/col;
            int temptY = (col-2)*(row-2);
            if(temptY == yellow) {
                answer = new int[]{row, col};
                break;
            }
        }
        
        return answer;
    }
}