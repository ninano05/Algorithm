import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            int M = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> pq = new PriorityQueue<>(); // 메인

            // 입력되는 수 받아두는 배열
            int[] nums = new int[M+1]; // 배열과 입력 순서 인덱스를 맞추기 위해
            int numsIdx = 1; // 0은 없는 자리 취급
            int row = (int) Math.ceil((float)M/10); // 입력되는 줄의 수
            // 숫자 배열에 저장해두기
            for(int i=0; i<row; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                while(st.hasMoreTokens()) {
                    nums[numsIdx] = Integer.parseInt(st.nextToken());
                    numsIdx++;
                }
            }

            StringBuilder mSb = new StringBuilder();
            int num = 0; // 중앙값 개수
            // 중앙 값 출력 반복문
            for(int i=1; i<=M; i++) { // 입력 배열 인덱스와 동일
                if(i%2 == 1) { // 홀수 일때
                    pq.offer(nums[i]);
                    PriorityQueue<Integer> temp = new PriorityQueue<>(pq); // 복사해서 사용하기
                    // 앞에 애들 버리기
                    for(int j=0; j<(pq.size()-1)/2; j++) {
                        temp.poll();
                    }
                    mSb.append(temp.poll()).append(" "); // 중앙값 출력
                    num ++;
                } else { // 짝수일 때는 값을 넣어주기만
                    pq.offer(nums[i]);
                }
            }
            sb.append(num).append("\n").append(mSb).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}