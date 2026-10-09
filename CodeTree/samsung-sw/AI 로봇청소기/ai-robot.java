import java.util.*;
import java.io.*;

public class Main {
    // 기본 변수(문제에서 제시한)
    static int N; // 격자 크기
    static int K; // 로봇 청소기 개수
    static int L; // 테스트 횟수
    
    // 내가 설정한 변수
    static int[][] map; // 격자 공간 /물건:-1/빈공간:0/먼지:1~P
    static int[][] roMap; // 로봇 위치 관리(로봇과 먼지는 함께 있을 수 있음) /0:빈 공간/1:로봇
    static Node[] robot; // 로봇 순서 관리(인덱스가 id)
    
    // 이동용 변수
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    // 내가 설정한 클래스
    static class Node{
        int r, c;
        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    static class Direc{
        int dust;
        int num; // 고유 번호 1:오른쪽/2:아래쪽/3:왼쪽/4:위
        Direc(int dust, int num){
            this.dust = dust;
            this.num = num;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 기본 변수 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 격자 크기
        K = Integer.parseInt(st.nextToken()); // 로봇 청소기 개수
        L = Integer.parseInt(st.nextToken()); // 테스트 횟수
        
        // 설정 변수 초기화
        map = new int[N+1][N+1]; // (0,0) 행&열 제외
        roMap = new int[N+1][N+1];
        robot = new Node[K];
        
        // 격자 입력 받기
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        //로봇 청소기 입력 받기
        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            roMap[r][c]= 1;
            robot[i] = new Node(r, c); // 인덱스가 id
        }
        
        // 청소기 시뮬레이션 L번 반복
        for(int i=0; i<L; i++) {
            move(); // 청소기 이동
            clean(); // 청소
            addDust(); // 먼지 축적
            spreadDust(); // 먼지 확산
            printDust(); // 먼지량 출력
        }
    }
    
    // 먼지량 계산
    public static void printDust() {
        int sum = 0;
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(map[i][j] > 0) {
                    sum += map[i][j];
                }
            }
        }
        
