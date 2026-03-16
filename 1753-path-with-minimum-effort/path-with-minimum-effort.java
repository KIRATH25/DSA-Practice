class Solution {
    public int minimumEffortPath(int[][] h) {
        int m=h.length,n=h[0].length;
        int[][] dist=new int[m][n];
        for(int[] r:dist) Arrays.fill(r,Integer.MAX_VALUE);

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0,0,0});
        dist[0][0]=0;

        int[][] d={{1,0},{-1,0},{0,1},{0,-1}};

        while(!pq.isEmpty()){
            int[] c=pq.poll();
            int e=c[0],x=c[1],y=c[2];

            if(x==m-1 && y==n-1) return e;

            for(int[] dir:d){
                int nx=x+dir[0],ny=y+dir[1];
                if(nx>=0&&ny>=0&&nx<m&&ny<n){
                    int ne=Math.max(e,Math.abs(h[x][y]-h[nx][ny]));
                    if(ne<dist[nx][ny]){
                        dist[nx][ny]=ne;
                        pq.add(new int[]{ne,nx,ny});
                    }
                }
            }
        }
        return 0;
    }
}