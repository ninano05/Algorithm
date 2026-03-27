import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        int min = 0;

        for(int i=m; i<=n; i++) {
            if(isPrime(i)){
                sum+=i;
                if(min == 0) min = i; // 처음 소수 값 하나만 넣어주기(최소)
            }
        }
        if(min == 0) bw.write("-1");
        else bw.write(sum+"\n"+min);

        bw.flush();
        bw.close();
        br.close();
    }
    public static boolean isPrime(int n) {
        if(n < 2) return false;
        for(int i=2; i*i<=n;i++) {
            if(n%i==0) return false;
        }
        return true;
    }
}
