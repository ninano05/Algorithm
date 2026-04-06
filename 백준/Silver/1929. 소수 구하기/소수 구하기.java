import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[] isComposite = new boolean[N+1]; // true 면 소수 아님, false면 소수

        for(int i=2; i*i<=N; i++) {
            if(!isComposite[i]) { // 초기값은 모두 false
                for(int j=i*i; j <=N; j+=i) { // i*i 보다 작은 수는 이미 이전 단계에서 지워짐
                    isComposite[j] = true;
                }
            }
        }

        for(int i=M; i <=N; i++) {
            if( i>=2 && !isComposite[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }
}