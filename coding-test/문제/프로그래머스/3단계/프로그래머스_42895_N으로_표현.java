package algo_workshop;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution_N으로표현 {

    public int solution(int N, int number) {
        Set<Integer>[] dp = new HashSet[9];
        
        for(int i=1; i<=8; i++) {
        	dp[i] = new HashSet<>();
        	
        	int repeated = 0;
        	for (int k=0; k<i; k++) {
        		repeated = repeated * 10 + N;
        	}
        	
        	dp[i].add(repeated);
        	
        	for (int j=1; j<i; j++) {
        		for (int a: dp[j]) {
        			for (int b: dp[i-j]) {
        				dp[i].add(a + b);
        				dp[i].add(a - b);
        				dp[i].add(a * b);
        				
        				if (b != 0) {
        					dp[i].add(a / b);
        				}
        			}
        		}
        	}
        	if (dp[i].contains(number)) {
        		return i;
        	}
        }
        return -1;
    }
}

public class Main_N으로표현 {
	public static void main(String[] args) {
		Solution_N으로표현 s = new Solution_N으로표현();
		System.out.println(s.solution(5, 5));
	}
}
 