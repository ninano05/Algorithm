import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        // 이 차원 배열의 원소 중 작은 거 앞 큰 거 뒤
        for(int i=0;i<sizes.length;i++) {
            int tempt = 0;
            if(sizes[i][0] > sizes[i][1]) { // 앞이 더 큰 경우 => 자리 바꾸기
                tempt = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tempt;
            }
        }
        
        int w = 0;
        int h = 0;
        // 전체 탐색 해서 가장 큰 값 선택
        for(int i=0;i<sizes.length;i++) {
            if(w < sizes[i][0]) {
                w = sizes[i][0];
            }
            if(h < sizes[i][1]) {
                h = sizes[i][1];
            }
        } 
        // 곱하면 끝
        answer = w*h;
        
        return answer;
    }
}