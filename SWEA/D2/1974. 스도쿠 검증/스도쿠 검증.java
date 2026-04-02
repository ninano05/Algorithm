import java.util.*;
import java.io.*;

class Solution
{
    static int[][] sudoku = new int[9][9];
    
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            // 수도쿠 입력
            for(int pr=0; pr<9; pr++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for(int pc=0; pc<9; pc++) {
                    sudoku[pr][pc] = Integer.parseInt(st.nextToken());
                }
            }

            // 행 검사
            int row = checkRow();
            // 열 검사
            int col = checkCol();
            // 3*3 검사
           int arr = 0;
            loop:
            for(int i=0; i<9; i=i+3) {
                for(int j=0; j<9; j=j+3) { // 3*3 (i,j)는 시작점
                    arr = checkArray(i, j);
                    break loop;
                }
            }
            int answer = 1;
            if((row+col+arr) > 0) answer = 0;
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
	}
    
    // 행 검사 메소드
    public static int checkRow() {
        int answer = 0;
        for(int i=0; i<9; i++) {
            int[] row = sudoku[i];
            if(isSameNumber(row)) answer = 1;
        }
        return answer;
    }
    // 열 검사 메소드
    public static int checkCol() {
        int answer = 0;
        for(int i=0; i<9; i++) { // 열
            int[] col = new int[9];
            for(int j=0; j<9; j++) { // 행
                col[j] = sudoku[j][i];
            }
            if(isSameNumber(col)) answer = 1;
        }
        return answer;
    }
    // 3*3 검사 메소드
    public static int checkArray(int r, int c) { // 시작 점
        int answer = 0;
        int[] array = new int[9];
        int index = 0;

        for(int i=r; i<r+3; i++) {
            for(int j=c; j<c+3; j++) {
                array[index] = sudoku[i][j];
                index++;
            }
        }
        if(isSameNumber(array)) answer = 1;
        return answer;
    }
    // 같은 숫자 존재 검증 메소드
    public static boolean isSameNumber(int[] numArray) {
        // 첫번째 방법) 9개니까 하나하나 비교 검증하기
        // 두번째 방법) hashmap으로 개수 계산하기
        boolean answer = false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<numArray.length; i++) {
            map.put(numArray[i], map.getOrDefault(numArray[i], 0)+1);
        }

        for(int n : map.keySet()) {
            if(map.get(n) >= 2) answer = true;
        }
        return answer;
    }
}