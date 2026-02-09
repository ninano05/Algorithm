import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        // 오름차순으로 정렬
        Arrays.sort(citations);
        
        // 중간 값이 오른쪽 요소의 개수보다 많은지 적은지  binary
        int max = citations.length-1;
        int left = 0;
        int right = citations.length-1;
        int mid = 0;
        
        while(left <= right) {
            mid = (left+right) / 2;

            if(citations[mid] >= (max-mid)+1) {
                answer = (max-mid)+1;
                right = mid - 1;
            } else {
                
                left = mid + 1;
            }
        }
        
        
        return answer;
    }
}