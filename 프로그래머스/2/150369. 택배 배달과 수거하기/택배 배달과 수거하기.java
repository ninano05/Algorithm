import java.io.*;
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        // 현재 제일 뒤에 있는 것들 인덱스 관리
        int indexD = -1;
        int indexP = -1;
        
        // 제일 뒤에 배달 가야 하는 집 인덱스
        for(int i=n-1; i>=0; i--) {
            if(deliveries[i] != 0) {
                indexD = i;
                break;
            }
        }
        
        // 제일 뒤에 수거해야 하는 집 인덱스
        for(int i=n-1; i>=0; i--) {
            if(pickups[i] != 0) {
                indexP = i;
                break;
            }
        }
        
        // 다 수거할 때까지 반복
        while(indexD > -1 || indexP > -1) {
            
            // 이번에 조정할 수 있는 상자 개수
            int capD = cap;
            int capP = cap;
            
            // 둘 중에 큰쪽이 이동 거리임
            if(indexD >= indexP) {
                answer += 2*(indexD+1);
            } else {
                answer += 2*(indexP+1);
            }
            
            // 배달하기
            for(int i=indexD; i>=0; i--) {
                // 배달 끝난 상태에서의 인덱스 저장하기 위한 용도
                if(capD == 0 && deliveries[i]!=0) {
                    indexD = i;
                    break;
                } 
                
                // 자리 남아 있으면
                if(capD > 0) {
                    if (deliveries[i] >= capD) {
                        deliveries[i] -= capD;
                        capD = 0;
                    
                        // 아직 배달 더 가야 하면 인덱스 걍 둠
                        if(deliveries[i] > 0) {
                            indexD = i;
                            break;
                        };
                    } else {
                        capD -= deliveries[i];
                        deliveries[i] = 0;
                    }
                }
                
                
                // 마지막까지 비웠으면
                if(i == 0 && deliveries[i] == 0) {
                    indexD = -1;
                    break;
                }
            }
            
            // 수거하기
            for(int i=indexP; i>=0; i--) {
                if(capP == 0 && pickups[i] !=0) {
                    indexP = i;
                    break;
                }
                
                if(capP > 0) {
                    if (pickups[i] >= capP) {
                        pickups[i] -= capP;
                        capP = 0;
                    
                        if(pickups[i]>0) {
                            indexP = i;
                            break;
                        };
                    } else {
                        capP -= pickups[i];
                        pickups[i] = 0;
                    }
                }
                
                // 마지막까지 비웠으면
                if(i == 0 && pickups[i] == 0) {
                    indexP = -1;
                    break;
                }
            }
        }
        
        // 뒤에서부터 출발하기
        // 물건은 가면서도 놓을 수 있음
        // 물건은 무조건 놓을 수 있음
        // 수거는 물건을 다 놓은 다음에 이루어진다
        // => 어찌되든 2 개 중에서 가장 멀리 있는 놈의 거리로 싸이클을 돌게 되는 것임

        
        return answer;
    }
}