package Baekjoon.segmentTree;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/11659 (구간 합 구하기 4)
 * @classfication: segment tree
 * @reference: https://codingnojam.tistory.com/49
 **/
public class Q11659 {
    // 세그먼트 트리를 구현할 배열
    private static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];

        st = new StringTokenizer(br.readLine());

        for(int i=1;i<N+1;i++)
            arr[i] = Integer.parseInt(st.nextToken());

        // 세그먼트 트리 생성
        SegmentTree segmentTree = new SegmentTree(N);
        segmentTree.init(arr, 1, 1, N);

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int str = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            long result = segmentTree.sum(1, 1, N, str, end);
            bw.write(String.valueOf(result));
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }

    static class SegmentTree{
        // 세그먼트 트리를 구현할 배열
        private long[] tree;

        // 생성자에서 세그먼트 트리의 전체노드 수 계산 (즉, 배열 길이)
        SegmentTree(int n) {
            // 트리의 높이 계산
            double treeHeight = Math.ceil(Math.log(n)/Math.log(2))+1;
            // 트리의 노드 수 계산
            long treeNodeCount = Math.round(Math.pow(2, treeHeight));
            // 트리의 길이 설정
            tree = new long[Math.toIntExact(treeNodeCount)];
        }

        // 세그먼트 트리의 노드 값 초기화
        long init(int[] arr, int node, int start, int end){
            // 세그먼트 트리의 리프노드인 경우
            if (start == end) {
                // 리프노드에 배열의 값 저장 후 리턴
                return tree[node] = arr[start];
            }else{
                // 리프노드가 아닌 경우에는 자식노드의 값을 더해서 노드의 값 초기화 후 리턴
                return tree[node] = init(arr, node*2, start, (start+end)/2)
                        + init(arr, node*2+1, (start+end)/2+1, end);
            }
        }

        // 배열의 특정 구간 합을 세그먼트 트리로 구하기
        long sum(int node, int start, int end, int left, int right) {
            // 노드가 가지는 값의 구간이 구하려고 하는 합의 구간에 속하지 않는 경우 0리턴
            if (end < left || right < start) {
                return 0;
            } else if (left <= start && end <= right) {
                // 노드가 가지는 값의 구간이 구하려고 하는 합의 구간에 속하는 경우 노드 값 리턴
                return tree[node];
            } else {
                // 그 외는 2가지 경우가 존재
                // 1. 노드가 가지는 값의 구간이 구하려고 하는 합의 구간에 일부는 속하고 일부는 속하지 않는 경우
                // 2. 노드가 가지는 값의 구간이 구하려고 하는 합의 구간을 모두 포함하는 경우
                // 이와 같은 경우에는 자식노드를 탐색해서 값을 리턴
                return sum(node*2, start, (start+end)/2, left, right)
                        + sum(node*2+1, (start+end)/2+1, end, left, right);
            }
        }
    }
}
