import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
	
	static ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	
	public static void factor(int n, int min, List<Integer> current){
		current.add(n);
		result.add(new ArrayList<>(current));
		current.remove(current.size() - 1);
		
		for(int i=min; (long)i*i<=n; i++) {
			if (n % i == 0) {
				current.add(i);
				
				factor(n/i, i, current);
				
				current.remove(current.size() - 1);
			}
		}
	}
	
	
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int T = sc.nextInt();

    	for(int t=1; t<=T; t++) {        
	        String str = sc.nextLine();
	        str = str.replace(" ", "");
	        List<Integer> possible = new ArrayList<>();
	        for (int i = 0; i < 10; i++) {
	            if (sc.nextInt() == 1) {
	                possible.add(i);
	            }
	        }
	       
	        
	        int n = sc.nextInt();
	        
	        result.clear();
	        factor(n, 2, new ArrayList<>());
	        
	        
	        int min = Integer.MAX_VALUE;
	        
	        for (int i=0; i<result.size(); i++) {
	        	int cnt = 0;
	        	for (int e : result.get(i)) {
	        		String s = String.valueOf(e);
	        		
	        		for (int j=0; j<s.length(); j++) {
	        			if (possible.contains(s.charAt(j) - '0')) {
	        				cnt++;
	        			} else {
	        				cnt = -1;
	        				break;
	        			}
	        		}
	        		
	        		if (cnt==-1) {
	        			break;
	        		} else {
	        			cnt++;
	        		}        		
	        	}
	        	if (cnt != -1 && cnt < min) {
	        		min = cnt;
	        	}	  
	        }
	        
	        if (min == Integer.MAX_VALUE) {
	        	min = -1;
	        	}
	        System.out.println("#" + t + " " + min);
	    }
    }
}
