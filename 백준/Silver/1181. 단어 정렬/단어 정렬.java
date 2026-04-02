import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        for(int i=0; i<N; i++){
            set.add(br.readLine()); // 중복 제거해서 들어감
        }

        ArrayList<String> list = new ArrayList<>(set);

        Collections.sort(list, (a,b) -> {
            if(a.length() == b.length()) return a.compareTo(b);
            return a.length() - b.length();
        });

        for(String s : list) {
            bw.write(s+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}