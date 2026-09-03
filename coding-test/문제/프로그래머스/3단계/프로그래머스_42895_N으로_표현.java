import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
	static List<int[]> combination(int N) {
		List<int[]> list = new ArrayList<>();
		
		for (int i=1; i<N; i++) {
			int[] arr = {i, N-i};
			list.add(arr);
		}		
		return list;
	}
    public int solution(int N, int number) {
        int answer = 0;
        int[][] arr = new int [8][];
        int[] first = {N};
        arr[0] = first;        
        if (N==number) {
        	return 1;
        }
        for (int i=1; i<8; i++) {
        	Set<Integer> set = new HashSet<>();
        	List<int[]> list = combination(i+1);
        	
        	for(int j=0; j<list.size(); j++) {
        		int[] idx = list.get(j);
        		for(int k=0; k<arr[idx[0] - 1].length; k ++) {
        			for(int l=0; l<arr[idx[1] - 1].length; l++) {
        				int n = arr[idx[0] - 1][k];
        				int m = arr[idx[1] - 1][l];
        				
        				if(n==0 || m==0) {
        					continue;
        				}
        				
        				set.add(n + m);
        				set.add(n * m);
        				
        				if (n >= m) {
        					set.add(n - m);
        					if (n%m == 0) {
        						set.add(n/m);
        					}
        				}
        			}
        		}
        	}
        	
        	int cont = 0;
        	for (int k=0; k<=i; k++) {
    			cont += N * Math.pow(10, k);
    		}

    		set.add(cont);
    		
//    		for(int s: set) {
//    			System.out.print(s + " ");
//    		}
//    		System.out.println();
        	
        	arr[i] = set.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
        	
        	if (set.contains(number)) {
        		answer = i;
        		return answer + 1;
    		}
        }
        
        return -1;
    }
}