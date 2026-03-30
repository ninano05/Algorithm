import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int maxX = -10001;
        int minX = 10001;
        int maxY = -10001;
        int minY = 10001;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(maxX <= x) maxX = x;
            if(minX >= x) minX = x;
            if(maxY <= y) maxY = y;
            if(minY >= y) minY = y;
        }
        int area = (maxX-minX) * (maxY-minY);

        bw.write(area+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
