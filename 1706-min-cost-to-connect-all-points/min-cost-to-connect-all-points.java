class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        int result = 0;

        for (int i = 0; i < n; i++) {
            int u = -1;

            for (int j = 0; j < n; j++) {
                if (!visited[j] && (u == -1 || dist[j] < dist[u])) {
                    u = j;
                }
            }

            visited[u] = true;
            result += dist[u];

            for (int v = 0; v < n; v++) {
                if (!visited[v]) {
                    int cost = Math.abs(points[u][0] - points[v][0]) +
                               Math.abs(points[u][1] - points[v][1]);

                    if (cost < dist[v]) {
                        dist[v] = cost;
                    }
                }
            }
        }

        return result;
    }
}