import java.util.*;
import java.io.*;

public class Main {
    static char[][] matrix;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        matrix = new char[5][15];
        int maxCol = 0;

        for(int i=0; i<5; i++) {
            String s = br.readLine();
            for(int j=0; j<s.length(); j++) {
                matrix[i][j] = s.charAt(j);
            }
            if(s.length()>maxCol) maxCol = s.length();
        }

        bw.write(solution(maxCol));
        bw.flush();
        bw.close();
        br.close();
    }

    public static String solution(int maxCol) {
        String answer = "";

        for(int i=0; i<maxCol; i++) {
            for(int j=0;j<5;j++) {
                if(matrix[j][i] != '\u0000') { // char는 != null 불가능
                    answer += matrix[j][i];
                }
            }
        }

        return answer;
    }

}