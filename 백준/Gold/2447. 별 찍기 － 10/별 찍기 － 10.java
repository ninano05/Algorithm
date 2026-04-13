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
                star[i][j] = '*';
            }
        }
        // 재귀로 공백 뚫기
        getShape(0, 0, N);
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                sb.append(star[i][j]);
            }
            sb.append("\n");
        }

        System.out.print(sb);
        br.close();
    }

    // 가운데를 공백으로 바꾸는 로직
    public static void getShape(int x, int y, int len) { // 현재 좌상단 x,y 좌표, 한변의 길이
        if(len == 1) return;
        // 공백이 생기는 좌상단 좌표
        int startX = x + len/3;
        int startY = y + len/3;

        int nLen = len/3; // 다음 변의 길이이자, 현재 길이의 3등분

        for(int i=startY; i<startY+nLen; i++) {
            for(int j=startX; j<startX+nLen; j++) {
                star[i][j] = ' ';
            }
        }

        // 8개 불러야 함
        getShape(x, y, nLen);
        getShape(x+nLen, y, nLen);
        getShape(x+nLen*2, y, nLen);

        getShape(x, y+nLen, nLen);
        // 가운데 공백 공간은 제외
        getShape(x+nLen*2, y+nLen, nLen);

        getShape(x, y+nLen*2, nLen);
        getShape(x+nLen, y+nLen*2, nLen);
        getShape(x+nLen*2, y+nLen*2, nLen);
    }

}