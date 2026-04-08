import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] scores = new int[N]; // 총점 배열
            int target = 0; // K번 학생의 총점;
            // 총점 입력
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int score = Integer.parseInt(st.nextToken())*35 +
                        Integer.parseInt(st.nextToken())*45 +
                        Integer.parseInt(st.nextToken())*20;
                scores[i] = score;
                if((i+1) == K) target = score;
            }
            // 정렬
            Arrays.sort(scores);
            // k번 학생이 몇번째에 있는지 구하기
            int index = 0;
            while(true) {
                index++;
                if(scores[index-1] == target) break;
            }
            String grade = getGrade(N, index);
            sb.append("#").append(t).append(" ").append(grade).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    public static String getGrade(int student, int num) { // 전체 학생 수, 등수
        int sec = student/10;
        if(num <= sec) {
            return "D0";
        } else if(num <= sec*2) {
            return "C-";
        } else if(num <= sec*3) {
            return "C0";
        } else if(num <= sec*4) {
            return "C+";
        } else if(num <= sec*5) {
            return "B-";
        } else if(num <= sec*6) {
            return "B0";
        } else if(num <= sec*7) {
            return "B+";
        } else if(num <= sec*8) {
            return "A-";
        } else if(num <= sec*9) {
            return "A0";
        }
        return "A+";
    }
}