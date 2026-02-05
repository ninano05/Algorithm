class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int now = health; // 현재 체력
        int time = 0; // 현재 시간
        int cureTime = 0; // 치료를 지속한 시간
        int attackNum = 0; // 몇번째 공격까지 들어갔는지(attack[i])
        
        for(int i=0;i<attacks[attacks.length-1][0]+1;i++) {
            if(answer == -1)
                break;
            
            // 공격을 받았을 때
            if(attacks[attackNum][0] == time) {
                now = now - attacks[attackNum][1];
                attackNum += 1;
                if(now <= 0)
                    answer = -1;
                else {
                    time += 1;
                    cureTime = 0;
                }
            }
            else { // 공격을 안 받았을 때
                now = now + bandage[1]; // 상시 회복
                cureTime += 1; // 현재 초 늘림
                if (cureTime == bandage[0]) { // 추가 회복 검증
                    now += bandage[2];
                    cureTime = 0; // 추가회복 초기화
                }
                if(now > health)
                    now = health;
                time += 1;
            }
        }
        if(answer != -1)
            answer = now;
        return answer;
    }
}