import java.util.ArrayDeque;
import java.util.Deque;


class Solution {
	static int[] moveX = {1, 0, -1, 0};
	static int[] moveY = {0, -1, 0, 1};
	
    public int solution(int[][] maps) {
        int answer = -1;
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] {0, 0});
        int prev = 0;
        int[] pos;
        int cx;
        int cy;
        while (!dq.isEmpty()) {
        	pos = dq.pollFirst();
        	cx = pos[0];
        	cy = pos[1];
        	if (cx == (maps.length - 1) && cy == (maps[0].length - 1)) {
        		answer = maps[cx][cy];
        		break;
        	}        

        	for (int i=0; i<4; i++) {
        		int rx = cx + moveX[i];
        		int ry = cy + moveY[i];
        		
        		if(rx < 0 || ry < 0 || rx >= maps.length || ry >= maps[0].length) {
            		continue;
            	}
        		
        		if (maps[rx][ry] != 1) {
            		continue;
            	}
        		maps[rx][ry] += maps[cx][cy];        		
        		dq.offer(new int[] {rx, ry});
        	}
        }        
        return answer;
        
    }
}