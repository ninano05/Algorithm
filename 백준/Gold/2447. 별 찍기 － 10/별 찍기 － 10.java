import java.util.*;
import java.io.*;

public class Main {
    static char[][] star;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        star = new char[N][N];

        // 기본 바탕 채우기
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                star[i][j] = ' ';
            }
        }
        // 재귀로 별 그리기
        drawStar(0, 0, N);

        for(int i=0; i<N; i++) {
            sb.append(star[i]);
            sb.append("\n");
        }

        System.out.print(sb);
        br.close();
    }

    public static void drawStar(int x, int y, int len) {
        if(len == 1) {
            star[x][y] = '*';
            return;
        }

        int next = len/3;

        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                // 가운데 공백인 공간
                if(i == 1 && j ==1) continue;
                drawStar(x+i * next, y+j*next, next); // 여기서 (3,3) 인경우 제외하고 모두 반복문 8번 돌아감
            }
        }
    }

}