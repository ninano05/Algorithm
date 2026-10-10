import java.io.*;
import java.util.*;

public class Main {
    static int N; //격자
    static int T; // 전파 기간
    
    static int[][] BMap; // 신앙심 기록 지도 0안 씀
    static int[][] map; // 신봉 음식 기록 지도
    static Food[][] FMap; // 신봉 음식 기록 지도2 -> 개별 항목 관리
    static int[][] group; // 그룹 지도
    static boolean[][] defense; // 전파 당한 학생 관리
    static HashMap<Integer, Node> parent; // 그룹id, 대표자
    // 신봉 음식
    // 단일 T:1, C:2, M:3
    // 이중(단일+단일+1) TC:4, TM:5, CM:6
    // 삼중(단일+단일+단일+1) TCM:7
    
    // 대표자 노드
    static class Node{
        int r, c;
        int f;
        Node(int r, int c, int f) {
            this.r = r;
            this.c = c;
            this.f = f;
        }
    }
    // 신봉 음식
    static class Food {
        boolean T, C, M;
        Food(boolean T, boolean C, boolean M){
            this.T=T;
            this.C=C;
            this.M=M;
        }
    }
    
    // 0:상 1:하 2:좌 3:우 
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        
        // 변수 초기화
        BMap = new int[N+1][N+1];
        map = new int[N+1][N+1];
        FMap = new Food[N+1][N+1];
        
