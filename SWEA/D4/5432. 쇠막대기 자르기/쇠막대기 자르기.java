import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 레이저가 자를 때마다 현재 겹쳐진 막대 만큼 토막이 생겨남
        // 막대가 종료되면 하나 토막 생겨나고, 현재 겹쳐진 토막 감소 시키기

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            Stack<Character> stack = new Stack<>(); // 현재 겹쳐진 토막 표시용
            int count = 0; // 잘려진 조각의 개수

            String s = br.readLine();
            // 조각 개수 세기
            for(int i=0; i<s.length(); i++) {
                char c = s.charAt(i);

                if(c == ')') { // 닫는 괄호가 나옴
                    stack.pop(); // 레이저 짝'(' 빼기 [혹은] 토막 '(' 빼기

                    if(s.charAt(i-1) == '(') { // 이전이 닫는 괄호 즉 레이저라면
                        count += stack.size(); // 현재 겹쳐진 토막 만큼 자른 개수 추가
                    } else { // 토막 하나가 종료 된거라면
                        count += 1; // 종료된 토막의 나머지 조각 더하기
                    }
                } else{
                    // 닫는 괄호가 아니면 그냥 stack에 추가
                    stack.push(c);
                }
            }
            sb.append("#").append(t).append(" ").append(count).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}