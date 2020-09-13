class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Queue<Node> queue = new LinkedList<Node>();
        int color = image[sr][sc];
        if (color == newColor) return image;
        queue.add(new Node(sr, sc));
        
        while (!queue.isEmpty()) {
            Node curr = queue.remove();
            int r = curr.r, c = curr.c;
            if (image[r][c] == color) {
                image[r][c] = newColor;
                if (r - 1 >= 0) queue.add(new Node(r - 1, c));
                if (r + 1 < image.length) queue.add(new Node(r + 1, c));
                if (c - 1 >= 0) queue.add(new Node(r, c - 1));
                if (c + 1 < image[0].length) queue.add(new Node(r, c + 1));
            }
        }
        return image;
    }

    class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
