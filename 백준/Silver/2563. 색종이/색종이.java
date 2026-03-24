import java.util.*;
import java.io.*;

public class Main {
    static int[][] rect; // 사각형 x,y 정보
    static int[][] paper; // 도화지 0은 아무것도 없음, 1은 색종이

    static int maxX;
    static int maxY;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        maxX = 0;
        maxY = 0;
        int n = Integer.parseInt(br.readLine());
        rect = new int[n][2];

        // 색종이 입력 받기
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            rect[i][0] = x;
            rect[i][1] = y;

            if((x+10) > maxX) maxX = x+10;
            if ((y+10) >  maxY) maxY = y+10;
        }

        paper = new int[maxY][maxX];

        bw.write(solution(n)+"");
        bw.flush();
        bw.close();
        br.close();
    }

    // 색종이 만큼 도화지에 칠하기
    public static int solution(int n) {
        int answer = 0;

        for(int i=0; i<n;i++) {
            int x = rect[i][0];
            int y = rect[i][1];

            for(int j=0; j<10; j++) {
                for(int k=0; k<10; k++) {
                    paper[y+k][x+j] = 1;
                }
            }
        }

        for(int j=0; j<maxY; j++) {
            for(int k=0; k<maxX; k++) {
                answer += paper[j][k];
            }
        }
        return answer;
    }

}