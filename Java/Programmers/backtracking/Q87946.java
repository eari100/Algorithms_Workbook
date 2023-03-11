package Programmers.backtracking;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/87946 (피로도)
 * @classfication: backtracking
 * @문제 푼 날짜 (자력으로 풂?): 23.03.11 (O)
 * @memo: k >= 최소 피로도 일 경우의 분기처리를 빠뜨려서 잠시 헤맸다
 **/
public class Q87946 {
    static int maxDungeonsCnt;

    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];

        dfs(dungeons, visited, k, 0, 0);

        return maxDungeonsCnt;
    }

    private void dfs(int[][] dungeons, boolean[] visited, int k, int depth, int dungeonsCnt) {
        if(depth == dungeons.length)
            maxDungeonsCnt = Math.max(maxDungeonsCnt, dungeonsCnt);

        for(int i=0;i<dungeons.length;i++) {
            int 최소_필요_피로도 = dungeons[i][0];
            int 소모_피로도 = dungeons[i][1];

            if(visited[i]) continue;
            visited[i] = true;
            if(k < 최소_필요_피로도)
                dfs(dungeons, visited, k, depth+1, dungeonsCnt);
            else
                dfs(dungeons, visited, k-소모_피로도, depth+1, dungeonsCnt+1);

            visited[i] = false;
        }
    }
}
