package algo_workshop;


class Solution_등굣길{
		static final long MOD = 1_000_000_007L;
		public long solution(int m, int n, int[][] puddles) {
			long answer = 0;
			int[][] map = new int[n][m];
			
	        
	        for(int[] puddle : puddles) {
				map[puddle[1] - 1][puddle[0] - 1] = -1;
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if (map[i][j] == -1) {
						map[i][j] = 0;
						continue;
					} 
					if (i > 0) {
	                    map[i][j] += map[i - 1][j];
	                }

	                // 왼쪽에서 오는 경우
	                if (j > 0) {
	                    map[i][j] += map[i][j - 1];
	                }
					
				}				
			}
			
			answer = map[n-1][m-1] % MOD;

			return answer;
	    }
		
}

public class Main_등굣길 {
	public static void main(String[] args) {
		int m = 7;
		int n = 6;
		int[][] puddles = {{5, 1}, {3, 3}};
		Solution_등굣길 s = new Solution_등굣길();
		System.out.println(s.solution(m, n, puddles));
	}
}
