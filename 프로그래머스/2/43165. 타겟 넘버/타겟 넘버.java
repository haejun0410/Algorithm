class Solution {

    int[] numbers;
    int target;

    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        return dfs(0, 0);
    }

    public int dfs(int index, int sum) {
        if (index == numbers.length) {
            return (sum == target) ? 1 : 0;
        }

        return dfs(index + 1, sum + numbers[index]) + dfs(index + 1, sum - numbers[index]);
    }

}