package guvidsa;

import java.util.Arrays;

public class TravelingSalesperson {

    private static final int INF = 1000000000;

    // Function to solve TSP using dynamic programming with bit masking
    public static int tsp(int[][] graph) {
        int n = graph.length;
        int[][] dp = new int[n][(1 << n)];

        // Initialize the dp array with INF
        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }

        // Start from the first city (0)
        dp[0][1] = 0;

        // Iterate over all subsets of cities
        for (int mask = 1; mask < (1 << n); mask += 2) {
            for (int u = 0; u < n; u++) {
                if ((mask & (1 << u)) != 0) {
                    for (int v = 0; v < n; v++) {
                        if ((mask & (1 << v)) == 0 && graph[u][v] != INF) {
                            int newMask = mask | (1 << v);
                            dp[v][newMask] = Math.min(dp[v][newMask], dp[u][mask] + graph[u][v]);
                        }
                    }
                }
            }
        }

        // Find the minimum cost to complete the tour
        int minCost = INF;
        for (int u = 1; u < n; u++) {
            if (graph[u][0] != INF) {
                minCost = Math.min(minCost, dp[u][(1 << n) - 1] + graph[u][0]);
            }
        }

        return minCost;
    }

    public static void main(String[] args) {
        int[][] graph = {
            {INF, 10, 15, 20},
            {5, INF, 9, 10},
            {6, 13, INF, 12},
            {8, 8, 9, INF}
        };

        int minCost = tsp(graph);
        System.out.println("Minimum Cost: " + minCost);
    }
}
