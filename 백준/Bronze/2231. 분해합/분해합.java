import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = 0; // 생성자가 없는 경우 -> 있다면 생성자로 바꾸기

        // 생각 추가) 범위를 줄여보기
        // 현재 M은 각 자리수 + M이 N값으로 고정되어 있다.
        // 즉 각 자리수 숫자가 커지면, M이 점유할 수 있는 수가 줄어든다.
        // 그리고 M은 N의 자리 숫자보다 커질 수 없다.
        // 그렇다면 M이 차지할 수 있는 영역은?
        // 1부터 구할 필요가 전혀 없음 -> 어차피 1은 아님
        // N의 자리 숫자에 시작 지점 선택에 영향을 받음
        // 시작 위치를 어디로 해야 할까?
        // 각 자리 숫자가 최대 9여서 M이 작아진 경우 (실제로는 불가능이지만, 범위 상 최소 값을 잡기 위함임)
        int start = N-String.valueOf(N).length()*9;

        for(int i=start; i<N; i++) {
            int sum = i;
            int temp = i;
            while(temp > 0) {
                sum = sum + temp % 10;
                temp = temp / 10;
            }
            if(sum == N){
                M = i; // M을 1부터 가정하고 커지기 때문에, 찾는 순간 종료하면 가장 작은 값이다.
                break;
            }
        }
        bw.write(M+"");
        bw.flush();
        bw.close();
        br.close();
    }
}