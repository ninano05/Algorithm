import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0; // 숫자들의 총합

        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(br.readLine());
            nums[i] = num;
            map.put(num, map.getOrDefault(num, 0)+1); // 개수
            sum += num;
        }
        //산술평균
        int am = Math.round((float)sum/N);
        // 중앙 값
        Arrays.sort(nums);
        int med = nums[N/2]; // N이 홀수라서 N/2해도 된다.
        // 최빈값
        int mode = 0; // 최빈값
        int max = 0; // 최소 개수가 1이라 0으로 해도 된다.
        ArrayList<Integer> list = new ArrayList<>();
        // 여러개인 경우 두번째로 작은 값 출력
        for(int n : map.keySet()) {
            if(map.get(n) > max) {
                max = map.get(n);
                list.clear(); // 이전에 담긴 리스트 초기화
                list.add(n); // 다시 넣어주기
            } else if(map.get(n) == max) {
                list.add(n);
            }
        }
        Collections.sort(list);
        if(list.size() > 1) mode = list.get(1);
        else mode = list.get(0);
        // 범위
        int sub = nums[N-1]-nums[0];
        sb.append(am).append("\n").append(med).append("\n").append(mode).append("\n").append(sub).append("\n");
        System.out.print(sb);
        br.close();
    }
}