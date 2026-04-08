import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 인접한 블록은 2개뿐.
        // 하나의 블록에서 택할 수 있는 경우는 2가지뿐이다.
        // 바닥으로 내려오는 경우의 수도 고려해야 한다.
        int N = Integer.parseInt(br.readLine());
        int road = 1;
        for(int i=0; i<N; i++) {
            road *= 2;
        }
        sb.append(road);
        System.out.print(sb);
        br.close();
    }
}