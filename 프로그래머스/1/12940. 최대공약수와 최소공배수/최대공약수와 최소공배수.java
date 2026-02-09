class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        answer[0] = getMax(Math.max(n, m), Math.min(n,m));
        answer[1] = getMin(Math.max(n, m), Math.min(n,m));
        
        return answer;
    }
    
    // 최대 공약수 반환 함수 n>m
    public Integer getMax(int n, int m) {
        while(m != 0) {
            int r = n % m;
            n = m;
            m = r;
        }
        return n;
    }
    
    // 최소 공배수 반환 함수
    public Integer getMin(int n, int m) {
        return (n*m)/getMax(n, m);
    }
}