package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @source: https://www.acmicpc.net/problem/9328 (열쇠)
 * @classification: bfs
 * @문제 푼 날짜 (자력으로 풂?): 25.02.09 (O)
 **/
public class Q9328 {
    static final int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static char[][] board;
    static boolean[][] visited;
    static HashMap<Character, List<int[]>> doors;
    static int h, w;
    static HashSet<Character> keys;
    static Queue<int[]> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder result = new StringBuilder();

        while(t-- > 0) {
            int goal = 0;
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            q = new LinkedList<>();
            doors = new HashMap<>();
            keys = new HashSet<>();

            board = new char[h][w];
            visited = new boolean[h][w];

            for(int i=0;i<h;i++) {
                String row = br.readLine();
                for(int j=0;j<w;j++) {
                    char obj = row.charAt(j);
                    board[i][j] = obj;

                    if(i == 0 || i == h-1 || j == 0 || j == w-1) {
                        if(obj == '.') {
                            q.offer(new int[]{i, j});
                            visited[i][j] = true;
                        } else if(isKey(obj)) {
                            q.offer(new int[]{i, j});
                            keys.add(toggleCase(obj));
                            visited[i][j] = true;
                        } else if(isDoor(obj)) {
                            List<int[]> dirs = doors.getOrDefault(obj, new ArrayList<>());
                            dirs.add(new int[]{i, j});
                            doors.put(obj, dirs);
                            visited[i][j] = true;
                        } else if(obj == '$') {
                            ++goal;
                            q.offer(new int[]{i, j});
                            visited[i][j] = true;
                        }
                    }
                }
            }

            String key_str = br.readLine();

            if( !key_str.equals("0") ) {
                for(char key : key_str.toCharArray()) {
                    keys.add(toggleCase(key));
                }
            }

            unLock();

            while( !q.isEmpty() ) {
                int[] poll = q.poll();

                for(int[] move : moves) {
                    int x = poll[0] + move[0];
                    int y = poll[1] + move[1];

                    if(x < 0 || x >= h || y < 0 || y >= w) {
                        continue;
                    }

                    if(visited[x][y]) continue;
                    if(board[x][y] == '*') continue;

                    visited[x][y] = true;

                    if(board[x][y] == '.') {
                        q.offer(new int[]{x, y});
                    } else if(isKey(board[x][y])) {
                        q.offer(new int[]{x, y});
                        keys.add(toggleCase(board[x][y]));
                    } else if(isDoor(board[x][y])) {
                        List<int[]> dirs = doors.getOrDefault(board[x][y], new ArrayList<>());
                        dirs.add(new int[]{x, y});
                        doors.put(board[x][y], dirs);
                    } else if(board[x][y] == '$') {
                        ++goal;
                        q.offer(new int[]{x, y});
                    }
                }

                unLock();
            }

            result.append(goal).append('\n');
        }

        br.close();

        System.out.print(result);
    }

    private static boolean isDoor(char c) {
        return c >= 'A' && c <= 'Z';
    }

    private static boolean isKey(char c) {
        return c >= 'a' && c <= 'z';
    }

    private static char toggleCase(char c) {
        return (char) (c ^ 0x20);
    }

    private static void unLock() {
        for(char key : keys) {
            if(doors.containsKey(key)) {
                List<int[]> dirs = doors.get(key);

                for(int[] dir : dirs) {
                    int x = dir[0], y = dir[1];
                    q.offer(new int[]{x, y});
                }

                doors.remove(key);
            }
        }
    }
}
