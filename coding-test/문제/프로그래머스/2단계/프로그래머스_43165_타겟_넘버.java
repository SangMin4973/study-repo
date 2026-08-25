class Solution {
    int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }

    void dfs(int[] numbers, int target, int idx, int result) {
        if (idx == numbers.length) {
            if (result == target) {
                answer++;
            }
            return;
        }

        dfs(numbers, target, idx + 1, result + numbers[idx]);
        dfs(numbers, target, idx + 1, result - numbers[idx]);
    }
}