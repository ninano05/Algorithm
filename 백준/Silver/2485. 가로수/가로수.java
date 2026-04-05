import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] tree = new int[N]; // 나무 심어진 위치
        for(int i=0; i<N; i++) {
            tree[i] = Integer.parseInt(br.readLine());
        }

        int[] interval = new int[N-1]; // 나무 사이 간격
        int sum = 0; // 나무 사이 간격 합
        for(int i=0; i<N-1; i++) {
            interval[i] = tree[i+1] - tree[i];
            sum+=interval[i];
        }

        int interGcd = interval[0];
        // 간격들의 최대 공약수
        for(int i=1; i<interval.length; i++) {
            interGcd = gcd(interGcd, interval[i]);
        }

        // 심어야 하는 나무 개수 구하기
        int num = sum/interGcd - interval.length;

        sb.append(num);
        System.out.print(sb);
        br.close();
    }

    public static int gcd(int a, int b) {
        while( b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

}