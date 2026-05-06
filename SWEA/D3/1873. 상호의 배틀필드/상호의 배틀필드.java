import java.util.*;
import java.io.*;

class Solution
{
	static char[][] map;
    static int r;
    static int c;
    static int H;
    static int W;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken()); //행
            W = Integer.parseInt(st.nextToken()); //열

            // 시작 전차 위치
            r = 0;
            c = 0;

            // 맵 입력 받기
            map = new char[H][W];
            for(int i=0; i<H; i++) {
                String s = br.readLine();
                for(int j=0; j<W; j++) {
                    map[i][j] = s.charAt(j);
                    if(map[i][j] == '<' || map[i][j] == '>' ||
                    map[i][j] == '^' || map[i][j] == 'v') {
                        r = i;
                        c = j;
                    }
                }
            }

            // 명령어 입력 받기
            int C = Integer.parseInt(br.readLine());
            String command = br.readLine(); // 명렁

            // 명령어 하나씩 처리하기
            for(int d=0; d<C; d++) {
                getOrder(command.charAt(d));
            }
            sb.append("#").append(t).append(" ");
            for(int i=0; i<H; i++) {
                for(int j=0; j<W; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }


    // 전차 명령어 처리 함수
    public static void getOrder(char com) {
        switch(com) {
            case 'U':
                if(r-1>=0) {
                    if(map[r-1][c] == '.') {
                        map[r][c] = '.'; // 원래 있던 곳 평지로
                        map[r-1][c] = '^'; // 전차 이동
                        r-=1; // 전차 위치 조정
                    }
                    else { // 평지가 아닌 경우
                        map[r][c] = '^'; // 전차 방향만 전환
                    }
                } else { // 맵의 끝이라면 방향만 전환
                    map[r][c] = '^'; // 전차 방향만 전환
                }
                break;
            case 'D':
                if(r+1 < H){
                    if(map[r+1][c] == '.') {
                        map[r][c] = '.'; // 원래 있던 곳 평지로
                        map[r+1][c] = 'v'; // 전차 이동
                        r+=1; // 전차 위치 조정
                    }
                    else { // 평지가 아닌 경우
                        map[r][c] = 'v'; // 전차 방향만 전환
                    }
                } else {
                    map[r][c] = 'v'; // 전차 방향만 전환
                }
                break;
            case 'L':
                if(c-1>=0) {
                    if(map[r][c-1] == '.') {
                        map[r][c] = '.'; // 원래 있던 곳 평지로
                        map[r][c-1] = '<'; // 전차 이동
                        c-=1; // 전차 위치 조정
                    }
                    else { // 평지가 아닌 경우
                        map[r][c] = '<'; // 전차 방향만 전환
                    }
                } else { // 맵의 끝이라면 방향만 전환
                    map[r][c] = '<'; // 전차 방향만 전환
                }
                break;
            case 'R':
                if(c+1<W) {
                    if(map[r][c+1] == '.') {
                        map[r][c] = '.'; // 원래 있던 곳 평지로
                        map[r][c+1] = '>'; // 전차 이동
                        c+=1; // 전차 위치 조정
                    }
                    else { // 평지가 아닌 경우
                        map[r][c] = '>'; // 전차 방향만 전환
                    }
                } else {
                    map[r][c] = '>'; // 전차 방향만 전환
                }
                break;
            case 'S': // 부수기 가능한 벽 부수기
                if(map[r][c] == '^'){
                    int bullet = r-1; // 총알 위치
                    while(bullet>=0) {
                        if (map[bullet][c] == '*') {
                            map[bullet][c] = '.';
                            break;
                        } else if(map[bullet][c] == '.' || map[bullet][c] == '-'){ // 평지면 통과
                            bullet -= 1;
                        } else {
                            break;
                        }
                    }
                }
                else if(map[r][c] == 'v') {
                    int bullet = r+1; // 총알 위치
                    while(bullet<H) {
                        if (map[bullet][c] == '*') {
                            map[bullet][c] = '.';
                            break;
                        } else if(map[bullet][c] == '.' || map[bullet][c] == '-'){
                            bullet += 1;
                        } else {
                            break;
                        }
                    }
                }
                else if(map[r][c] == '<') {
                    int bullet = c-1; // 총알 위치
                    while(bullet>=0) {
                        if (map[r][bullet] == '*') {
                            map[r][bullet] = '.';
                            break;
                        } else if(map[r][bullet] == '.' || map[r][bullet] == '-'){
                            bullet -= 1;
                        } else {
                            break;
                        }
                    }
                }
                else if(map[r][c] == '>') {
                    int bullet = c+1; // 총알 위치
                    while(bullet<W) {
                        if (map[r][bullet] == '*') {
                            map[r][bullet] = '.';
                            break;
                        } else if(map[r][bullet] == '.' || map[r][bullet] == '-'){
                            bullet += 1;
                        } else {
                            break;
                        }
                    }
                }
                break;
        }
    }
}