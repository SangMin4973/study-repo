import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		int T = 10;
		Scanner sc = new Scanner(System.in);
		for (int t=1; t<=T; t++) {
			int N = sc.nextInt();
			sc.nextLine();
			List<String> operator = new ArrayList<>(Arrays.asList("+", "-", "*", "/"));
			int answer = 1;
			for (int i=1; i<=N; i++) {
				String str = sc.nextLine();
				List<String> list = new ArrayList<>(Arrays.asList(str.split("\\s+")));					
				if (list.size() == 2) {
					if (operator.contains(list.get(1))){
						answer = 0;
					}
				} else {
					if (!operator.contains(list.get(1))) {
						answer = 0;
					}
				}
			}			

			System.out.println("#" + t + " " + answer);
		}
		sc.close();
	}
}