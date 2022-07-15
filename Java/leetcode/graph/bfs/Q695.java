package leetcode.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @source: https://leetcode.com/problems/max-area-of-island/ (Max Area of Island)
 * @classfication: bfs
 * @문제 푼 날짜 (혼자 힘으로 풂?)
 * 2. 22.07.15 (O)
 **/
public class Q695 {
    static int[] nx;
    static int[] ny;

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        nx = new int[]{-1, 1, 0, 0};
        ny = new int[]{0, 0, -1, 1};

        for(int x=0;x<grid.length;x++) {
            for(int y=0;y<grid[0].length;y++) {
                if(grid[x][y] == 1)
                    max = Math.max(max, bfs(grid, x, y));
            }
        }

        return max;
    }

    private int bfs(int[][] grid, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        int areaSize = 1;
        grid[x][y] = 0;

        while( !queue.isEmpty() ) {
            int[] poll = queue.poll();

            for(int i=0;i<nx.length;i++) {
                int dx =  poll[0] + nx[i];
                int dy =  poll[1] + ny[i];

                if(dx < 0 || dx > grid.length-1 || dy < 0 || dy > grid[0].length-1) continue;

                if(grid[dx][dy] == 1) {
                    grid[dx][dy] = 0;
                    queue.offer(new int[]{dx, dy});
                    ++areaSize;
                }
            }
        }

        return areaSize;
    }
}
