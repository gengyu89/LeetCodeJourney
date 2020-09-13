class Solution {
    private int dist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    public int[][] kClosest(int[][] points, int K) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p1, p2) -> dist(p2) - dist(p1));
        for (int[] p : points) {
            pq.offer(p);
            if (pq.size() > K) {
                pq.poll();
            }
        }
        int[][] res = new int[K][2];
        while (K > 0) {
            res[--K] = pq.poll();
        }
        return res;
    }
}
