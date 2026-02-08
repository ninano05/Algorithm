class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        // 괄호 앞이 들어오면 +
        // 괄호 뒤가 들어오면 -
        // 결과적으로 0이 되면 참
        // 대신 과정에서 음수가 뜨게되면 무조건 거짓
        // 양수는 관계 없음 최종적으로 0이 된다면
        
        StringBuilder sb = new StringBuilder(s);
        int sum = 0;
        for(int i=0;i<sb.length();i++) {
            if(sb.charAt(i) == '('){
                sum += 1;
            }
            else{
                sum -= 1;
                if(sum < 0)
                    break;
            }
        }

        if(sum < 0) answer = false;
        else if(sum > 0) answer = false;

        return answer;
    }
}