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
            String[] word = new String[5]; // 단어 저장 배열

            int max = 0; // 가장 긴 단어 길이

            // 단어 입력 받기
            for(int i=0; i<5; i++) {
                word[i] = br.readLine();
                max = Math.max(word[i].length(), max);
            }

            // 단어 세로로 출력하기
            sb.append("#").append(t).append(" ");
            for(int i=0; i<max; i++) { // 열
                for(int j=0; j<5; j++) { // 행
                    if (i < word[j].length()) {
                        sb.append(word[j].charAt(i));
                    }
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}