import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int minH; // 수평 최소 길이
        int minV; // 수직 최소 길이

        if(x > (w - x)) minH = w-x;
        else minH = x;

        if(y > h-y) minV = h-y;
        else minV = y;

        if(minH > minV) bw.write(minV+"");
        else bw.write(minH+"");

        bw.flush();
        bw.close();
        br.close();
    }
}
