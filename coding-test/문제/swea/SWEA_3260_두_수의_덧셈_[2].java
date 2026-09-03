import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for (int t=1; t<=T; t++) {
			
			String[] input =sc.nextLine().split(" ");
			String A;
			String B;
			if (input[0].length() >= input[1].length()) {
				A = input[0];
				B = input[1];
			} else {
				A = input[1];
				B = input[0];
			}
			
			
			Stack<Integer> stackA = new Stack<>();
			Stack<Integer> stackB = new Stack<>();
			
			for (int i=0; i<A.length(); i++) {
				int num = A.charAt(i) - '0';
				stackA.push(num);
			}
			
			for (int i=0; i<B.length(); i++) {
				int num = B.charAt(i) - '0';
				stackB.push(num);
			}
			
			List<Integer> list = new ArrayList<>();
			int n = 0;
			while (!stackA.isEmpty() && !stackB.isEmpty()) {
				int a = stackA.pop();
				int b = stackB.pop();
				int sum = a + b + n;
				
				list.add(sum % 10);
				n = sum / 10;
				
			}
			
			while (!stackA.isEmpty()) {
			    int sum = stackA.pop() + n;

			    list.add(sum % 10);
			    n = sum / 10;
			}
			
			if (n > 0) {
				list.add(n);
			}
			
			StringBuilder sb = new StringBuilder();
	
			for (int i=1; i<=list.size(); i++) {
				sb.append(list.get(list.size() - i));
			}

			System.out.println("#" + t + " " + sb.toString());
		}
	}
}
