import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Node {
	int x, y;
	
	Node(int x, int y){
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return x + " " + y;
	}
}


public class Solution {
	static Node house;
	static Node company;
	static List<Node> list;
	static int min;
	static int N;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t=1; t<=T; t++) {
			
			N = sc.nextInt();
			
			company = new Node(sc.nextInt(), sc.nextInt());
			house = new Node(sc.nextInt(), sc.nextInt());
			
			list = new ArrayList<>();
				
			for (int i=0; i<N; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				list.add(new Node(x, y));
			}
			
			boolean visited[] = new boolean[N];
			
			
			min = Integer.MAX_VALUE;
	
			calc(house, visited, 0, 0);
				
			System.out.println("#" + t + " " + min);
		}
	
	}
	
	static void calc(Node start, boolean[] visited, int cnt, int sum) {
		if (sum >= min) {
			return;
		}
		
		if (cnt == N) {
			
			sum += Math.abs(start.x - company.x) + Math.abs(start.y - company.y);
			
			min = Math.min(min, sum);
			
			return;
		}
		
		for (int i=0; i<N; i++) {
			if (!visited[i]) {
				Node next = list.get(i);
				
				int distance = Math.abs(start.x - list.get(i).x) + Math.abs(start.y - list.get(i).y);
				
				visited[i] = true;
				
				calc(next, visited, cnt+1, sum + distance);
				
				visited[i] = false;
			}
		}
	}
}

