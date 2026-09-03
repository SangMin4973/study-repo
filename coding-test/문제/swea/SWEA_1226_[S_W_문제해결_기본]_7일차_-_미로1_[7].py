import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Solution_1233 {
	static int[] moveX = {1, 0, -1, 0};
	static int[] moveY = {0, 1, 0, -1};

	public int solution_dfs(int[][] arr) {
		int answer = 0;
		for(int i=0; i<16; i++) {
			for(int j=0; j<16; j++) {
				if (arr[j][i] == 2) {
					answer = dfs(arr, j, i);
					break;
				}
			}
		}		
		return answer;
	}
	
	public int solution_bfs(int[][] arr) {
		int answer = 0;
		Deque<int[]> dq = new ArrayDeque<>();
		
		for(int i=0; i<16; i++) {
			for(int j=0; j<16; j++) {
				if (arr[j][i] == 2) {
					dq.offer(new int[] {j, i});
					break;
				}
			}
		}	
		while (!dq.isEmpty()) {
			int[] curPos = dq.pollFirst();
			int cy = curPos[0];
			int cx = curPos[1];
			
			if (cx < 0 || cy < 0 || cx >= 16 || cy >= 16) {
				continue;
			}
			
			if (arr[cy][cx] == 1){
				continue;
			}
			
			if (arr[cy][cx] == 3){
				answer = 1;
				break;
			}
			
			arr[cy][cx] = 1;
			
			for (int i=0; i<4; i++) {
				dq.offer(new int[] {cy + moveY[i], cx + moveX[i]});
			}
		}
		
		return answer;
	}
	
	public int dfs(int[][] arr, int cx, int cy) {
		if (cx < 0 || cy < 0 || cx >= 16 || cy >= 16) {
			return 0;
		}
		
		if (arr[cy][cx] == 1){
			return 0;
		}
		
		if (arr[cy][cx] == 3){
			return 1;
		}
		arr[cy][cx] = 1;
		
		for (int i=0; i<4; i++) {
			int rx = cx + moveX[i];
			int ry = cy + moveY[i];
			
			if (dfs(arr, rx, ry) == 1) {
				return 1;
			}
		}		
		return 0;
	}
}



public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		Solution_1233 s = new Solution_1233();
		
		for (int t=1; t<=T; t++) {
			int[][] arr = new int[16][16];
			sc.nextLine();
			for (int i=0; i<16; i++) {
				String line = sc.nextLine();
				
				for (int j=0; j<16; j++) {
					arr[i][j] = line.charAt(j) - '0';
				}
			}
			
			System.out.println("#" + t + " " +s.solution_bfs(arr));			
		}
	}
}





