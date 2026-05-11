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
            int N = Integer.parseInt(br.readLine());

            int[] A = new int[N]; // 수 저장할 배열

            st = new StringTokenizer(br.readLine());
            // 입력 받기
            for(int i=0; i<N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            // 최대 단조 증가하는 수 찾기
            int max = 0; // 최대 숫자 (최대 900,000,000)
            boolean res = false;
            for(int i=0; i<N; i++) { //Ai
                for(int j=i+1; j<N; j++) { //Aj
                    int num = A[i]*A[j];
                    if(isRight(num)) {
                        res = true;
                        max = Math.max(max, num);
                    }
                }
            }
            sb.append("#").append(t).append(" ");
            if(res) sb.append(max).append("\n");
            else sb.append("-1").append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    // 단조 증가하는 수인지 판별하는 함수
    public static boolean isRight(int num) {
        String numS = String.valueOf(num);

        for(int i=1; i<numS.length(); i++) {
            if(numS.charAt(i-1) > numS.charAt(i)) return false;
        }

        return true;
    }
}