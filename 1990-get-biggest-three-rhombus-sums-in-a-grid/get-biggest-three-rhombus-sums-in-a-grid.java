class Solution {
    public int[] getBiggestThree(int[][] g) {
        int m=g.length,n=g[0].length;
        TreeSet<Integer>s=new TreeSet<>();
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                for(int k=0;i+k<m&&i-k>=0&&j+2*k<n;k++){
                    int sum=k==0?g[i][j]:f(g,i,j,k);
                    s.add(sum);
                    if(s.size()>3)s.pollFirst();
                }
        int[]r=new int[s.size()];
        int i=0;
        for(int v:s.descendingSet())r[i++]=v;
        return r;
    }
    int f(int[][]g,int x,int y,int k){
        int s=0;
        for(int i=0;i<k;i++){
            s+=g[--x][++y];
        }
        for(int i=0;i<k;i++){
            s+=g[++x][++y];
        }
        for(int i=0;i<k;i++){
            s+=g[++x][--y];
        }
        for(int i=0;i<k;i++){
            s+=g[--x][--y];
        }
        return s;
    }
}