        for(int i=1; i<=N; i++) {
            String s = br.readLine();
            for(int j=0; j<N; j++) {
                char c = s.charAt(j);
                if(c == 'T') {
                    map[i][j+1] = 1;
                    FMap[i][j+1] = new Food(true, false, false);
                }
                else if(c == 'C') {
                    map[i][j+1] = 2;
                    FMap[i][j+1] = new Food(false, true, false);
                }
                else if(c == 'M') {
                    map[i][j+1] = 3;
                    FMap[i][j+1] = new Food(false, false, true);
                }
            }
        }
        
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                BMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // T일동안 시뮬레이션
        for(int t=0; t<T; t++) {
            group = new int[N+1][N+1]; // 매일매일 그룹 초기화
            parent = new HashMap<>(); // 그룹별 대표자 초기화
            defense = new boolean[N+1][N+1]; // 전파 당한 학생 방어
            // 아침 시간
            morning();
            // 점심시간
            lunch();
            // 저녁시간
            night();
            // 신앙심 총합 출력
            printB();
        }
        
    }
    
    // 신앙심 총합 출력
    public static void printB() {
        // 단일 T:1, C:2, M:3
        // 이중(단일+단일+1) TC:4, TM:5, CM:6
        // 삼중(단일+단일+단일+1) TCM:7
        int TCM_sum = 0;
        int TC_sum = 0;
        int TM_sum = 0;
        int CM_sum = 0;
        int M_sum = 0;
        int C_sum = 0;
        int T_sum = 0;
        
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                int num = map[i][j];
                int B = BMap[i][j];
                if(num == 1) T_sum += B;
                if(num == 2) C_sum+=B;
                if(num == 3) M_sum+=B;
                if(num == 4) TC_sum+=B;
                if(num == 5) TM_sum+=B;
                if(num == 6) CM_sum+=B;
                if(num == 7) TCM_sum+=B;
                
            }
        }
        StringBuilder sb = new StringBuilder();
        
        sb.append(TCM_sum+" ")
        .append(TC_sum+" ").append(TM_sum+" ").append(CM_sum+" ")
        .append(M_sum+" ").append(C_sum+" ").append(T_sum);
        System.out.println(sb);
    }
    
    // 아침 시간
    public static void morning() {
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                BMap[i][j]+=1;
            }
        }
    }
    
    // 점심 시간
    public static void lunch() {
        int gid = 0; //그룹 id
        
        // 그룹 형성하기 & 신앙심 조절
        for(int r=1; r<=N; r++) {
            for(int c=1; c<=N; c++) {
                if(group[r][c] == 0) { // 아직 그룹 형성 안 한 칸만 탐색
                    gid++; // 1부터 시작
                    bfs(r, c, gid);
                }
            }
        }
    }
    
    // 그룹 구하는 bfs
    public static void bfs(int r, int c, int gid) {
        // 그룹원들 신앙심을 미리 1씩 빼고 나서 나중에 대표자에게 한번에 모두 더하기
        int B = 0; // 그룹원들 신앙심
        
        Queue<Node> que = new ArrayDeque<>();
        que.offer(new Node(r, c, map[r][c]));
        BMap[r][c]-=1; // 신앙심 수거
        B+=1;
        group[r][c] = gid; // 방문처리 & 그룹표시
        parent.put(gid, new Node(r, c, map[r][c])); // 대표자 처리
        
        while(!que.isEmpty()) {
            Node cur = que.poll();
            
            for(int i=0; i<4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                
                if(isMap(nr, nc)) {
                    if(map[cur.r][cur.c] == map[nr][nc] && group[nr][nc] == 0) { // 신봉 음식이 같으면 & 방문한적 없음
                        int id = group[cur.r][cur.c];
                        que.offer(new Node(nr, nc, map[nr][nc]));
                        BMap[nr][nc]-=1;
                        B+=1; //신앙심 수거
                        group[nr][nc] = id; // 방문 처리
                        
                        // 신앙심 비교 (대표자 선정)
                        parent.put(gid, higherB(new Node(nr, nc, map[nr][nc]), parent.get(gid)));
                    }
                }
            }
        }
        
        // 대표자에게 수거한 신앙심 더하기
        Node rep = parent.get(gid);
        BMap[rep.r][rep.c] += B;
    }
    
    // 격자 범위 안에 있는지
    public static boolean isMap(int r, int c) {
        if(r>0 && r<=N && c>0 && c<=N) return true;
        return false;
    }
    
    // 신앙심 비교
    public static Node higherB(Node can, Node ori) {
        
        // 새로운 후보가 신앙심이 더 큰 경우
        if(BMap[can.r][can.c] > BMap[ori.r][ori.c]) {
            return can;
        }
        // 신앙력이 같은 경우
        else if(BMap[can.r][can.c] == BMap[ori.r][ori.c]) {
            // 새로운 후보가 행이 더 작을 경우
            if(can.r < ori.r) return can;
            // 행이 같은 경우
            else if(can.r == ori.r) {
                // 새로운 후보가 열이 더 작을 경우
                if(can.c < ori.c) return can;
            }
        }
        return ori; // 기존이 신앙심 더 높음 or 행 열이 작음
    }
    
    
    // 저녁 시간
    public static void night() {
        // 전파 순서 결정하기
        ArrayList<Integer> list = new ArrayList<>();
        getOrder(list);
        
        // 전파 시작하기
        for(int i=0; i<list.size(); i++) {
            spread(list.get(i));
        }
    }
    
    // 전파 순서 결정
    public static void getOrder(ArrayList<Integer> list) {
        
        for(int i : parent.keySet()) {
            list.add(i); // 그룹 id가 들어감
        }
        
        // 그룹은 오름차순 - 내부는 신앙심 내림차순 - 행번호 - 열번호
        list.sort((a, b) -> {
            Node A = parent.get(a);
            Node B = parent.get(b);
            if(foodGroup(A.f) == foodGroup(B.f)) {
                if(BMap[A.r][A.c] == BMap[B.r][B.c]) {
                    if(A.r == B.r) {
                        return A.c-B.c; // 열번호 오름차순
                    }
                    else return A.r-B.r; // 행번호 오름차순
                }
                else return BMap[B.r][B.c]-BMap[A.r][A.c]; //신앙심 내림차순
            }
            else return foodGroup(A.f)-foodGroup(B.f); // 그룹 오름차순
        });
    }
    
    // 세 그룹으로 그룹핑하기
    public static int foodGroup(int n) {
        // 단일 음식
        if(n < 4) return 0;
        // 이중 조합 음식
        else if(n >= 4 && n<7) return 1;
        // 삼중 조합 음식
        else return 2;
    }
    
    // 대표자가 전파하기
    public static void spread(int id) {
        Node rep = parent.get(id); // 대표자 정보 가져오기
        Food repFood = FMap[rep.r][rep.c]; // 대표자 음식 정보 가져오기
        
        if(defense[rep.r][rep.c]) return; //전파 당한 학생은 전파 불가능
        
        // 전파 방향
        int d = BMap[rep.r][rep.c]%4;
        // 전파할 신앙심
        int x = BMap[rep.r][rep.c]-1;
        // 신앙심 1만 남기기
        BMap[rep.r][rep.c] = 1;
        
        // 연속적인 이동 표현을 위해
        int prevR = rep.r;
        int prevC = rep.c;
        
        // d 방향으로 전파 시도
        while(x>0) { //전파할 신앙심 0 이상
            int nr = prevR+dr[d];
            int nc = prevC+dc[d];
            
            if(isMap(nr, nc)) {
                int y = BMap[nr][nc];
                
                // 완전 동일한 음식은 전파하지 않는다.
                if(map[rep.r][rep.c] == map[nr][nc]) {
                    prevR = nr;
                    prevC = nc;
                    continue;
                };
                
                if(x> y) { // 강한 전파
                    // 동일한 음식 신봉
                    FMap[nr][nc].T = repFood.T;
                    FMap[nr][nc].C = repFood.C;
                    FMap[nr][nc].M = repFood.M;
                    map[nr][nc] = map[rep.r][rep.c];
                    // 신앙심 조절
                    BMap[nr][nc] +=1;
                    x = x - (y+1);
                    defense[nr][nc] = true;
                } else { // 약한 전파
                    // 대표자가 믿는 것도 믿기
                    if(repFood.T) FMap[nr][nc].T = true;
                    if(repFood.C) FMap[nr][nc].C = true;
                    if(repFood.M) FMap[nr][nc].M = true;
                    map[nr][nc] = getFoodNum(nr, nc);
                    // 신앙심 조절
                    BMap[nr][nc] += x;
                    x = 0;
                    defense[nr][nc] = true;
                }
                prevR = nr;
                prevC = nc;
            } 
            else {
                break; // 격자 밖으로 나가면 전파 종료
            }
        }
    }
    
    // 바뀐 신봉 음식에 따른 map 값 변화
    public static int getFoodNum(int r, int c) {
        // 단일 T:1, C:2, M:3
        // 이중(단일+단일+1) TC:4, TM:5, CM:6
        // 삼중(단일+단일+단일+1) TCM:7
        Food f = FMap[r][c];
        
        if(f.T && f.C && f.M) return 7;
        if(!f.T && f.C && f.M) return 6;
        if(f.T && !f.C && f.M) return 5;
        if(f.T && f.C && !f.M) return 4;
        if(!f.T && !f.C && f.M) return 3;
        if(!f.T && f.C && !f.M) return 2;
        //if(f.T && !f.C && !f.M) return 1;
        
        return 1;
    }
}