        System.out.println(sum);
    }
    
    // 청소기 이동 - bfs
    public static void move() {
        
        // 청소기 순서대로 이동하기 
        for(int i=0; i<K; i++) {
            // 이미 자리에 먼지 있으면 자리 유지
            if(map[robot[i].r][robot[i].c] > 0) continue;
            
            int[][] dist = new int[N+1][N+1]; // 거리 기록
            boolean[][] visited = new boolean[N+1][N+1]; // 방문 기록용
            Queue<Node> que = new ArrayDeque<>();
            que.offer(robot[i]);
            visited[robot[i].r][robot[i].c] = true;
            
            // 거리 계산
            while(!que.isEmpty()) {
                Node cur = que.poll();
                
                for(int j=0; j<4; j++) {
                    int nr = cur.r + dr[j];
                    int nc = cur.c + dc[j];
                    
                    if(isMap(nr, nc)) { // 범위 안인지 확인
                        if(map[nr][nc]>=0 && roMap[nr][nc]==0 && !visited[nr][nc]) { // 장애물이 없고, 방문한 적이 없어야 함
                            que.offer(new Node(nr, nc)); // 큐에 넣기
                            visited[nr][nc] = true; // 방문 처리
                            dist[nr][nc] = dist[cur.r][cur.c]+1; // 이동 거리 계산
                        }
                    }
                }
            }
            
            // 거리 계산 바탕으로 이동할 위치 확정
            int nextR = Integer.MAX_VALUE;
            int nextC = Integer.MAX_VALUE;
            int len = Integer.MAX_VALUE;
            
            for(int m=1; m<=N; m++) {
                for(int n=1; n<=N; n++) {
                    // 먼지가 있는 구역인데,점유 청소기 없는지,bfs로 방문 가능한지
                    if(map[m][n] > 0 && roMap[m][n]==0 && visited[m][n]) {
                        // 이동 거리 비교하기
                        if(dist[m][n] < len) {
                            nextR = m;
                            nextC = n;
                            len = dist[m][n];
                        }
                        else if(len == dist[m][n]) {
                            if(m < nextR) {
                                nextR = m;
                                nextC = n;
                            }
                            else if(m == nextR) {
                                if(n < nextC) {
                                    nextR = m;
                                    nextC = n;
                                }
                            }
                        }
                    }
                }
            }
            
            // 자리 이동 없으면 건너뛰기
            if(nextR == Integer.MAX_VALUE) continue;
            
            // 이동하기
            roMap[robot[i].r][robot[i].c] = 0; // 이전에 있던 공간 놓아주기
            roMap[nextR][nextC] = 1; // 다음 공간 점유
            robot[i] = new Node(nextR, nextC); // 로봇 상태 값 변경
        }
        
    }
    
    // 청소
    public static void clean() {
        
        // 청소기 순서대로 청소 진행
        for(int i=0; i<K; i++) {
            Node cur = robot[i];
            
            Direc right = new Direc(getDust(robot[i].r, robot[i].c, 1), 1);
            Direc down = new Direc(getDust(robot[i].r, robot[i].c, 2), 2);
            Direc left = new Direc(getDust(robot[i].r, robot[i].c, 3), 3);
            Direc up = new Direc(getDust(robot[i].r, robot[i].c, 4), 4);
            
            // 순서 정렬
            Direc[] order = new Direc[]{right, down, left, up};
            Arrays.sort(order, (a, b) -> {
                if(a.dust == b.dust) {
                    return a.num-b.num;
                }
                return b.dust-a.dust;
            });
            
            // 가장 앞 순서 청소하기
            getClean(robot[i].r, robot[i].c, order[0].num);
        }
    }
    
    // 먼지 축적
    public static void addDust() {
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(map[i][j] > 0) {
                    map[i][j] += 5;
                }
            }
        }
    }
    
    // 먼지 확산
    public static void spreadDust() {
        // 동시에 확산 될 먼지 저장할 공간
        int[][] newDust = new int[N+1][N+1];
        
        // 동시에 확산될 먼지 계산
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(map[i][j] == 0) {
                    int sum = 0;
                    if(isMap(i-1, j)) {
                        sum += getZero(map[i-1][j]);
                    }
                    if(isMap(i+1, j)) {
                        sum += getZero(map[i+1][j]);
                    }
                    if(isMap(i, j-1)) {
                        sum += getZero(map[i][j-1]);
                    }
                    if(isMap(i, j+1)) {
                        sum += getZero(map[i][j+1]);
                    }
                    newDust[i][j] = sum/10;
                }
            }
        }
            
        // 기존 먼지에 먼지 더하기
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(map[i][j] == 0) {
                    map[i][j] += newDust[i][j];
                }
            }
        }
    }
    
    // 격자 범위 안인지 확인
    public static boolean isMap(int r, int c) {
        if(r>0 && r<=N && c>0 && c<=N) {
            return true;
        }
        return false;
    }
    
    // 청소 가능 격자에서 먼지 합 구하기
    public static int getDust(int r, int c, int d) { // d - 1: 오른쪽 / 2: 아래쪽 / 3: 왼쪽 / 4: 위쪽
        int sum = 0;
        
        int cur = getCleanMax(map[r][c]);
        
        int up = getCleanMax(getValue(r-1, c));
        int down = getCleanMax(getValue(r+1, c));
        int right = getCleanMax(getValue(r, c+1));
        int left = getCleanMax(getValue(r, c-1));
        
        if(d == 1) {
            sum = cur + up + down + right;
        }
        else if(d == 2) {
            sum = cur + left + right + down;
        }
        else if(d == 3) {
            sum = cur + up + down + left;
        }
        else if(d == 4) {
            sum = cur + left + right + up;
        }
        
        return sum;
    }
    
    // 최대 청소 가능 먼지
    public static int getCleanMax(int n) {
        if(n > 20) return 20; //최대 20개까지 청소 가능
        if(n < 0) return 0; // 장애물은 0으로 처리
        return n;
    }
    
    // 음수면 0으로 보정
    public static int getZero(int n) {
        if(n < 0) return 0; // 장애물은 0으로 처리
        return n;
    }
    
    // 범위 안이 아니면 0 반환, 범위 안이면 해당 칸 값 반환하는 함수
    public static int getValue(int r, int c) {
        if(isMap(r, c)) {
            return map[r][c];
        }
        return 0;
    }
    
    // 물건 있는 여부 파악 - 청소 가능한지 아닌지
    public static boolean canClean(int r, int c) {
        if(map[r][c] == -1) return false;
        
        return true;
    }
    
    // 방향에 따라 청소하기
    public static void getClean(int r, int c, int d) {
        if(d == 1) {
            map[r][c] = getZero(map[r][c]-20);
            if(isMap(r-1, c) && canClean(r-1, c)) {
                map[r-1][c] = getZero(map[r-1][c]-20);
            }
            if(isMap(r+1, c) && canClean(r+1, c)) {
                map[r+1][c] = getZero(map[r+1][c]-20);
            }
            if(isMap(r, c+1) && canClean(r, c+1)) {
                map[r][c+1] = getZero(map[r][c+1]-20);
            }
        }
        else if(d == 2) {
            map[r][c] = getZero(map[r][c]-20);
            if(isMap(r+1, c) && canClean(r+1, c)) {
                map[r+1][c] = getZero(map[r+1][c]-20);
            }
            if(isMap(r, c-1) && canClean(r, c-1)) {
                map[r][c-1] = getZero(map[r][c-1]-20);
            }
            if(isMap(r, c+1) && canClean(r, c+1)) {
                map[r][c+1] = getZero(map[r][c+1]-20);
            }
        }
        else if(d == 3) {
            map[r][c] = getZero(map[r][c]-20);
            if(isMap(r-1, c) && canClean(r-1, c)) {
                map[r-1][c] = getZero(map[r-1][c]-20);
            }
            if(isMap(r+1, c) && canClean(r+1, c)) {
                map[r+1][c] = getZero(map[r+1][c]-20);
            }
            if(isMap(r, c-1) && canClean(r, c-1)) {
                map[r][c-1] = getZero(map[r][c-1]-20);
            }
        }
        else if(d == 4) {
            map[r][c] = getZero(map[r][c]-20);
            if(isMap(r-1, c) && canClean(r-1, c)) {
                map[r-1][c] = getZero(map[r-1][c]-20);
            }
            if(isMap(r, c-1) && canClean(r, c-1)) {
                map[r][c-1] = getZero(map[r][c-1]-20);
            }
            if(isMap(r, c+1) && canClean(r, c+1)) {
                map[r][c+1] = getZero(map[r][c+1]-20);
            }
        }
    }
}