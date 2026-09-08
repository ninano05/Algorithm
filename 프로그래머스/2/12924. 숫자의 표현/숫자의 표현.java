class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int group = 1; // 몇개의 숫자 세트인지
        while(n >= hap(group)) {
            int cur = n - hap(group-1);
            
            if(cur%group == 0) {
                answer++;
            }
            group++;
        }
        
        // 1~N까지 반복한다고 치자
        // 1개면 그대로
        // 2개면 1을 놔두고 나누기 2
        // 3개면 1+2를 놔두고 나누기 3
        // 4개면 1+2+3을 놔두고 나누기 4
        
        return answer;
    }
    
    public int hap(int n) {
        return n*(n+1)/2;
    }
}