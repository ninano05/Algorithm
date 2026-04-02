import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] score = new int[N];

        // 점수 입력 받기
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }

        //  오름차순 정렬
        Arrays.sort(score);

        bw.write(score[score.length-k]+"");
        bw.flush();
        bw.close();
        br.close();
    }

}