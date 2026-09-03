import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Solution_26956{
	public String solution(int[] arr, int M, int K) {
		
		Deque<Integer> dq = new ArrayDeque<>();
		
		for (int a:arr) {
			dq.offer(a);
		}

		int cnt = 0;
		for (int k=0; k<K; k++) {
			for (int i=0; i<M; i++) {
				dq.offer(dq.poll());
				cnt--;
				
				if (cnt < 0) {
					cnt += dq.size();
				}
				
				if (i==M-1) {
					dq.offerFirst(dq.peekFirst() + dq.peekLast());
					cnt++;
				}					
			}
		}
		for (int i=0; i<cnt; i++) {
			dq.offerLast(dq.pollFirst());
		}

		String answer = "";
		int n = 1;
		
		while (!dq.isEmpty()) {
			if(n>10) {
				break;
			}
			answer += dq.pollLast() + " ";
			n++;
		}
		
		return answer;
	}
}
class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		
		for (int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			int[] arr = new int[N];
			for (int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			
			Solution_26956 s = new Solution_26956();
			
			System.out.println("#" + t + " " + s.solution(arr, M, K));
		}
	}
}
