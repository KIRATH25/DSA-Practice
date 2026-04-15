class Solution {    
    int mod = 1000000007;
    public int waysToBuildRooms(int[] prevRoom) {
        int n = prevRoom.length;
        ArrayList<Integer>[] tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList();
        }
        for (int i = 1; i < prevRoom.length; i++) {
            tree[prevRoom[i]].add(i);
        }
        int[] size = new int[n];
        dfs(tree, size, 0);
        long nFact = 1;
        for (int i = 2; i <= n; i++) {
            nFact = (nFact * i) % mod;
        }
        long den = 1;
        for (int i = 0; i < n; i++) {
            den = (den * size[i]) % mod;
        }
        int d = (int) (den);
        int inverse = modInverse(d, mod);   
        return (int)((nFact * inverse) % mod);
    }
    public int dfs(ArrayList<Integer>[] tree, int[] size, int root) {
        int ans = 1;
        for (int e : tree[root]) {
            ans += dfs(tree, size, e);
        }   
        size[root] = ans;
        return ans;
    }
    int modInverse(int a, int m) {
        return power(a, m - 2, m);
    }
    int power(int x, int y, int m) {
        if (y == 0)
            return 1;
        int p = power(x, y / 2, m) % m;
        p = (int)((p * (long)p) % m);
        if (y % 2 == 0)
            return p;
        else
            return (int)((x * (long)p) % m);
    }
}