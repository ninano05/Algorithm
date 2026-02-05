import java.util.*;
import java.io.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int secVideo_len = getTimeToSec(video_len);
        int secPos = getTimeToSec(pos);
        int secOp_start = getTimeToSec(op_start);
        int secOp_end = getTimeToSec(op_end);
        
        for(int i=0; i<commands.length; i++) {
            if(secPos >= secOp_start && secPos <= secOp_end) {
                    secPos = secOp_end;
            }
            
            if (commands[i].equals("prev")) {
                secPos = secPos - 10;
                if(secPos >= secOp_start && secPos <= secOp_end) {
                    secPos = secOp_end;
                }
                if(secPos < 0)
                    secPos = 0;
            }
            else {
                secPos = secPos + 10;
                if(secPos >= secOp_start && secPos <= secOp_end) {
                    secPos = secOp_end;
                }
                if(secPos > secVideo_len)
                    secPos = secVideo_len;
            }
        }
        
        answer = getTimeToMin(secPos);
        
        return answer;
    }
    
    public int getTimeToSec(String time) {
        StringTokenizer st = new StringTokenizer(time, ":");
        int secTime = Integer.parseInt(st.nextToken())*60+ Integer.parseInt(st.nextToken());
        return secTime;
    }
    
    public String getTimeToMin(int time) {
        int min = time/60;
        int sec = time%60;
        
        return String.format("%02d", min) + ":" + String.format("%02d", sec);
    }
}