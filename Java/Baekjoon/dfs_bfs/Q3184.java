package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *@source: https://www.acmicpc.net/problem/3184 (양)
 *@classfication: dfs
 **/
public class Q3184 {
    static char[][] graph;
    static int[][] visited;
    static int sheepAll = 0;
    static int wolfAll = 0;
    static int sheep = 0;
    static int wolf = 0;
    static int[] dx = new int[]{-1,1,0,0};
    static int[] dy = new int[]{0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        graph = new char[R][C];
        visited = new int[R][C];

        for(int i=0;i<R;i++) {
            String str = br.readLine();
            for(int j=0;j<str.length();j++) {
                graph[i][j] = str.charAt(j);
            }
        }
        br.close();

        for(int i=0;i<graph.length;i++) {
            for(int j=0;j<graph[0].length;j++) {
                if(graph[i][j] == '#') continue;
                else {
                    if(visited[i][j] != 1) {
                        dfs(i, j);

                        if(sheep > wolf) {
                            sheepAll += sheep;
                        } else {
                            wolfAll += wolf;
                        }

                        sheep = wolf = 0;
                    }
                }
            }
        }

        System.out.print(sheepAll+" "+wolfAll);
    }

    private static void dfs(int i, int j) {
        visited[i][j] = 1;

        if(graph[i][j] == 'o') ++sheep;
        else if(graph[i][j] == 'v') ++wolf;

        for(int k=0;k<4;k++) {
            int nx = i+dx[k];
            int ny = j+dy[k];


            if(nx >=0 && nx < graph.length && ny >= 0 && ny < graph[0].length) {
                if(graph[nx][ny] != '#' && visited[nx][ny] == 0) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
