import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int max = 123456*2;
        boolean[] composite = new boolean[max+1]; // false인 경우만 소수

        for(int i=2; i*i<=max; i++) {
            if(!composite[i]) {
                for(int j=i*i; j <=max; j+=i) {
                    composite[j] = true;
                }
            }
        }

        while(true) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;

            int count = 0;
            for(int i=n+1; i<=2*n; i++) {
                if(!composite[i]) { // n+1은 2부터 시작함을 보장함
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}