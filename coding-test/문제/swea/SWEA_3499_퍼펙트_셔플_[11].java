import java.util.Scanner;

class Solution_3499{
	public String solution(String str) {
		String answer = "";
		String[] arr = str.split(" ");
		
		for (int i=0; i<arr.length/2; i++) {
			answer += arr[i] + " ";
			if (arr.length % 2 == 1) {
				answer += arr[arr.length/2 + 1 + i] + " ";
			} else {
				answer += arr[arr.length/2 + i] + " ";
			}
		}
		
		if (arr.length % 2 == 1) {
			answer += arr[arr.length/2];
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
			sc.nextLine();
			String str = sc.nextLine();
			Solution_3499 s = new Solution_3499();
			
			System.out.println("#" + t + " " + s.solution(str));
		}
		
	}
}