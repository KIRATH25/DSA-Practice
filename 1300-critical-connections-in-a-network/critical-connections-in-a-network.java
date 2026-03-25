class Solution {
  public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer>[] graph = new List[n];
    for (int i = 0; i < n; ++i)
      graph[i] = new ArrayList<>();
    for (List<Integer> connection : connections) {
      final int u = connection.get(0);
      final int v = connection.get(1);
      graph[u].add(v);
      graph[v].add(u);
    }
    int[] rank = new int[n];
    Arrays.fill(rank, NO_RANK);
    getRank(graph, 0, 0, rank, ans);
    return ans;
  }
  private static final int NO_RANK = -2;
  private int getRank(List<Integer>[] graph, int u, int myRank, int[] rank,
                      List<List<Integer>> ans) {
    if (rank[u] != NO_RANK)
      return rank[u];
    rank[u] = myRank;
    int minRank = myRank;
    for (final int v : graph[u]) {
      if (rank[u] == rank.length || rank[v] == myRank - 1)
        continue;
      final int nextRank = getRank(graph, v, myRank + 1, rank, ans);
      if (nextRank == myRank + 1)
        ans.add(Arrays.asList(u, v));
      minRank = Math.min(minRank, nextRank);
    }
    rank[u] = rank.length;
    return minRank;
  }
}