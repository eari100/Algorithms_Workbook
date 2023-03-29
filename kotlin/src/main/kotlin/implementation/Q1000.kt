package implementation

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

/**
 * @source: https://www.acmicpc.net/problem/1000 (A+B)
 * @classfication: implementation
 * @문제 푼 날짜 (혼자 힘으로 풂?): 23.03.30 (O)
 **/
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val st = StringTokenizer(br.readLine())
    val A = Integer.parseInt(st.nextToken())
    val B = Integer.parseInt(st.nextToken())

    print(A+B)
}