import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Solution1{
	public String solution(int N, int M) {
 		int[] nList = new int[N];
		int[] mList = new int[M];
		
		for (int i=0; i<N; i++) {
			nList[i] = i + 1;
		}
		
		for (int i=0; i<M; i++) {
			mList[i] = i + 1;
		}
		
		int[] sum = new int[N * M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sum[i * M + j] = nList[i] + mList[j];
			}
		}
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int s: sum) {
			if (map.containsKey(s)) {
				map.put(s, map.get(s) + 1);
			} else {
				map.put(s, 1);
			}			
		}
		
		String answer = " ";
		int num = 0;
		
		
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > num) {
				answer = entry.getKey().toString() + " ";
				num = entry.getValue();
			} else if ( entry.getValue() == num) {
				answer += entry.getKey().toString() + " ";
			}
		}
		
		return answer;
	}
}


public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for (int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			Solution1 s = new Solution1();
			System.out.println("#" + t + " " + s.solution(N, M));	
		}
		sc.close();
	}
}