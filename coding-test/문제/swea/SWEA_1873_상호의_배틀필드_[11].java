import java.util.*;
// 문자 의미
// .	평지(전차가 들어갈 수 있다.)
// *	벽돌로 만들어진 벽, 벽돌을 포탄으로 쏘면 벽돌이 파괴되고 평지로 변한다.
// #	강철로 만들어진 벽, 강철을 포탄으로 쏴도 아무 일도 일어나지 않는다.
// -	물(전차는 들어갈 수 없다.)
// ^	위쪽을 바라보는 전차(아래는 평지이다.)
// v	아래쪽을 바라보는 전차(아래는 평지이다.)
// <	왼쪽을 바라보는 전차(아래는 평지이다.)
// >	오른쪽을 바라보는 전차(아래는 평지이다.)

// 문자	동작
// U	Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
// D	Down : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
// L	Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
// R	Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
// S	Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.

// 포탄은 벽 혹은 강철을 만날 때 까지 직진한다.

// 포탄에 맵 밖으로 나가면 아무 일도 일나지 않는다.

// 초기 게임 맵의 상태와 사용자가 넣을 입력이 순서대로 주어질 때, 모든 입력을 처리하고 나면 게임 맵의 상태가 어떻게 되는지 구하는 프로그램을 작성하라.

// 입력: H, W(2 <= H, W <= 20), 그 아래로 각 맵에 해당하는 문자들이 공백 없이 주어진다.
public class Solution {
	// x이동 dx
	static int[] dx = {-1, 1, 0, 0};
	// y이동 dy
	static int[] dy = {0, 0, -1, 1};
	static char[] state = {'^', 'v', '<', '>'};
	// map높이
	static int H;
	// map너비
	static int W;
	// 전차 x 좌표
	static int x;
	// 전차 y 좌표
	static int y;
	// map
	static char[][] map;
	// 현재 바라보는 방향
	static int dir;
	// 시행 횟수
	static int cnt;
	// 명령어 배열
	static char[] commands;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			// H, W 입력 받기
			H = sc.nextInt();
			W = sc.nextInt();
			// H, W 크기의 격자 map 생성
			map = new char[H][W];
			
			// 격자에 문자 삽입
			for (int i=0; i<H; i++){
				String str = sc.next();
				for (int j=0; j<W; j++){
					map[i][j] = str.charAt(j);
					// 전차를 나타내는 기호가 나타나면
					// 바라보는 방향 저장
					if (map[i][j] == state[0]){
						dir = 0;						
					} else if (map[i][j] == state[1]){
						dir = 1;						
					} else if (map[i][j] == state[2]){
						dir = 2;						
					} else if (map[i][j] == state[3]){
						dir = 3;						
					} else continue;
					// 전차 위치 x, y에 저장
					x = i;
					y = j;					
				}
			}			
			// 시행 횟수 cnt에 저장
			cnt = sc.nextInt();
			// cnt 크기의 commands 배열 생성
			commands = new char[cnt];
			// commands에 명령 입력 받기 후 저장
			String str = sc.next();
			for (int i=0; i<cnt; i++){
				commands[i] = str.charAt(i);
			}
			play(0);
			
			System.out.print("#" + tc + " ");
			for (int i=0; i<H; i++){
				for (int j=0; j<W; j++){
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
	
	// play 함수(시행 횟수)
	static void play(int n){
		// 시행 횟수가 cnt면 return
		if (cnt == n) return;
		// command = commands[시행 횟수]
		char command = commands[n];
		// 명령어가 S 일 때
		if (command == 'S'){
		// shoot() 함수 호출
			shoot();
		}
		// else: move(명령어) 함수 호출
		else {
			move(command);
		}
		// play(시행 횟수 + 1, 전차x, 전차y)
		play(n + 1);
	}
	// move 함수(명령어)
	static void move(char c){    	
    	// U일 때
    	if (c == 'U') dir = 0;
    	// D일 때
    	if (c == 'D') dir = 1;
    	// L일 때
    	if (c == 'L') dir = 2;
    	// R일 때
    	if (c == 'R') dir = 3;
    	// 다음 위치 nx, ny
    	int nx = x + dx[dir];
    	int ny = y + dy[dir];
    	map[x][y] = state[dir];
    	// valid(nx, ny) == false면 return
    	if (!valid(nx, ny)) return;
    	// valid(nx, ny) == true면
    	if (valid(nx, ny)){
    		map[x][y] = '.';
    		map[nx][ny] = state[dir];
        	// x = nx, y = ny
        	x = nx;
        	y = ny;
        	// return
        	return;
        }
	}	
	// valid 함수(x, y)
	static boolean valid(int x, int y){
    	// 맵 밖으로 나가면 false return
    	if (x < 0 || y < 0 || x >= H || y >= W) return false;
    	// .(평지)면 true return 
    	if (map[x][y] == '.') return true;
    	// else: false return
		else return false;
	}
	// shoot 함수()
	static void shoot(){
    	// while true:
    	int cx = x;
    	int cy = y;
    	while (true){
        	// 다음 위치 nx, ny
        	int nx = cx + dx[dir];
        	int ny = cy + dy[dir];
        	// nx, ny가 맵 밖이면 return
        	if (nx < 0 || ny < 0 || nx >= H || ny >= W) return;
        	// map[nx][ny]가 강철이면 return
        	if (map[nx][ny] == '#') return;
        	// map[nx][ny]가 벽돌이면 map[nx][ny]=평지
        	if (map[nx][ny] == '*'){
        		map[nx][ny] = '.';
        		return;
        	}
        	cx = nx;
        	cy = ny;
        }        	
    }
}