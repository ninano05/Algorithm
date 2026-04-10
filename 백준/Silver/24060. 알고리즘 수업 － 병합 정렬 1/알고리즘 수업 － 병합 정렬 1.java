import java.util.*;
import java.io.*;

public class Main {
    static int[] A, tmp;
    static int K;
    static int count = 0;
    static int answer = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N];
        tmp = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        merge_sort(0, N-1);
        sb.append(answer);
        System.out.print(sb);
        br.close();
    }

    public static void merge_sort(int p, int r) {
        if(p < r) {
            int q = (p+r)/2;
            merge_sort(p, q);
            merge_sort(q+1, r);
            merge(p, q, r);
        }
    }

    public static void merge(int p, int q, int r) {
        int i = p; // 왼쪽 배열의 시작
        int j = q+1; // 오른쪽 배열의 시작
        int t = 0; // 새로 담을 배열 위치

        // 정렬된 두배열 합치기
        while(i<=q && j <=r) { // 각각의 배열이 자신의 크기 넘기 전까지
            if(A[i] <= A[j]) { // 왼쪽 배열의 시작이 더 작으면
                tmp[t++] = A[i++]; // 왼쪽 먼저 넣기
            }
            else { // 오른쪽 배열의 시작이 더 작으면
                tmp[t++] = A[j++]; // 오른쪽 먼저 넣기
            }
        }
        // 왼쪽 배열이 남았다면
        while(i <= q){
            tmp[t++] = A[i++];
        }
        // 오른쪽 배열이 남았다면
        while(j <= r) {
            tmp[t++] = A[j++];
        }
        // 다시 원래 배열 A에 넣어주기
        i = p; // 왼쪽 시작점
        t = 0; // 복사한 배열의 시작점
        while(i <= r) {
            A[i] = tmp[t]; // 배열 A에 넣어주기
            count++; // 몇번째로 배열 A에 넣어주는지 저장
            if(count == K) { // k번째가 되면 정답 저장
                answer  = A[i];
            }
            i++;
            t++;
        }
    }
}