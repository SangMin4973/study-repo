class Solution{
	public int solution(int[][] triangle) {
		int answer = 0;
		int height = triangle.length - 1;
		
		while (height > 0) {
			for (int i=0; i<triangle[height - 1].length; i++) {
				triangle[height - 1][i] += Math.max(triangle[height][i], triangle[height][i+1]);
			}
			
			height--;
		}
		
		answer = triangle[0][0];	
		return answer;
	}
}