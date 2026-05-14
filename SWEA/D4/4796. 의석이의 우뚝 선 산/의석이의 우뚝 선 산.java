import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for(int t = 1; t <= T; t++) {

            int N = sc.nextInt();

            int[] H = new int[N];

            for(int i = 0; i < N; i++) {
                H[i] = sc.nextInt();
            }

            int count = 0; // 우뚝 선 산 구간 개수

            // 우뚝 솟은 산 찾기
            // 그 산을 기점으로 양쪽에서 후보 개수 찾기
            // 구간 개수 계산하기
            for(int i=1; i<N-1; i++) { // 양끝은 우뚝 솟은 산 불가능

                // 우뚝 솟은 산인지
                if(H[i] > H[i-1] && H[i] > H[i+1]) { // 우뚝 솟았다면
                    int a = 1;
                    int b = 1;

                    while(true) {
                        if(i-a < 0) { //0보다 작아졌으면 이전 까지임
                            a--;
                            break;
                        }
                        if(H[i-a] > H[i-a+1]) { //여기까지 오면 문제임
                            a--;
                            break;
                        }
                        a++;
                    }

                    while(true) {
                        if(i+b >= N) { //N보다 크거나 같아졌으면 이전 까지임
                            b--;
                            break;
                        }
                        if(H[i+b-1] < H[i+b]) { // 여기까지 오면 문제임
                            b--;
                            break;
                        }
                        b++;
                    }
                    count += (a*b); // 구간 경우의 수 계산
                }
            }
            sb.append("#").append(t).append(" ").append(count).append("\n");
        }

        System.out.print(sb);

        sc.close();
    }
}