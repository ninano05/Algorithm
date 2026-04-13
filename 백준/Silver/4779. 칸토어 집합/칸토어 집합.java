import java.util.*;
import java.io.*;

public class Main {
    static char[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String line;
        while((line = br.readLine()) != null) {
            int N = Integer.parseInt(line);
            int len = (int)Math.pow(3, N);
            arr = new char[len];
            // 초기값 채우기
            for(int i=0; i<len; i++) {
                arr[i] = '-';
            }
            // 가운데만 공백으로 바꾸기
            repeat(0, len);

            sb.append(arr).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
    // 재귀 돌리는 함수
    public static void repeat(int start, int len) { // 전체 길이 넣어주기
        if(len == 1) return;
        int nLen = len/3; // 다음 길이이자, 현재 길이의 3등분

        for(int i=start+nLen; i<start+2*nLen; i++) {
            arr[i] = ' ';
        }

        repeat(start, nLen);
        repeat(start+2*nLen, nLen);
    }
}