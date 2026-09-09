import java.util.Scanner;

public class Solution {
	static int N;
	static int answer;
	static boolean[] column;
	static boolean[] diag1;
	static boolean[] diag2;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			N = sc.nextInt();
			column = new boolean [N];
			diag1 = new boolean[(N - 1) * 2 + 1];
			diag2 = new boolean[(N - 1) * 2 + 1];
			if (N==1){
				answer = 1;
				System.out.println("#" + tc + " " + answer);
				continue;
			}
			answer = 0;
			dfs(0);
			System.out.println("#" + tc + " " + answer);
		}
	}
	
	public static void dfs(int row){
		if (N == row){
			answer++;
			return;
		}	
		
		for (int col=0; col<N; col++){
			if (column[col]|diag1[row+col]|diag2[N-row+col-1]){
				continue;
			} else {
				column[col] = true;
				diag1[row+col] = true;
				diag2[N-row+col-1] = true;
				dfs(row + 1);
				column[col] = false;
				diag1[row+col] = false;
				diag2[N-row+col-1] = false;				
			}
		}
	}	
}
