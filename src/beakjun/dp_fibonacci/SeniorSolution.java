package beakjun.dp_fibonacci;

public class SeniorSolution {
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int oneStepBefore = 2; // dp[2]
        int twoStepsBefore = 1; // dp[1]
        int allWays = 0;

        for (int i = 3; i <= n; i++) {
            allWays = oneStepBefore + twoStepsBefore;
            twoStepsBefore = oneStepBefore;
            oneStepBefore = allWays;
        }

        return allWays;
    }
}
