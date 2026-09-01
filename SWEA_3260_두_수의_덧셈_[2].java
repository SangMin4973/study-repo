import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main_3260 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for (int t=1; t<=T; t++) {
		
			String A = sc.next();
			String B = sc.next();
			
			int aIdx = A.length() - 1;
			int bIdx = B.length() - 1;
			
			StringBuilder result = new StringBuilder();

			int n = 0;
			
			while (aIdx >= 0 || bIdx >= 0 || n > 0) {
				int sum = n;
				if (aIdx >= 0) {
					sum += A.charAt(aIdx) - '0';
					aIdx--;
				}
				
				if (bIdx >= 0) {
					sum += B.charAt(bIdx) - '0';
					bIdx--;
				}
				
				result.append(sum % 10);
				n = sum / 10;
			}

			System.out.println("#" + t + " " + result.reverse());
		}
		
		sc.close();
	}
}