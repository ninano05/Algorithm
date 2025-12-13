import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int target = Integer.parseInt(br.readLine());
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }       
        bw.write(getTarget(list, target)+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static int getTarget(ArrayList<Integer> list, int target) {
        int sum=0;
        for(int i=0; i<list.size(); i++) {
            if(list.get(i)==target)
                sum++;
            else continue;
        }
        return sum;
    }
}