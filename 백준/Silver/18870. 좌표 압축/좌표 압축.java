import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 압축한 뒤 값은 => 입력된 값 중 나보다 작은 녀석들의 개수(똑같은 경우 제외)
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] sorted = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); // 입력 값 넣어줌
            sorted[i] = arr[i]; // 입력 값 똑같이 넣어줌
        }

        // 오름차순 정렬
        Arrays.sort(sorted);

        Map<Integer, Integer> map = new HashMap<>();
        int rank = 0; // 압축 좌표 값

        for(int i=0; i<N; i++) {
            if(!map.containsKey(sorted[i])) { // 이번 좌표 값이 map의 key에 없으면
                map.put(sorted[i], rank++); // 값을 넣어주고, 해당하는 값의 압축 좌표를 같이 넣어주고 압축 값+1
                // => 중복을 방지함
            }
        }
        for(int i=0; i<N; i++) {
            bw.write(map.get(arr[i])+" "); //map의 key값으로 빠르게 순서에 해당하는 압축좌표 찾을 수 있음
        }

        bw.flush();
        bw.close();
        br.close();
    }
}