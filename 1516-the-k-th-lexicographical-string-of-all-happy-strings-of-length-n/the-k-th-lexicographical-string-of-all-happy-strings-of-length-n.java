class Solution {
    public String getHappyString(int n, int k) {
        Map<Character, String> nextOptions = Map.of(
            'a', "bc",
            'b', "ac",
            'c', "ab"
        );
        Queue<String> queue = new ArrayDeque<>();
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        while (!queue.isEmpty() && queue.peek().length() < n) {
            String cur = queue.poll();
            char lastChar = cur.charAt(cur.length() - 1);
            for (char next : nextOptions.get(lastChar).toCharArray()) {
                queue.offer(cur + next);
            }
        }
        if (queue.size() < k) return "";
        for (int i = 0; i < k - 1; i++) {
            queue.poll();
        }
        return queue.poll();
    }
}