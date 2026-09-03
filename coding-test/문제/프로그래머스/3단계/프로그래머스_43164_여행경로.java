import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
class Solution{
    public String[] solution(String[][] tickets) {
        Deque<String> answer = new ArrayDeque<>();
        Map<String, Queue<String>> map = new HashMap<>();
        
        for (String[] list: tickets) {
        	if (!map.containsKey(list[0])) {
        		map.put(list[0], new PriorityQueue<>());       	
        	}
        	map.get(list[0]).offer(list[1]);
        }
        
  
        String start = "ICN";
        plan(map, start, answer);
        
        
        return answer.toArray(new String[0]);
    }
    
    public void plan(Map<String, Queue<String>> map, String start, Deque<String> answer) {
    	
    	Queue<String> queue = map.get(start);
    	
    	while (queue != null && !queue.isEmpty() ) {
    		String next = queue.poll();
    		plan(map, next, answer);
    	}
    	
    	answer.offerFirst(start);
    		
    }

}
