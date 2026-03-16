class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new ArrayList[n+1];

    for (int i = 1; i <= n; i++)
        graph[i] = new ArrayList<>();

    for (int[] t : times) {
        int u = t[0];
        int v = t[1];
        int w = t[2];

        graph[u].add(new int[]{v,w});
    }
    
    int[] dist = new int[n+1];
    Arrays.fill(dist,Integer.MAX_VALUE);

    PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);

    dist[k] = 0;
    pq.add(new int[]{k,0});

    while (!pq.isEmpty()) {

        int[] curr = pq.poll();
        int node = curr[0];
        int time = curr[1];

        for (int[] edge : graph[node]) {

            int next = edge[0];
            int weight = edge[1];

            if (time + weight < dist[next]) {

                dist[next] = time + weight;
                pq.add(new int[]{next, dist[next]});
            }
        }
    } 

    int ans = 0;

    for (int i = 1; i <= n; i++){

        if (dist[i] == Integer.MAX_VALUE)
           return -1;

        ans = Math.max(ans, dist[i]);
    }

   return ans;


    }
}
