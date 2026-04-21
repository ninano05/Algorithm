import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null; // 이렇게 해야 사용가능

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            int M = Integer.parseInt(br.readLine());

            // 중앙값을 기준 왼쪽 오른쪽 나누어서 저장하기
            // 왼쪽 앞 혹은 오른쪽 앞은 중앙값이 될 수 있음(내가 선택)
            PriorityQueue<Integer> left = new PriorityQueue<>((a,b) -> b-a); // 왼쪽
            PriorityQueue<Integer> right = new PriorityQueue<>(); // 오른쪽

            // 중앙값 개수 = 홀수의 개수 (그냥 계산 가능)
            int midNum = (M+1) / 2;
            sb.append(midNum).append("\n");

            // 중앙 값 출력 반복문
            for(int i=1; i<=M; i++) {

                if((i%10) == 1) { // 자동으로 몇 번째인지 관리
                    st = new StringTokenizer(br.readLine(), " ");
                }
                // 이번에 큐에 넣을 숫자
                int num = Integer.parseInt(st.nextToken());

                // 큐에 넣기
                if(left.size() == right.size()) {
                    // 같을 때 왼쪽으로 넣는다 -> 왼쪽이 하나더 많아지기에 왼쪽 맨 앞에 중앙값이 있음
                    left.offer(num);
                } else {
                    // 다를 때 오른 쪽 -> 양쪽 크기 같아짐
                    right.offer(num);
                }

                // 순서 확인
                // left, right 앞 크기 비교해서 이상하면 자리 바꾸기 (left, right는 알아서 정렬되기 때문에)
                if(!left.isEmpty() && !right.isEmpty() && left.peek() > right.peek()) {
                    int temp = left.poll();
                    left.offer(right.poll());
                    right.offer(temp);
                }

                // 홀수면 중앙값 출력
                if(i%2 == 1) {
                    sb.append(left.peek()).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}