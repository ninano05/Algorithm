import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb;
    static int num;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        num = 0;
        hanoi(N, 1, 2, 3);

        System.out.println(num);
        System.out.print(sb);
        br.close();
    }

    // 하노이
    public static void hanoi(int n, int start, int extra, int target) { // 원판 개수, 출발점, 여분, 목표점
        if(n == 1) { // 움직일 원판이 하나 뿐이라면 목표로 바로 이동
            sb.append(start).append(" ").append(target).append("\n");
            num ++;
            return;
        }
        hanoi(n-1, start, target, extra); // 가장 큰 원판이 target으로 가야함, 즉 n-1개의 원판이 extra로 가야함
        sb.append(start).append(" ").append(target).append("\n"); // 제일 큰 원판 이동
        num++;
        hanoi(n-1, extra, start, target); //extra에 치워둔 n-1개의 원판을 다시 target으로 옮기기
    }

}