import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        ArrayList<Integer> list;
        while(true) {
            int n = Integer.parseInt(br.readLine());
            if(n == -1) break; // 입력 검증

            list = new ArrayList<>();
            int sum = 1; // 초기값
            list.add(1);

            for(int i=2; i*i<=n; i++) {
                // 앞의 절반의 약수들
                // 뒤의 절반의 약수들
                // 거듭제곱근은 빼고
                if(n%i==0) {
                    sum+=i;
                    list.add(i);
                    if(i*i != n) {
                        sum+=n/i;
                        list.add(n/i);
                    }
                }
            }
            Collections.sort(list);

            if(sum == n) {
                bw.write(n+" = ");
                for(int num : list) {
                    if(num == list.get(list.size()-1)) bw.write(num+ "\n");
                    else bw.write(num+" + ");
                }
            } else {
                bw.write(n+" is NOT perfect.\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
