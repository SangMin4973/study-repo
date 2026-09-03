import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		int T = 10;
		Scanner sc = new Scanner(System.in);
		for (int t=1; t<=T; t++) {
			
			int tc = sc.nextInt();
			Deque<Integer> dq = new ArrayDeque<>();
			
			for (int i=0; i<8; i++) {
				dq.add(sc.nextInt());
			}
			
			int num = 0;
			
			while (true) {
				if (num == 5) {
					num = 0;
				}
				
				num += 1;
				int next = dq.pollFirst() - num;
				
				if (next <= 0) {
					dq.addLast(0);
					break;
				} else {
					dq.addLast(next);
				}
			}
			
			String answer = "";
			
			while (!dq.isEmpty()) {
				answer += dq.pollFirst().toString() + " ";
			}
			
			System.out.println("#" + t + " " + answer.trim());
		}
	}
}