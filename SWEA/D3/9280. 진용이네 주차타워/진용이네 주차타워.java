import java.util.*;
import java.io.*;

class Solution
{
	static boolean[] park;
	static int n;
	static Queue<Integer> waitQue;
	static HashMap<Integer, Integer> map;
	static int income;
	static int[] w;
	static int[] car;
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 주차공간 크기
			int m = Integer.parseInt(st.nextToken()); // 주차할 차량 수
			
			// 인덱스 1~n사용
			park = new boolean[n+1]; // 인덱스 주차 여부
			w = new int[n+1]; // 인덱스 요금
			
			// 주차장별 요금 입력 받기, true로 초기화
			for(int i=1; i<=n; i++) {
				w[i] = Integer.parseInt(br.readLine());
				park[i] = true;
			}
			
			// 차량 무게 인덱스1~m사용
			car = new int[m+1];
			for(int i=1; i<=m; i++) {
				car[i] = Integer.parseInt(br.readLine());
			}
			
			map = new HashMap<>(); // 차가 주차한 곳 정보 저장 (차,주차구역)
			income = 0; // 벌어드릴 수익
			waitQue = new ArrayDeque<>(); // 대기 차량 큐
			int empty = n; // 주차 빈공간 개수
			
			// 차량 주차 시작 - 요금 계산
			for(int i=0; i<m*2; i++) {
				int curCar = Integer.parseInt(br.readLine()); // 현재 자동차 정보
				int carNum = Math.abs(curCar); // 차량 번호
				
				// 주차하러  차량 들어옴
				if(curCar > 0) {
					// 차량 대기 순서에 넣기
					waitQue.offer(carNum);
					parking();
				}
				// 주차 종료 후 차량 나감
				else if (curCar <0) {
					park[map.get(carNum)] = true; // 주차 공간 비우기
					map.remove(carNum); // 차량 정보 삭제
					
					// 공간 생겼으니, 필요하면 주차시키기
					if(!waitQue.isEmpty()) {
						parking();
					}
				}
				
			}
			sb.append("#").append(t).append(" ").append(income).append("\n");	
		}
		System.out.print(sb);
		br.close();
	}
	
	// 주차 실행 함수
	public static void parking() {
		int parkNum = canPark();
		
		// 주차 가능한지 확인
		if(parkNum != -1) { // 주차 가능
			int carN = waitQue.poll(); // 이번에 주차할 차량 꺼내기
			
			park[parkNum] = false; // 주차 공간 막기
			map.put(carN, parkNum); // 주차 정보 저장
			income += (w[parkNum]*car[carN]); // 요금 계산
		}
	}
	
	// 이번 차례 주차 가능한지 확인 하는 함수
	public static int canPark() {
		// 전체 돌면서 가장 주차 가능한 작은 i 찾기
		for(int i=1; i<=n; i++) {
			if(park[i]) {
				return i; // 공간이 있음 -> 주차 구역 반환
			}
		}
		return -1; // 공간이 없음
	}
}