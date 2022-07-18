package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Node {
    private int index;
    private List<Node> list = new ArrayList<>();
    private boolean visited;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean getVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Node> getList() {
        return list;
    }

    public void addList(Node node) {
        this.list.add(node);
    }
}

/**
 * @source: https://www.acmicpc.net/problem/15900 (나무 탈출)
 * @classfication: dfs
 * @문제 푼 날짜 (혼자 힘으로 풂?)
 * 1. 22.07.19 (O)
 **/
public class Q15900 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<Node> nodeList = new ArrayList<>();

        for(int i=0;i<N+1;i++)
            nodeList.add(new Node());

        for(int i=0;i<N-1;i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            nodeList.get(a).setIndex(a);
            nodeList.get(b).setIndex(b);

            nodeList.get(a).addList(nodeList.get(b));
            nodeList.get(b).addList(nodeList.get(a));
        }

        br.close();

        System.out.print(dfs(nodeList.get(1), 0) % 2 == 0 ? "No" : "Yes");
    }

    private static int dfs(Node parent, int dist) {
        parent.setVisited(true);
        int result = 0;

        boolean visitedFlag = false;
        for(Node child : parent.getList()) {
            if( !child.getVisited() ) {
                visitedFlag = true;
                result += dfs(child, dist+1);
            }
        }

        return visitedFlag ? result : dist;
    }
}