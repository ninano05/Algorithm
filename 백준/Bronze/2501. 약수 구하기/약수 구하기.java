import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=1; i <= Math.sqrt(N); i++) {
            if(N%i==0) {
                list.add(i);
                if(i*i != N) { // 거듭 제곱인 경우 제외
                    list.add(N/i);
                }
            }
        }
        Collections.sort(list); // 정렬하기
        if(list.size() < K) {
            bw.write("0");
        } else {
            bw.write(list.get(K-1)+"");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
