import java.util.Scanner;
import java.util.*;

public class Solution {
	static boolean[] selected;
	static int N;
	static int[][] table;
	static int min;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			N = sc.nextInt();
			selected = new boolean[N];
			table = new int[N][N];
			min = Integer.MAX_VALUE;
			for (int i=0; i<N; i++){
				for (int j=0; j<N; j++){
					table[i][j] = sc.nextInt();
				}
			}
			combination(0, 0);
			System.out.println("#" + tc + " " + min);
		}
	}
	
	public static void combination(int start, int depth){
		if (depth==N/2){
			calc();
			return;
		}
		
		for (int i=start; i<N; i++){
			if (selected[i]){
				continue;
			}
			selected[i] = true;
			combination(i, depth + 1);
			selected[i] = false;
		}
	}
	
	public static void calc(){
		int sum1 = 0;
		int sum2 = 0;
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		for (int i=0; i<N; i++){
			if (selected[i]){
				list1.add(i);
			} else{
				list2.add(i);
			}
		}
		
		for (int i=0; i<N/2; i++){
			for (int j=0; j<N/2; j++){
				sum1 += table[list1.get(i)][list1.get(j)];
				sum2 += table[list2.get(i)][list2.get(j)];
			}
		}
		min = Math.min(min, Math.abs(sum1 - sum2));
	}
}