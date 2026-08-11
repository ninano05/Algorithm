import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
    
        // 공백으로 자르기
        StringTokenizer st = new StringTokenizer(s, " ");
        
        // 공백 기준 자르고 배열 반환
        String[] arr = s.split(" ");
        
        // String 배열 변환해서 숫자 배열로 저장할 공간
        int[] nums = new int[arr.length];
        
        // 숫자 배열 변환
        for(int i=0; i<arr.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }
        
        // 정렬 (오름차순)
        Arrays.sort(nums);
        
        return ""+nums[0]+" "+nums[nums.length-1];
    }
}