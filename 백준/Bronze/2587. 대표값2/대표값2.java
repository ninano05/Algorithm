import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[5];
        int sum = 0;

        for(int i=0; i<5; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        int avg = sum / 5;

        // 버블 정렬
        for(int i=0; i<4; i++) {
            for(int j=0; j<4-i; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        int med = arr[2];

        bw.write(avg+"\n"+med);
        bw.flush();
        bw.close();
        br.close();
    }

}