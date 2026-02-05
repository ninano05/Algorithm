

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int max = 0;
        // 가장 큰 레벨 찾기
        
        for(int d : diffs ) {
            max = Math.max(max, d);
        }
        
        // n을 이진 탐색으로 찾아보자
        int left = 1;
        int right = max;
        
        while(left <= right) {
            int n = (left + right)/2;
            
            long time = times[0];
            for(int i=1;i<diffs.length;i++) {
                if(diffs[i] <= n) {
                    time = time + times[i];
                }else{
                    time = time + (times[i] + times[i-1])*(diffs[i]-n) + times[i];
                }
            }
            
            if(time <= limit) {
                answer = n;
                right = n - 1;                
            } 
            else {
                left = n + 1;
            }
        }
            
        return answer;
    }
    
}