import java.util.*;
import java.io.*;

class Solution
{
	static int[][] ladder;
    static int Len = 100;

    static int[] dc = {-1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for(int t=1; t<=10; t++) {
            int T = Integer.parseInt(br.readLine());

            // 변수 초기화
            ladder = new int[Len][Len];

            // 사다리 입력받기
            for(int i=0; i<Len; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<Len; j++) {
                    ladder[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int min = Integer.MAX_VALUE; // 최소 거리
            int start = 0; // 최소 거리일 때의 출발점

            // 출발점 선택하기 (행은 언제나 0)
            for(int i=0; i<Len; i++) {
                if(ladder[0][i] == 1) {
                    // 사다리 끝까지 거리 확인하기
                    int dist = toEnd(i);

                    if(dist <= min) { // 동일할 경우 더 큰 좌표를 선택해야하기에
                        min = dist;
                        start = i;
                    }
                }

            }
            sb.append("#").append(t).append(" ").append(start).append("\n");
        }
        System.out.print(sb);
        br.close();
    }


    // 출발점이 주어졌을 때 탐색하는 함수
    public static int toEnd(int c) {
        int dist = 0; // 총 거리
        int r = 0; // 초기 행

        while(r < Len) { // 가장 아래 행에 도달할 때까지
            // 왼쪽으로 이동 가능하면 끝까지 이동
            if((c-1)>=0 && ladder[r][c-1] == 1) {
                while((c-1)>=0 && ladder[r][c-1] == 1) { // 다음이 1이면 이동하기
                    c--; // 왼쪽으로 이동
                    dist++; // 거리 추가
                }
            }
            // 오른쪽으로 이동 가능하면 끝까지 이동
            else if((c+1)<Len && ladder[r][c+1] == 1) {
                while((c+1)<Len && ladder[r][c+1] == 1) { // 다음이 1이면 이동하기
                    c++; // 오른쪽으로 이동
                    dist++; // 거리 추가
                }
            }
            // 만약 왼쪽 오른쪽 이동 끝나면 아래로 이동
            r++;
            dist++;
        }

        return dist;// 구한 거리 반환하기
    }
}