import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        
        // 순간이동 한다는 뜻은 짝수라는 뜻
        // 점프 거리를 최소화 해야하기에, 홀수가 나올 때 1 칸 이동이 필요한 것
        // 따라서 최종 N에서 2로 나눠지면 계속 나누고 홀수가 되면 점프로 이동을 
        
        // 최종 거리에서 거꾸로 가기
        while(n != 0) {
            // 짝수이면 2로 나누기(순간이동)
            if(n%2 == 0) {
                n = n/2;
            } else { // 홀수이면 점프 이동
                n = n-1;
                ans++; // 건전지 사용량 더하기
            }
        }

        return ans;
    }
}