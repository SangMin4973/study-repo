package algo_workshop;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main_2819_격자판숫자이어붙이기 {
	static Set<String> answer = new HashSet<>();
	static int moveX[] = {0, 1, 0, -1};
	static int moveY[] = {1, 0, -1, 0};
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t=1; t<=T; t++) {
			answer.clear()
			int [][]board = new int [4][4];
			
			for (int i=0; i<4; i++) {
				for (int j=0; j<4; j++) {
					board[i][j] = sc.nextInt();
				}
			}
			
			for (int i=0; i<4; i++) {
				for (int j=0; j<4; j++) {
					move(i, j, 1, String.valueOf(board[i][j]), board);
				}
			}
			
			System.out.println("#" + t + " " + answer.size());
		}
	}
	
	static void move(int cx, int cy, int cnt, String result, int[][] board) {
		if (cnt == 7) {				
			answer.add(result);
			return;
		}
		for (int i=0; i<4; i++) {
			int nx = cx + moveX[i];
			int ny = cy + moveY[i];
			if (nx >= 0 && ny >= 0 && nx < 4 && ny < 4) {
				move(nx, ny, cnt+1, result + board[nx][ny], board);
			} 
		}		
	}
}


