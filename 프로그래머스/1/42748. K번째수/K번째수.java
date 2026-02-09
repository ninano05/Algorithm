import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        
        List<Integer> result = new ArrayList<>(); // 숫자 뽑 아서 저장 배열
        
        for(int i=0;i<commands.length;i++) {
            List<Integer> arr = new ArrayList<>(); // 저장할 배열
            for(int j=commands[i][0]-1;j<commands[i][1];j++) {
                arr.add(array[j]);
            }
            arr.sort((a, b) -> a -b);
            result.add(arr.get(commands[i][2]-1));
        }
        
        answer = result.stream().mapToInt(i->i).toArray();
        
        return answer;
    }
}