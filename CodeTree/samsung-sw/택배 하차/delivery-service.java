import java.util.*;
import java.io.*;

public class Main {
    // 시스템 기본 변수(문제에서 주어진)
    static int N; // 격자 크기
    static int M; // 택배 개수
    
    // 내가 정의한 변수
    static int[][] map; // 맵 정보 (택배가 점유하고 있는 공간 -> 해당 택배 id) - 0안씀
    static HashMap<Integer, Box> boxList; // 택배 목록 저장 (id) - 0 안씀
    static int rest; // 남은 박스
    static ArrayList<Integer> order; // 박스 탈출 id 순서
    
    // 택배 클래스
    static class Box{
        int r, c; // 하차하면 r과c를 0으로
        int w, h;
        int id; // 택배 번호
        
        Box(int r, int c, int w, int h, int id){
            this.r = r;
            this.c = c;
            this.w = w;
            this.h = h;
            this.id = id;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 격자 크기
        M = Integer.parseInt(st.nextToken()); // 택배 개수
        
        // 변수 초기화
        map = new int[N+1][N+1]; // 0 안씀
        boxList = new HashMap<>(); // 0 안씀
        rest = M;
        order = new ArrayList<>();
        
        
        for(int i=1; i<=M; i++) {
            // 박스 정보 입력
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            boxList.put(k, new Box(1, c, w, h, k));
            
            // 박스 투입 - 격자에 박스 넣는 함수
            insertBox(boxList.get(k)); // 아래로 내리는 로직 포함
        }
        
        // 하차 로직 시작
        while(rest > 0) { // 남은 박수 0개 되면 종료
            dropLeft();
            if(rest == 0) break;
            dropDownBox();
            dropRight();
            dropDownBox();
        }
        
        // 출력
        for(int i=0; i<order.size(); i++) {
            System.out.println(order.get(i));
        }
        
    }
    
    // 박스 투입 함수
    public static void insertBox(Box box) {
        // 현재 위치는 반영할 필요가 없다. 
        // 바로 내릴 수 있을 때까지 내림 -> 내릴 수 없으면 현재 위치
        dropBox(box);
    }
    
    // 박스 하나 아래로 내리는 함수
    public static void dropBox(Box box) {
        int num = canNum(box); // 몇 칸 내릴 수 있는지

        
        // 새로운 박스 위치로 교체
        Box nBox = new Box(box.r+num, box.c, box.w, box.h, box.id);
        boxList.put(box.id, nBox);
        
        // 지도에서 이전 박스 위치 놓아주기
        for(int i=0; i<box.h; i++) {
            for(int j=0; j<box.w; j++) {
                if(map[box.r+i][box.c+j] == box.id) {
                    map[box.r+i][box.c+j] = 0;
                }
            }
        }
        
        // 지도에서 박스 위치 점유하기
        for(int i=0; i<nBox.h; i++) {
            for(int j=0; j<nBox.w; j++) {
                map[nBox.r+i][nBox.c+j] = nBox.id;
            }
        }
    }
    
    // 최저 박스 위치 몇칸 내려도 되는지 반환하는 함수
    public static int canNum(Box box) {
        int num = 0;
        
        // 이미 끝 칸에 위치한다면
        if((box.r + box.h -1) == N) return 0;
        
        for(int i=1; i<=N-box.h; i++) {
            boolean canDown = true; // 아래로 내릴 수 있는지
            int nr = (box.r + box.h -1) + i; // 다음 최저 후보 행
            if(isMap(nr)) { // 다음행이 내릴 수 있으면
                // 열에 대해서 확인
                for(int j=0; j<box.w; j++) {
                    int nc = box.c + j; // 열은 격자 안 무조건 보장
                    if(map[nr][nc] > 0) { // 무언가가 있으면 안 됨
                        canDown = false;
                        break;
                    }
                }
            } else { // 다음행 내릴 수 없음
                canDown = false;
            }
            if(canDown) {
                num = i;
            } else {
                break;
            }
        }
        
        return num;
    }
    
    // 격자 안에 있는지 확인
    public static boolean isMap(int n) {
        if(n > 0 && n <=N) return true;
        return false;
    }
    
    // 박스 왼쪽 하차
    public static void dropLeft() {
        HashMap<Integer, Integer> leftBox = new HashMap<>();
        
        // 행별로 왼쪽부터 탐색하면서 먼저 만나는 박스 id에 +1
        // 높이와 이 값이 같을 때만 택배 하차 후보로 선정
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                // 택배 마주치면
                if(map[i][j] > 0) {
                    int id = map[i][j];
                    leftBox.put(id, leftBox.getOrDefault(id, 0)+1);
                    break;
                }
            }
        }
        
        // 왼쪽 하차 후보 결정(오름차순 정렬)
        PriorityQueue<Box> dropList = new PriorityQueue<>((a, b) -> Integer.compare(a.id, b.id));
        for(int i : leftBox.keySet()) {
            if(leftBox.get(i) == boxList.get(i).h) {
                dropList.offer(boxList.get(i));
            }
        }
        
        // 하차 하기
        Box cur = dropList.poll();
        for(int i=0; i<cur.h; i++) {
            for(int j=0; j<cur.w; j++) {
                map[cur.r+i][cur.c+j] = 0;
            }
        }
        boxList.get(cur.id).r = 0;
        boxList.get(cur.id).c = 0;
        rest --;
        order.add(cur.id);
    }
    
    // 박스 오른쪽 하차
    public static void dropRight() {
        HashMap<Integer, Integer> rightBox = new HashMap<>();
        
        // 행별로 오른쪽부터 탐색하면서 먼저 만나는 박스 id에 +1
        // 높이와 이 값이 같을 때만 택배 하차 후보로 선정
        for(int i=1; i<=N; i++) {
            for(int j=N; j>=1; j--) {
                // 택배 마주치면
                if(map[i][j] > 0) {
                    int id = map[i][j];
                    rightBox.put(id, rightBox.getOrDefault(id, 0)+1);
                    break;
                }
            }
        }
        
        // 왼쪽 하차 후보 결정(오름차순 정렬)
        PriorityQueue<Box> dropList = new PriorityQueue<>((a, b) -> Integer.compare(a.id, b.id));
        for(int i : rightBox.keySet()) {
            if(rightBox.get(i) == boxList.get(i).h) {
                dropList.offer(boxList.get(i));
            }
        }
        
        // 하차 하기
        Box cur = dropList.poll();
        for(int i=0; i<cur.h; i++) {
            for(int j=0; j<cur.w; j++) {
                map[cur.r+i][cur.c+j] = 0;
            }
        }
        boxList.get(cur.id).r = 0;
        boxList.get(cur.id).c = 0;
        rest --;
        order.add(cur.id);
    }
    
    // 전체 박스 아래로 조정하는 함수
    public static void dropDownBox() {
        // 순서 지정 - 맨 아래 박스들부터 이동 진행
        ArrayList<int[]> list = new ArrayList<>(); // 앞에 id, 두번째 bottom 길이
        
        for(int id : boxList.keySet()) {
            Box box = boxList.get(id);
            int bottom = box.r + box.h-1;
            if(box.r > 0) {
                list.add(new int[]{id, bottom});
            }
        }
        
        // 정렬하기 (내림차순)
        list.sort((a, b) -> {
            if(a[1]==b[1]) {
                return a[0]-b[0];
            } else return b[1]-a[1];
        });
        
        for(int i=0; i<list.size(); i++) {
            dropBox(boxList.get(list.get(i)[0]));
        }
    }
}