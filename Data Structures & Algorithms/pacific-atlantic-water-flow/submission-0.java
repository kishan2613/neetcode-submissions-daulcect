class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
       int m = heights.length;
       int n = heights[0].length;

       boolean[][] pacific = new boolean[m][n];
       boolean[][] atlantic = new boolean[m][n];

       Queue<int[]> pq = new LinkedList<>();
       Queue<int[]> aq = new LinkedList<>();

       // Pacific: left column
for (int i = 0; i < m; i++) {
    pacific[i][0] = true;
    pq.offer(new int[]{i, 0});
}

// Pacific: top row
for (int c = 0; c < n; c++) {
    pacific[0][c] = true;
    pq.offer(new int[]{0, c});
}

// Atlantic: right column
for (int r = 0; r < m; r++) {
    atlantic[r][n - 1] = true;
    aq.offer(new int[]{r, n - 1});
}

// Atlantic: bottom row
for (int c = 0; c < n; c++) {
    atlantic[m - 1][c] = true;
    aq.offer(new int[]{m - 1, c});
}
        
            bfs(heights, pacific, pq);
        bfs(heights, atlantic, aq);

                List<List<Integer>> result = new ArrayList<>();

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void bfs(
        int[][] heights,
        boolean[][] visited,
        Queue<int[]> queue
    ) {
        int m = heights.length;
        int n = heights[0].length;

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int r = current[0];
            int c = current[1];

            for (int[] dir : directions) {

                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr < 0 || nr >= m ||
                    nc < 0 || nc >= n) {
                    continue;
                }

                if (visited[nr][nc]) {
                    continue;
                }

                // Reverse the water-flow condition
                if (heights[nr][nc] < heights[r][c]) {
                    continue;
                }

                visited[nr][nc] = true;
                queue.offer(new int[]{nr, nc});
            }
        }
    }
}
