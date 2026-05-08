import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            // 점에 대한 좌표 찾아오기
            int[] pXY = getPosition(p);
            int[] qXY = getPosition(q);

            int c = pXY[0] +qXY[0];
            int r = pXY[1] +qXY[1];

            // 좌표에 대한 점 찾아오기
            int res = getSpot(c, r);
            sb.append("#").append(t).append(" ").append(res).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    // 점의 좌표를 구하는 함수
    public static int[] getPosition(int num) {
        int n = 0; // 몇번째 대각선인지
        int start = 0; // 대각선 시작 번호
        int end = 0; // 대각선 끝 번호

        while(true) {
            // 포함 안 되면 n 크게
            n++;
            // 대각선 시작 번호
            start = n*(n-1)/2 +1;
            // 대각선 끝 번호
            end = (n+1)*n/2;
            // 그 사이라면 대각선에 포함 됨
            if(num>=start && num<=end) {
                break;
            }
        }

        // n번 째 대각선에 위치함
        int move = num - start; // 시작번호 부터의 이동 거리
        int c = 1 + move; // 열은 무조건 1부터 시작(x)
        int r = n - move; // 시작 행은 대각선 번째와 동일(y)

        return new int[]{c, r};
    }
    public static int getSpot(int c, int r) { // x, y
        int n = c + r - 1; // 몇번째 대각선인지
        return  ((n-1)+1)*(n-1)/2 + c;
    }
}