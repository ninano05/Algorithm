import java.util.*;
import java.io.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Deque<Character> stack = new ArrayDeque<>();
        
        for(char c : s.toCharArray()) {
            if(c == '(') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) {
                    answer = false;
                    break;
                }
                stack.pop();
            }
        }
        
        if(!stack.isEmpty()) answer = false;

        return answer;
    }
}